package com.ch7;
public interface Volume {
/*	int i;
	final int i;
	static int j;
	public volume(){}
	public void go(){}*/
	final static int i=10;
	public abstract void come();
	//예외를 던진다.
	//예외 처리를 나를 호출한 곳에서 받으시오
	//예외처리를 내가 하지 않겠따.
	public void volumeUp() throws NullPointerException;
	public void volumeDown() throws NullPointerException,Exception;
}
