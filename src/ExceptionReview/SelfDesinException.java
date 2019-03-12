package ExceptionReview;

import java.io.FileInputStream;

public class SelfDesinException {

	//自定义已检查异常
	static class MyException1 extends Exception{
		public MyException1() {}
		//定义带有String类型参数的构造方法
		public MyException1(String message) {
			//调用父类构造器
			super(message);
		}
	}
	
	//自定义未检查异常
	static class MyException2 extends RuntimeException{
		public MyException2() {}
		
		//定义带有String类型参数的构造方法
		public MyException2(String message) {
			//调用父类构造器
			super(message);
		}
	}
	
	private static void test() throws MyException1{
		String path="a.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
		
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException1("MyException1:"+path+"does not exist");
		}
	}
	
	public static void main(String[] args) {
		try {
			test();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("---------");
			e.printStackTrace();
		}
	}
	
	
}
