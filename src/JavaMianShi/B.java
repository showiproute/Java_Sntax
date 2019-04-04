package JavaMianShi;


public class B extends A{
	public B() {
		System.out.println("B");
	}
	
	public static void main(String[] args) {
		System.out.println("0000");
		B b=new B();
		//执行顺序： 静态代码块>构造代码块>构造函数>普通代码块
		
	}
}
