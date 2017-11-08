package com.ch8;

public class ExceptionExam2 {
	public ExceptionExam2(){
		try {
			test();
		}catch (NumberFormatException ne){
			System.out.println("NumberFormatException:"+ne.toString());
		} catch (Exception e) {
			System.out.println("Exception:"+e.toString());
		}finally{
			//예외인 경우가 있다.
			//사용한 자원을 반납해야 할 때-실전에서...
			System.exit(0);//자바 가상머신과 연결고리가 끊어진 경우
			System.out.println("예외 발생과 상관없이 무조건 실행");
		}
		System.out.println("here");
	}
	/*
	 * throws는 예외를 나를 호출한 곳에서 처리 받으세요.
	 * throw는 예외를 던질 때,
	 * 실전에서는 트랜잭션 처리를 위해서 사용되기도 합니다.
	 * 트랜잭션 처리란 하나의 업무로 묶어 주는 것.
	 */
		public void test() throws Exception{
			int i =0;
			if(i<1){
			throw new Exception();
		}

	}
	public static void main(String[] args) {
		new ExceptionExam2();
}
}