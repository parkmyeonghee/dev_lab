package com.pizza;

import com.vo.CustomerVO;

public class CustomerInfo {
	public CustomerVO cVOs[]=new CustomerVO[3];
	public void init(){
		CustomerVO cVO=
				new CustomerVO("이순신"
									,"02-243-4444"
									,"서울시 마포구 공덕동");
		cVOs[0]= cVO;
		cVO=
				new CustomerVO("김유신"
									,"02-243-4444"
									,"서울시 서대문구 연희동");
		cVOs[1]= cVO;
		cVO=
				new CustomerVO("강감찬"
									,"02-243-4444"
									,"서울시 구로구 개봉동");
		cVOs[2]= cVO;
		cVO=
				new CustomerVO("김유신"
									,"02-243-4444"
									,"서울시 서대문구 연희동");
	}

}
