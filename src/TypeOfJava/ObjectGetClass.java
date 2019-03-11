package TypeOfJava;

public class ObjectGetClass {

	
	public static abstract class Test{
		public abstract void test();
	}
	
	public static class Dog extends Test{
		private String name;
		private int age;
		
		@Override
		public void test() {
			System.out.println("dog");
		}
	}
	
	public static class Cat extends Test{
		private String name;
		private int age;
		
		@Override
		public void test() {
			System.out.println("cat");
		}
		
	}
	
	public static void main(String[] args) {
		
		Test d1 = new Dog();
		Test d2 = new Dog();
		Test c1 = new Cat();
		
		System.out.println(d1.getClass()==d2.getClass());
		System.out.println(d1.getClass()==c1.getClass());
		
		
	}
	
}
