package com.ch11;

import java.util.HashMap;
import java.util.List;

public class HashMapTest2 {
	public HashMapTest2(){
		DeptList dl = new DeptList();
		List<HashMap<String,Object>> deptList
		= dl.setDeptList();
		getDeptList(deptList);
	}
	public void getDeptList
	(List<HashMap<String,Object>> deptList){ //키값을 가지고 접근을해서 가져온다.
		for(int i=0;i<deptList.size();i++){
			System.out.println(deptList.get(i));
			HashMap pMap = deptList.get(i);
			deptDetail(pMap);
			//System.out.println("키의갯수:"+pMap.size());
		}
	}
	public void deptDetail(HashMap pMap){
		Object keys[]=pMap.keySet().toArray();
		for(int i=0;i<pMap.size();i++){
			String key = (String)keys[i];
			System.out.println(pMap.get(key));
		}
	}
	public static void main(String[] args) {
		new HashMapTest2();
	}

}
