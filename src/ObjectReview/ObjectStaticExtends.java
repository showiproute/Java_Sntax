package ObjectReview;

public class ObjectStaticExtends {

	public static class A{
		int n=25;
		public A() {
			n=27;
			System.out.println("In the constructor of A:"+n);
		}
		{
			System.out.println("初始化快A:"+n);
			n=26;
			System.out.println("chushihuaA:"+n);
		}
		static {
			int m=2000;
			System.out.println("in the static block"+m);
		}
	
	}
	
	
	public static class B extends A{
		int n=25;
		public B() {
			n=18;
			System.out.println("B构造方法:"+n);
			
		}
		
		{
			System.out.println("Init block b"+n);
			n=111;
			System.out.println("Init Block b"+n);
		}
		
		static {
			int m=22333;
			System.out.println("Static block "+m);
		}
		
	}
	
	
	public static void main(String[] args) {
		B b = new B();
		
		
		
	}
	
	
	
}
