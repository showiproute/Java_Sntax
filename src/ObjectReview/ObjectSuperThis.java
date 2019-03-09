package ObjectReview;

public class ObjectSuperThis {

	public static class A{
		int s;
		int m=22;
		public void ddA() {
			System.out.println("do A.ddA()");
		}
		public void ddC() {
			System.out.println("do A.ddC()");
		}
	
	}
	
	public static class B extends A{
		int n;
		public void ddB() {
			System.out.println("do B.ddB()");
		}
		public void ddC() {
			System.out.println("do B.ddC()");
		}
		
	}
	
	public static class C extends B{
		int m;
		public C() {
			//调用当前类的ddC()方法
			this.ddC();
			//向上追溯直至直到ddC（）
			super.ddC();
		}
		
		public C(int n,int m) {
			//当前类的属性m
			
			this.m=m;
			
			//父类的属性n
			super.n=n;
			System.out.println("this.m="+this.m+"super.n"+super.n);
		}
		
		public C(int n,int m,int s) {
			//当前类的属性m
			this.m=m;
			
			//!!! 如果子类和父类没有重复的属性名，可以使用this或者使用super调用
			
			//父类的属性n
			this.n=n;
			this.s=s;
			System.out.println("this.m"+this.m+"super.n"+super.n+"super.s"+super.s);
		}
		
		public C(int n,int m,int s,int m1) {
			this.m=m;
			this.n=n;
			this.s=s;
			
			super.m=40;
			System.out.println("this.m"+this.m+"super.n"+super.n+
					"this.s"+this.s+"super.m"+super.m);
		}
		
		public void ddC() {
			System.out.println("do C.ddc()");
			this.ddB();
			this.ddA();
			System.out.print("------------------");
		}
		
	}
	
	public static void main(String[] args) {
		
		new C(1,2,3,4);
		
		
	}
	
	
}
