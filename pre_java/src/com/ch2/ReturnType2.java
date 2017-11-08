package com.ch2;
/*
 * @param 홍길동 학생의 점수
 * @param 이순신 학생의 점수
 * @return 두 학생의 총점을 반환하기
 */
public class ReturnType2 {

	static int hap(int jumsu1,int jumsu2){
		int tot=0;
		tot=jumsu1+jumsu2;
		return tot;
		
	}
	/*
	 * 
	 */
	static void avg(){//쓰임새가 필요가 없어졌기 때문에 void를 써줌 최종작업이라는 소리
		//int tot=jumsu1+jumsu2;
		int tot=hap(80,90);//합이 호출이 되었다.
		System.out.println(tot);
		System.out.println(hap(80,90));
		//double avg1=tot/2.0;
		double avg1=hap(80,90)/2.0;//리턴값이 있어서 가능하다.
		System.out.println("평균:"+avg1);//메인 메소드에서 찍어야 할 경우 리턴타입이 필요함
	}
	public static void main(String[] args) {
		avg();

	}

}
