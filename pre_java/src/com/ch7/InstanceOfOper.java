package com.ch7;

import java.util.Vector;

public class InstanceOfOper {
	Vector vec = new Vector();//�þ��� �پ��� �Ѵ�.
	Vector<String> bread = new Vector<String>(10,10);//�� �ȿ� String�� ���� �� �ִ�.
	Object objs[]=new Object[3];
	public InstanceOfOper(){
		System.out.println("bread.size():"+bread.size());
		String name ="�̼���";
		//methodA(name);
		//methodA(10);
		Sonata myCar=new Sonata();
		//methodA(myCar);
		objs[0]=name;
		objs[1]=10;
		objs[2]=myCar;
		methodB(objs);
		vec.add(name); //vector�޸� ������ �־�����
		vec.add(10);
		vec.add(myCar);
		vec.add(2,true);//�����ֱⰡ �����ϴ�.
		vec.remove(3);//�ش� ��ġ�� ���� �����Ѵ�.
		System.out.println("size���� Ȯ���ϱ�"+vec.size());
		methodB(vec);
	}
	private void methodB(Object[] objs2) {
		System.out.println("====================================");
		for(int i=0;i<objs2.length;i++){
			if(objs[i] instanceof Sonata){
				Sonata herCar =(Sonata)objs2[i];
				System.out.println(herCar);
			}
			else if(objs2[i] instanceof String){
				String str=(String)objs2[i];
				System.out.println(str);
			}
			else if(objs2[i] instanceof Integer){
				Integer it=(Integer)objs2[i];
				System.out.println(it);
			}
		}
		System.out.println("======================================");
	}
	void methodB(Vector v){
		//Vector���� �������� object�� ���� �� �ִ�.
		//Vector�� ����ִ� �� ����� ����
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
	}
/*	void methodA(String name){
		System.out.println("name:"+name);
	}*/
	void methodA(Object obj){
		//�ҳ�Ÿ Ÿ��?
		if(obj instanceof Sonata){
			Sonata herCar =(Sonata)obj;
			System.out.println(herCar);
		}
		//String Ÿ��?
		else if(obj instanceof String){
			String str=(String)obj;
			System.out.println(str);
		}
		//IntegerŸ��?
		else if(obj instanceof Integer){
			Integer it =(Integer)obj;
			System.out.println(it);
		}
		System.out.println(obj);
	}
	public static void main(String[] args) {
		new InstanceOfOper(); //������ȣ��
	}

}
