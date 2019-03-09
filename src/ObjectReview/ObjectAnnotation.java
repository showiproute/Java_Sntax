package ObjectReview;

public class ObjectAnnotation {

//	public static class A{
//		public void method() {
//			System.out.println("method in A");
//		}
//	}
//	public static class B extends A{
//		public void method() {
//			System.out.println("method in B");
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		A a = new B();
//		a.method();
//		new B().method();
//	}
	
	public static class A{
		private int age;
		
		public A() {
			
		}
		
		public A(int age) {
			this.age=age;
		}
		
		protected int getAge() {
			return age;
		}
		
		public void printInfo() {
			System.out.println(getAge());
		}
		
	}
	
	public static class B extends A{
		public B() {
			
		}
		
		public B(int age) {
			super(age);
		}
		
		public void print() {
			System.out.println(super.getAge());
		}
		
		public void play() {
			System.out.println("play");
		}
		
		@Override
		public void printInfo() {
			System.out.println("B类重写A类的PrintInfo");
		}
	}
	public static void main(String[] args) {
		
		//编译时类型：由声明该变量的类型决定 B b
		//运行时类型：由实际赋给该变量的对象决定 new B(10)
		
//		B b = new B(20);
//		b.print();
//		b.printInfo();
//		b.play();
		
		//多态：编译时的类型和运行时的类型不是同一类型
		//编译时类型：A 运行时类型B
		//多态的前提是：A和B是继承关系
		//多态一般用法：将子类创建的对象，赋值给父类的引用变量
		//继承时讲过，父类的范围要大于子类
		System.out.println("----------");
	
		//实际运行时，运行的是B类内部重写A类的printInfo(),子类重写父类的方法
		A a=new B(10);
		a.printInfo();
		
		//下面是A类自己的方法，B类没有重写，方法的修饰符是public
		System.out.println(a.getAge());
		
	}
	
	
	
}
