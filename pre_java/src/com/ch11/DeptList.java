package com.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

	public class DeptList{
		public List<HashMap<String,Object>>setDeptList()
		{
			List<HashMap<String,Object>> deptList=
					new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object>map=
					new HashMap<String,Object>();
			map.put("deptno", 10);
			map.put("dname", "����");
			map.put("loc", "�λ�");
			deptList.add(map);
			map=new HashMap<String,Object>();
			map.put("deptno", 20);
			map.put("dname", "����");
			map.put("loc", "�λ�");
			deptList.add(map);
			map=new HashMap<String,Object>();
			map.put("deptno", 30);
			map.put("dname", "�ѹ�");
			map.put("loc", "��õ");
			deptList.add(map);
			map=new HashMap<String,Object>();
			map.put("deptno", 40);
			map.put("dname", "����");
			map.put("loc", "����");
			deptList.add(map);
			return deptList;
		}
		public void DeptListPrint
		(List<HashMap<String,Object>> deptList){
			for(int i=0;i<deptList.size();i++){
				HashMap rMap = deptList.get(i);
				System.out.println(rMap.get("deptno")
										+","+rMap.get("dname")
										+","+rMap.get("loc"));
			}
		}
	public static void main(String[] args) {
		DeptList dl =new DeptList();
		dl.DeptListPrint(dl.setDeptList());
	}
	}
