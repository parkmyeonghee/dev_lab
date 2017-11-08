package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class UserMain {

	public static void main(String[] args) {
		User user = new User("이순신",35,"대한민국");
		System.out.println(user.toString());
		user=null;
		user=new User("김유신",36,"미국");
		//이순신라인에서 생성된 객체는 candidate상태로 빠진다.
		System.out.println("=============================================");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("com\\di\\userBean.xml");
		Resource resource = new FileSystemResource("C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\src\\com\\di\\userBean.xml");
		BeanFactory factory= new XmlBeanFactory(resource);
		User user1=(User)context.getBean("user");//미리
		User user2=(User)factory.getBean("user");//늦게
		System.out.println(user1.toString());
		System.out.println(user2.toString());
	}

}
