package StringReview;

public class ConstantString {

	public static void main(String[] args) {
		
		String t1="a1b2";
		String t2="a1"+"b2";
		System.out.println(t1.equals(t2));
		
		String t3="b2";
		String t4="a1"+t3;
		
		//final修饰过的 就是保存在常量池 constant pool中
		final String t5="b2";
		String t6="a1"+t5;
		System.out.println(t1==t4);
		System.out.println(t1==t6);
		
	}
	
}
