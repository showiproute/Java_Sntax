package FinalAbstract;

public class FinalReview {

	/*
	 * final修饰的类变量，指定初始值
	 */
	//声明常量时，指定初始值
	public static final int N=2;
	//声明时不指定
	public static final int M;
	//在静态块中指定
	static {
		M=3;
	}
	
	//实例常量
	//1)声明常量时，指定初始值
	public final int N1=2;
	
	//2)在非静态初始块中赋值
	public final int N2;
	{
		N2=22;
	}
	
	public final int N3;
	//3)在构造方法中赋值
	public FinalReview(int n) {
		this.N3=22;
	}
	
	
	//final修饰的方法，不能被子类重写
	static class A{
		public static final void dd() {
			System.out.println("do A.dd()");
		}
	}
	
	static class B extends A{
		//由于父类将dd()方法用final修饰，子类不能重写该方法
//		public void dd() {
//			System.out.println("do B.dd()");
//		}
	}
	
	
	//final类表示这个类不能被继承
	static final class A1{
		
	}
	
	//final修饰的类，不能被子类继承
//	class B1 extends A1{
//		
//	}
	
}
