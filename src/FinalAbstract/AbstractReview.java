package FinalAbstract;

public class AbstractReview {

	abstract static class A{
		
	}
	
	static class B extends A{
		
	}
	
	public static void main(String[] args) {
		//抽象类能用来声明引用
		A a = new B();
		//抽象类不能被创建
//		A a2 = new A();
	}
}
