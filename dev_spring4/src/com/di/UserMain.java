package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class UserMain {

	public static void main(String[] args) {
		User user = new User("�̼���",35,"���ѹα�");
		System.out.println(user.toString());
		user=null;
		user=new User("������",36,"�̱�");
		//�̼��Ŷ��ο��� ������ ��ü�� candidate���·� ������.
		System.out.println("=============================================");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("com\\di\\userBean.xml");
		Resource resource = new FileSystemResource("C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\src\\com\\di\\userBean.xml");
		BeanFactory factory= new XmlBeanFactory(resource);
		User user1=(User)context.getBean("user");//�̸�
		User user2=(User)factory.getBean("user");//�ʰ�
		System.out.println(user1.toString());
		System.out.println(user2.toString());
	}

}
