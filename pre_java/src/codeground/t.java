package codeground;

public class t {
	public static String output="";
	public static void main(String[] args) {
		foo(0);
		foo(1);
		System.out.println(output);
	}
	public static int foo(int x){
		try {
			if(x==1){
				throw new Exception();
			}
			output +="1";
		} catch (Exception e) {
			output +="2";
		}finally{
			output +="3";
		}
		output +="4";
	}

}
