package com.pizza;

import com.vo.CustomerVO;

public class CustomerInfo {
	public CustomerVO cVOs[]=new CustomerVO[3];
	public void init(){
		CustomerVO cVO=
				new CustomerVO("�̼���"
									,"02-243-4444"
									,"����� ������ ������");
		cVOs[0]= cVO;
		cVO=
				new CustomerVO("������"
									,"02-243-4444"
									,"����� ���빮�� ����");
		cVOs[1]= cVO;
		cVO=
				new CustomerVO("������"
									,"02-243-4444"
									,"����� ���α� ������");
		cVOs[2]= cVO;
		cVO=
				new CustomerVO("������"
									,"02-243-4444"
									,"����� ���빮�� ����");
	}

}
