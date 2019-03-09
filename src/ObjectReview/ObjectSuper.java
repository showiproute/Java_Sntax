package ObjectReview;

public class ObjectSuper {

	public static class Parent{
		public Parent() {
			// TODO Auto-generated constructor stub
			System.out.println("Parent():");
		}
		
		public Parent(String name) {
			System.out.println("Parent"+name);
		}
		
	}
	
	public static class Child extends Parent{
		public Child(String name) {
			super("dddd");
			System.out.println("Child(String name)");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Child("child");
	}
	
	
}
