package com.ch7;
public interface Volume {
/*	int i;
	final int i;
	static int j;
	public volume(){}
	public void go(){}*/
	final static int i=10;
	public abstract void come();
	//���ܸ� ������.
	//���� ó���� ���� ȣ���� ������ �����ÿ�
	//����ó���� ���� ���� �ʰڵ�.
	public void volumeUp() throws NullPointerException;
	public void volumeDown() throws NullPointerException,Exception;
}
