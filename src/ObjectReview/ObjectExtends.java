package ObjectReview;

public class ObjectExtends {

//	public static class A{
//		static int n=3;
//	}
//	
//	public static class B extends A{
//		static int m=4;
//	
//		public static void printInfo() {
//			System.out.println("m="+m+"n="+n);
//		}
//	}
//	
//	public static void main(String[] args) {
//
//		new B().printInfo();
//		
//	}
	
	public static class A{
		int n=25;
		public A() {
			n=27;
			System.out.println("n="+n);
		}
		{
			System.out.println("n="+n);
			n=26;
			System.out.println("n="+n);
		}
	}
	
	public static class B extends A{
		int n=25;
		public B() {
			n=17;
			System.out.println("b n"+n);
		}
		{
			System.out.println("b n"+n);
			n=16;
			System.out.println("b n"+n);
		}
	}
	
	public static void main(String[] args) {
		
		new B();
	}
	
}
