package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HashMapBinder {
	public HttpServletRequest request = null;
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request=request;//객체 주입
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
	}
}
