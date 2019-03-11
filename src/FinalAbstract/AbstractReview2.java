package FinalAbstract;

public class AbstractReview2 {

	static abstract class A{
	
		//抽象方法，用abstract修饰，没有方法体，方法体用；代替
		//抽象方法，只负责声明该方法，具体方法的实现由子类实现
		abstract void play();
		
		abstract void eat();
		
		//抽象类可以放普通方法
		void dd() {
			System.out.println("do A.dd()");
		}
	}
	
	static class B extends A{

		@Override
		void play() {
			// TODO Auto-generated method stub
			System.out.println("do B.play()");
		}

		@Override
		void eat() {
			// TODO Auto-generated method stub
			System.out.println("do B.eat()");
		}
	}
	
	//如果子类不重写(实现）父类的抽象方法，那这个子类必须是抽象类
	static abstract class C extends A{
		@Override
		void play() {
			System.out.println("do C.play()");
		}
	}
	
	static class CC extends C{
		@Override
		void eat() {
			System.out.println("do CC.eat()");
		}
	}
	
	public static void main(String[] args) {

		//抽象类能用来声明引用
		A a = new B();
		a.play();
		//多态
		a = new CC();
		a.eat();
	}
	
}
