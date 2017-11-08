package com.ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public Map<String, Object> setHashMap()
	{
		Map<String,Object> map
		=new HashMap<String,Object>();
		map.put("one", "이순신");
		map.put("two", "강감찬");
		map.put("three", "김유신");
		return map;
	}
	public void mapPrint()
	{
		Map<String, Object> map=setHashMap();
		Iterator it = map.keySet().iterator();
		//Set set =map.keySet();
		//Iterator iter = set.iterator();
		while(it.hasNext()){
		Object obj = it.next();//키가 저장됨.
		String value=(String)map.get(obj);
		System.out.println(obj);
		System.out.println("key:"+obj+", value"+value);
		}
	}
	public void mapPrint2()
	{
		Map<String, Object> map=setHashMap();
		Object keys[]=map.keySet().toArray();//키값
		for(int i=0;i<keys.length;i++){
		String key = (String)keys[i];//키가 저장됨.
		String value=(String)map.get(key);
		System.out.println("key:"+key+", value"+value);
		}
	}
	/******************************************************************************************
	 * object 배열을 String배열로 형전환은 가능하다.(컴파일에러무)
	 * 값을 꺼내 올때 classcastingException발생한다.(런타임에러)
	 * 대입연산자 오른쪽에는 항상 ㅏ자식타입이오는것이 안전하다.
	 ******************************************************************************************/
	public void mapPrint3()
	{
		Map<String, Object> map=setHashMap();
		//String keys2[]=(String[])(map.keySet().toArray());
		String keys2[]=null;
		for(int i=0;i<map.keySet().toArray().length;i++){
			keys2[i]=(String)(map.keySet().toArray()[i]);
		}
		for(int i=0;i<keys2.length;i++){
		String key = (String)keys2[i];//키가 저장됨.
		String value=(String)map.get(key);
		System.out.println("key:"+key+", value"+value);
		}
	}
	public static void main(String[] args) {
		HashMapTest htmt = new HashMapTest();
		htmt.mapPrint2();
	}

}
