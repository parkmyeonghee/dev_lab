package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HashMapBinder {
	public HttpServletRequest request = null;
	//첨부 파일 관련 추가 선언
	MultipartRequest multi =null; //cos.jar에서 제공하는 클래스
	String realFolder ="";//첨부 파일을 올릴 물리적인 위치
	String saveFolder ="pds";//첨부 파일 업로드 위치
	String encType="euc-kr";//첨부파일 한글 처리 관련
	int maxSize = 50*1024*1024;
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request=request;//객체 주입
		realFolder ="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_jquery\\WebContent\\pds";
		
	}
	public void binder(Map<String,Object> pMap){
		pMap.clear();
		//Eumeration안에는 String이 있다. -name,address,pet
		//문제 제기
		//Map 계열은 key가 중복 될 수 없습니다.
		String values[]=request.getParameterValues("pet");
		if(values !=null){
			for(String str:values){
			if("dog".equals(str)){
				pMap.put(str, str);
			}
			else if("cat".equals(str)){
				pMap.put(str, str);
			}
			else if("pig".equals(str)){
				pMap.put(str, str);
		}
			}
		}
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement(); //name,address,pet
			if("pet".equals(key)){
				continue;//조건식을 만족하면 while문 조건식으로 이동
			}
			pMap.put(key,HangulConversion.toKor(request.getParameter(key))); //사용자가 입력한 이름
		}
	}////////////////////////////////end of bind
	//파일 업로드 처리할 때 사용할 메소드 구현하기
	//@param BookInsertAction에서 생성하여 파라미터로 넘깁니다.
	public void multiBind(Map<String,Object>pMap){
		try {
			multi = new MultipartRequest(request
					,realFolder
					,maxSize
					,encType
					,new DefaultFileRenamePolicy());
		Enumeration<String> en = multi.getParameterNames();//ab_title,ab_author
		String name="";
		while(en.hasMoreElements()){
			name=en.nextElement();
			pMap.put(name, multi.getParameter(name));
		}
		//전송된 파일 정보를 가져오기
		Enumeration<String> files =multi.getFileNames();
		File file =null; //파일 정보를 객체로 만들어준다.
		while(files.hasMoreElements()){
			String fname = files.nextElement();
			String filename=multi.getFilesystemName(fname);
			pMap.put("ab_img", filename);
			file=multi.getFile(fname);
		}
		//첨부 파일의 크기를 담을 변수 선언
		long size =0;
		if(file !=null){
			size=file.length();//파일의 크기를 계산해서 size담기
			pMap.put("ab_size", size);
		}
		} catch (Exception e) {
		}//////////end of try
		
	}////////////////end of multiBind
}
