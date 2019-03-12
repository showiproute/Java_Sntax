package ExceptionReview;

import java.util.Scanner;

public class TestException {

	public static void ma(int i) {
		System.out.println("ma 1");
		mb(i);
		System.out.println("ma 2");
	}
	
	public static void mb(int i) {
		System.out.println("mb 1");
		mc(i);
		System.out.println("mb 2");
	}
	
	public static void mc(int i) {
		System.out.println("mc 1");
		if(i==0) throw new NullPointerException();
		System.out.println("mc 2");
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("main 1");
		ma(i);
		System.out.println("main 2");
	}
	
}
