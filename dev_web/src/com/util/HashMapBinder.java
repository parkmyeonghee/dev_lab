package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HashMapBinder {
	public HttpServletRequest request = null;
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request=request;//��ü ����
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
	}
}
