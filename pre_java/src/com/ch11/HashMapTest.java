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
		map.put("one", "�̼���");
		map.put("two", "������");
		map.put("three", "������");
		return map;
	}
	public void mapPrint()
	{
		Map<String, Object> map=setHashMap();
		Iterator it = map.keySet().iterator();
		//Set set =map.keySet();
		//Iterator iter = set.iterator();
		while(it.hasNext()){
		Object obj = it.next();//Ű�� �����.
		String value=(String)map.get(obj);
		System.out.println(obj);
		System.out.println("key:"+obj+", value"+value);
		}
	}
	public void mapPrint2()
	{
		Map<String, Object> map=setHashMap();
		Object keys[]=map.keySet().toArray();//Ű��
		for(int i=0;i<keys.length;i++){
		String key = (String)keys[i];//Ű�� �����.
		String value=(String)map.get(key);
		System.out.println("key:"+key+", value"+value);
		}
	}
	/******************************************************************************************
	 * object �迭�� String�迭�� ����ȯ�� �����ϴ�.(�����Ͽ�����)
	 * ���� ���� �ö� classcastingException�߻��Ѵ�.(��Ÿ�ӿ���)
	 * ���Կ����� �����ʿ��� �׻� ���ڽ�Ÿ���̿��°��� �����ϴ�.
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
		String key = (String)keys2[i];//Ű�� �����.
		String value=(String)map.get(key);
		System.out.println("key:"+key+", value"+value);
		}
	}
	public static void main(String[] args) {
		HashMapTest htmt = new HashMapTest();
		htmt.mapPrint2();
	}

}
