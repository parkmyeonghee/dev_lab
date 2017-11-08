package com.cookie;

public class onLineTestApp {

	public static void main(String[] args) {
		OnLineTestDao otDao = new OnLineTestDao();
		String msg = otDao.proc_salupdate(7566);
		System.out.println(msg);
	}

}
