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
	   //�۾��� ȭ�� ���� - �޼ҵ��̸����� ��������
	   //�����񽺴� ���������� �θ��ϱ� url�������� �ؾ��Ѵ�
	   //��������� �ʿ��ϴ� ���ϰ� String, �ʿ���� void
		@Autowired
		public BoardLogic boardLogic=null;
	   @RequestMapping(value="writeForm.kosmo")
	   public String writeForm(){
	      return "redirect:writeForm.jsp";
	   }
	   //�ۻ� ó�� ����
	   @RequestMapping(value="getBoardDetail.kosmo")
	   public String getBoardDetail(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO)
	   {
		   List<Map<String,Object>> boardList =null;
		   boardList=boardLogic.getBoardList(pbmVO,null);
		   logger.info("boardList.size():"+boardList.size());
		   mMap.put("boardList",boardList);
		   return "forward:Read.jsp";
	   }
	   //�۾��� ó�� ����
	   /*
	    * ������������ ����ڰ� �Է��� ����(�ݺ��ڵ�:request.getParameter())�� 
	    * �ޱ� ���� �ڵ带 �ٿ��ֱ� ���ؼ�
	    * @ModelAttribute �� @RequestParam API�� �����ϰ� �ֽ��ϴ�.
	    */
	   @RequestMapping(value="boardInsert.kosmo")
	   public String boardInsert(@RequestParam("bfile") MultipartFile bfile,@ModelAttribute BoardMasterVO pbmVO,BoardSubVO pbsVO){
		   String fileName = HangulConversion.toKor
					(bfile.getOriginalFilename());
	logger.info("fileName:"+fileName);
	String path = "C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
	//÷������ �ߺ�ó���ϱ� - ���� history����
	//test.zip -> test_20170210161910.zip	
	//1)�����̸��� �����(test)
	String onlyFileName = 
		fileName.substring(0, fileName.indexOf("."));
	logger.info("onlyFileName : "+onlyFileName);
	//2)Ȯ���ڸ� �����(.zip)
	String extension = fileName.substring(fileName.indexOf("."));
	//3)�����̸� �������ϱ�
	String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
	pbsVO.setB_file(rename);
	if(bfile !=null){//÷������ �߰��ߴ�?
	//���� �����ϴ� �����̸��� ��ü�� �������ִ� Ŭ����
	//���Ͽ� ����ִ� ������� �����Ǵ� ���� �ƴϴ�.
	File file = new File(path+rename);
	try {
		//������ ���Ͼȿ� ����� ����Ʈ�� ��� �迭
		byte[] bytes = bfile.getBytes();//123
		//������ ũ��
		long size =file.length();
		pbsVO.setB_size(size);//byte
		BufferedOutputStream bos
		=new BufferedOutputStream(
			new FileOutputStream(file));
		bos.write(bytes);//123���
		bos.close();
	} catch (Exception e) {
		logger.info(e.toString());
	}
	}/////////////////end of if
	
	//post����� ��� tokor�Լ��� �¿��� �Ѵ�.
		pbmVO.setB_title(HangulConversion.toKor(pbmVO.getB_title()));
		pbmVO.setB_name(HangulConversion.toKor(pbmVO.getB_name()));
		pbmVO.setB_content(HangulConversion.toKor(pbmVO.getB_content()));
	   logger.info("boardInsert");
	   int results[] =null;
	   results  = boardLogic.boardInsert(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
      //forward�� select�Ҷ� ����
   }
   //�� ���� ȭ�� ȣ��(DB����:select)
   @RequestMapping(value="updateForm.kosmo")
   public String updateForm(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
      //1���� �˻������ ����ִ�(VO) �׷��Ƿ� ������ ���
	  List<Map<String,Object>>boardList
	  	=boardLogic.getBoardList(pbmVO,null);
	  //boardList.size()�� ��?1
	  Map<String,Object>rMap =null;
	  if(boardList !=null){
		  rMap=boardList.get(0); 
	  }
	  mMap.addAttribute("rMap",rMap);
      return "forward:updateForm.jsp";
   }
   //����ȸ �����ϱ�
   /*******************************************************************************************
    * ��ȸ ����� List�� ��� �ְ� �� �ּҹ����� ȭ�鿡 �Ѱܼ� �ͽ��������� ����Ͽ�
    * ȭ�鿡 ����ϱ�
    * @param mMap
    * @param pbmVO
    * @return List<Map<String,Object>>
    * ��� ������ �̸�:List.jsp
    ******************************************************************************************/
   @RequestMapping(value="getBoardList.kosmo")
   public String getBoardList(HttpServletRequest req,
		   ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
	   
	   List<Map<String,Object>> boardList = null;
	   //ȭ�鿡 ��ȸ ����� ����ϰ� �ʹ�.
	   boardList = boardLogic.getBoardList(pbmVO,req);
	   mMap.addAttribute("boardList", boardList);
	   return "forward:List.jsp";
   }
   //�� ��ȸ �����ϱ�-�ι�°(JSON�������� ��������)
   /*******************************************************************************************
    *List�� ����ִ� ������ JSON�������� ��������
    * @param <%=pMap.get("B_TITLE")%>-�������� �ؽ�Ʈ�� �״�� ����Ѵ�.
    * @param mMap
    * @return List<Map<String,Object>>
    * ��� ������ �̸�:jsonGetBoardList.jsp
    ******************************************************************************************/
   @RequestMapping(value="jsonGetBoardList.kosmo")
   public String jSonGetBoardList(HttpServletRequest req,
		   ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO){
	   List<Map<String,Object>> boardList = null;
	   //ȭ�鿡 ��ȸ ����� ����ϰ� �ʹ�.
	   boardList = boardLogic. getBoardList(pbmVO,req);
	   mMap.addAttribute("boardList", boardList);
	   return "forward:jsonGetBoardList.jsp";
   }
   //�� ���� �����ϱ�(DB����:update)
   @RequestMapping(value="boardUpdate.kosmo")
   public String boardUpdate(@RequestParam("bfile")MultipartFile bfile
   			,@ModelAttribute BoardMasterVO pbmVO
		   ,@ModelAttribute BoardSubVO pbsVO){
	   pbmVO.setB_title(HangulConversion.toKor(pbmVO.getB_title()));
	   pbmVO.setB_name(HangulConversion.toKor(pbmVO.getB_name()));
	   pbmVO.setB_content(HangulConversion.toKor(pbmVO.getB_content()));
	   pbsVO.setB_file(HangulConversion.toKor(pbsVO.getOrg_file()));
	   
	   //÷������ ���ε� ó���ϱ�
	   String fileName = HangulConversion.toKor
				(bfile.getOriginalFilename());
		String path = "C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		//÷������ �ߺ�ó���ϱ� - ���� history����
		//test.zip -> test_20170210161910.zip	
		//1)�����̸��� �����(test)
		String onlyFileName = 
			fileName.substring(0, fileName.indexOf("."));
		logger.info("onlyFileName : "+onlyFileName);
		//2)Ȯ���ڸ� �����(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)�����̸� �������ϱ�
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pbsVO.setB_file(rename);
		if(bfile !=null){//÷������ �߰��ߴ�?
		//���� �����ϴ� �����̸��� ��ü�� �������ִ� Ŭ����
		//���Ͽ� ����ִ� ������� �����Ǵ� ���� �ƴϴ�.
		File file = new File(path+rename);
		try {
			//������ ���Ͼȿ� ����� ����Ʈ�� ��� �迭
			byte[] bytes = bfile.getBytes();//123
			//������ ũ��
			long size =file.length();
			pbsVO.setB_size(size);//byte
			BufferedOutputStream bos
			=new BufferedOutputStream(
				new FileOutputStream(file));
			bos.write(bytes);//123���-���� ���� �߰�
			bos.close();
			pbsVO.setB_size(size);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		}/////////////////end of if 
	   
	   int results[] =null;
	   results= boardLogic.boardUpdate(pbmVO,pbsVO);
      //1���� �˻������ ����ִ�(VO) �׷��Ƿ� ������ ���
      return "forward:getBoardList.kosmo";
   }
   //�ۻ��� ȭ������
   //��й�ȣ üũ ȭ��
   @RequestMapping(value="deleteForm.kosmo")
   public String deleteForm(){
	   return "redirect:deleteForm.jsp";
   }
   //�ۻ��� �����ϱ�
   @RequestMapping(value="boardDelete.kosmo")
   public String boardDelete(@ModelAttribute BoardMasterVO pbmVO
		   								,@ModelAttribute BoardSubVO pbsVO){
	   int results[] =null; //result�� ����ϴ� ����:�����ߴ��� ���� Ȯ�ο�! 1�̸�ó��
	   String filename=pbsVO.getB_file();
	   String path="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
	   File f= new File(path+filename);
	  //÷������ ����?
	   if(f.exists()){
		   boolean isOk=f.delete();
		   logger.info("true�̸� ���� false�̸� ����"+isOk);
	   }
	   results = boardLogic.boardDelete(pbmVO,pbsVO);
	   return "redirect:getBoardList.kosmo";
   }
 
}
