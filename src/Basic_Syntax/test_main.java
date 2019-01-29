package Basic_Syntax;

class A{
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

class B extends A{
	public B() {
		
	}
	
	public B(int age) {
		super(age);
	}
	
	public void print() {
		System.out.println(super.getAge());
	}
	
	public void play() {
		System.out.println("play in b");
	}
	
	public void printInfo() {
		System.out.println("bbbb aaa");
	}
}




public class test_main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

}
