package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HashMapBinder {
	public HttpServletRequest request = null;
	//÷�� ���� ���� �߰� ����
	MultipartRequest multi =null; //cos.jar���� �����ϴ� Ŭ����
	String realFolder ="";//÷�� ������ �ø� �������� ��ġ
	String saveFolder ="pds";//÷�� ���� ���ε� ��ġ
	String encType="euc-kr";//÷������ �ѱ� ó�� ����
	int maxSize = 50*1024*1024;
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request=request;//��ü ����
		realFolder ="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_jquery\\WebContent\\pds";
		
	}
	public void binder(Map<String,Object> pMap){
		pMap.clear();
		//Eumeration�ȿ��� String�� �ִ�. -name,address,pet
		//���� ����
		//Map �迭�� key�� �ߺ� �� �� �����ϴ�.
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
				continue;//���ǽ��� �����ϸ� while�� ���ǽ����� �̵�
			}
			pMap.put(key,HangulConversion.toKor(request.getParameter(key))); //����ڰ� �Է��� �̸�
		}
	}////////////////////////////////end of bind
	//���� ���ε� ó���� �� ����� �޼ҵ� �����ϱ�
	//@param BookInsertAction���� �����Ͽ� �Ķ���ͷ� �ѱ�ϴ�.
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
		//���۵� ���� ������ ��������
		Enumeration<String> files =multi.getFileNames();
		File file =null; //���� ������ ��ü�� ������ش�.
		while(files.hasMoreElements()){
			String fname = files.nextElement();
			String filename=multi.getFilesystemName(fname);
			pMap.put("ab_img", filename);
			file=multi.getFile(fname);
		}
		//÷�� ������ ũ�⸦ ���� ���� ����
		long size =0;
		if(file !=null){
			size=file.length();//������ ũ�⸦ ����ؼ� size���
			pMap.put("ab_size", size);
		}
		} catch (Exception e) {
		}//////////end of try
		
	}////////////////end of multiBind
}
