package com.mvc;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.util.DayTime;
import com.util.HangulConversion;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
		Logger logger =Logger.getLogger(BoardController.class);
	   //글쓰기 화면 제공 - 메소드이름으로 매핑하자
	   //웹서비스는 브라우저에서 부르니까 url패턴으로 해야한다
	   //결과페이지 필요하다 리턴값 String, 필요없다 void
		@Autowired
		public BoardLogic boardLogic=null;
	   @RequestMapping(value="writeForm.kosmo")
	   public String writeForm(){
	      return "redirect:writeForm.jsp";
	   }
	   //글상세 처리 구현
	   @RequestMapping(value="getBoardDetail.kosmo")
	   public String getBoardDetail(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO)
	   {
		   List<Map<String,Object>> boardList =null;
		   boardList=boardLogic.getBoardList(pbmVO,null);
		   logger.info("boardList.size():"+boardList.size());
		   mMap.put("boardList",boardList);
		   return "forward:Read.jsp";
	   }
	   //글쓰기 처리 구현
	   /*
	    * 스프링에서는 사용자가 입력한 정보(반복코드:request.getParameter())를 
	    * 받기 위한 코드를 줄여주기 위해서
	    * @ModelAttribute 와 @RequestParam API를 지원하고 있습니다.
	    */
	   @RequestMapping(value="boardInsert.kosmo")
	   public String boardInsert(@RequestParam("bfile") MultipartFile bfile,@ModelAttribute BoardMasterVO pbmVO,BoardSubVO pbsVO){
		   String fileName = HangulConversion.toKor
					(bfile.getOriginalFilename());
	logger.info("fileName:"+fileName);
	String path = "C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
	//첨부파일 중복처리하기 - 파일 history관리
	//test.zip -> test_20170210161910.zip	
	//1)파일이름만 떼어내기(test)
	String onlyFileName = 
		fileName.substring(0, fileName.indexOf("."));
	logger.info("onlyFileName : "+onlyFileName);
	//2)확장자만 떼어내기(.zip)
	String extension = fileName.substring(fileName.indexOf("."));
	//3)파일이름 재정의하기
	String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
	pbsVO.setB_file(rename);
	if(bfile !=null){//첨부파일 추가했니?
	//실제 존재하는 파일이름을 객체로 생성해주는 클래스
	//파일에 들어있는 내용까지 생성되는 것은 아니다.
	File file = new File(path+rename);
	try {
		//복제한 파일안에 출력한 바이트를 담는 배열
		byte[] bytes = bfile.getBytes();//123
		//파일의 크기
		long size =file.length();
		pbsVO.setB_size(size);//byte
		BufferedOutputStream bos
		=new BufferedOutputStream(
			new FileOutputStream(file));
		bos.write(bytes);//123출력
		bos.close();
	} catch (Exception e) {
		logger.info(e.toString());
	}
	}/////////////////end of if
	
	//post방식일 경우 tokor함수를 태워야 한다.
		pbmVO.setB_title(HangulConversion.toKor(pbmVO.getB_title()));
		pbmVO.setB_name(HangulConversion.toKor(pbmVO.getB_name()));
		pbmVO.setB_content(HangulConversion.toKor(pbmVO.getB_content()));
	   logger.info("boardInsert");
	   int results[] =null;
	   results  = boardLogic.boardInsert(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
      //forward는 select할때 쓰자
   }
   //글 수정 화면 호출(DB연동:select)
   @RequestMapping(value="updateForm.kosmo")
   public String updateForm(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
      //1건의 검색결과를 담고있다(VO) 그러므로 포워드 사용
	  List<Map<String,Object>>boardList
	  	=boardLogic.getBoardList(pbmVO,null);
	  //boardList.size()는 얼마?1
	  Map<String,Object>rMap =null;
	  if(boardList !=null){
		  rMap=boardList.get(0); 
	  }
	  mMap.addAttribute("rMap",rMap);
      return "forward:updateForm.jsp";
   }
   //글조회 구현하기
   /*******************************************************************************************
    * 조회 결과는 List에 담겨 있고 이 주소번지를 화면에 넘겨서 익스프레션을 사용하여
    * 화면에 출력하기
    * @param mMap
    * @param pbmVO
    * @return List<Map<String,Object>>
    * 결과 페이지 이름:List.jsp
    ******************************************************************************************/
   @RequestMapping(value="getBoardList.kosmo")
   public String getBoardList(HttpServletRequest req,
		   ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
	   
	   List<Map<String,Object>> boardList = null;
	   //화면에 조회 결과를 출력하고 싶다.
	   boardList = boardLogic.getBoardList(pbmVO,req);
	   mMap.addAttribute("boardList", boardList);
	   return "forward:List.jsp";
   }
   //글 조회 구현하기-두번째(JSON포맷으로 내보내기)
   /*******************************************************************************************
    *List에 담겨있는 정보를 JSON포멧으로 내보내기
    * @param <%=pMap.get("B_TITLE")%>-브라우저에 텍스트로 그대로 출력한다.
    * @param mMap
    * @return List<Map<String,Object>>
    * 결과 페이지 이름:jsonGetBoardList.jsp
    ******************************************************************************************/
   @RequestMapping(value="jsonGetBoardList.kosmo")
   public String jSonGetBoardList(HttpServletRequest req,
		   ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
	   List<Map<String,Object>> boardList = null;
	   //화면에 조회 결과를 출력하고 싶다.
	   boardList = boardLogic. getBoardList(pbmVO,req);
	   mMap.addAttribute("boardList", boardList);
	   return "forward:jsonGetBoardList.jsp";
   }
   //글 수정 구현하기(DB연동:update)
   @RequestMapping(value="boardUpdate.kosmo")
   public String boardUpdate(@RequestParam("bfile")MultipartFile bfile
   			,@ModelAttribute BoardMasterVO pbmVO
		   ,@ModelAttribute BoardSubVO pbsVO){
	   pbmVO.setB_title(HangulConversion.toKor(pbmVO.getB_title()));
	   pbmVO.setB_name(HangulConversion.toKor(pbmVO.getB_name()));
	   pbmVO.setB_content(HangulConversion.toKor(pbmVO.getB_content()));
	   pbsVO.setB_file(HangulConversion.toKor(pbsVO.getOrg_file()));
	   
	   //첨부파일 업로드 처리하기
	   String fileName = HangulConversion.toKor
				(bfile.getOriginalFilename());
		String path = "C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		//첨부파일 중복처리하기 - 파일 history관리
		//test.zip -> test_20170210161910.zip	
		//1)파일이름만 떼어내기(test)
		String onlyFileName = 
			fileName.substring(0, fileName.indexOf("."));
		logger.info("onlyFileName : "+onlyFileName);
		//2)확장자만 떼어내기(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)파일이름 재정의하기
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pbsVO.setB_file(rename);
		if(bfile !=null){//첨부파일 추가했니?
		//실제 존재하는 파일이름을 객체로 생성해주는 클래스
		//파일에 들어있는 내용까지 생성되는 것은 아니다.
		File file = new File(path+rename);
		try {
			//복제한 파일안에 출력한 바이트를 담는 배열
			byte[] bytes = bfile.getBytes();//123
			//파일의 크기
			long size =file.length();
			pbsVO.setB_size(size);//byte
			BufferedOutputStream bos
			=new BufferedOutputStream(
				new FileOutputStream(file));
			bos.write(bytes);//123출력-파일 내용 추가
			bos.close();
			pbsVO.setB_size(size);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		}/////////////////end of if 
	   
	   int results[] =null;
	   results= boardLogic.boardUpdate(pbmVO,pbsVO);
      //1건의 검색결과를 담고있다(VO) 그러므로 포워드 사용
      return "forward:getBoardList.kosmo";
   }
   //글삭제 화면제공
   //비밀번호 체크 화면
   @RequestMapping(value="deleteForm.kosmo")
   public String deleteForm(){
	   return "redirect:deleteForm.jsp";
   }
   //글삭제 구현하기
   @RequestMapping(value="boardDelete.kosmo")
   public String boardDelete(@ModelAttribute BoardMasterVO pbmVO
		   								,@ModelAttribute BoardSubVO pbsVO){
	   int results[] =null; //result를 사용하는 이유:성공했는지 여부 확인용! 1이면처리
	   String filename=pbsVO.getB_file();
	   String path="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
	   File f= new File(path+filename);
	  //첨부파일 존재?
	   if(f.exists()){
		   boolean isOk=f.delete();
		   logger.info("true이면 삭제 false이면 실패"+isOk);
	   }
	   results = boardLogic.boardDelete(pbmVO,pbsVO);
	   return "redirect:getBoardList.kosmo";
   }
 
}
