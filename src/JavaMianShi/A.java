package JavaMianShi;

class A {

	public A() {
		System.out.println("A guozhao");
	}
	private static A a=new A();
	static {
		System.out.println("static");
	}
	{
		System.out.println("A1");
	}
	
}
