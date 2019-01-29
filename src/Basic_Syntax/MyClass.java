package Basic_Syntax;

public class MyClass {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	int a;
	int b=100;
	int c=3;
	private String name1="";
	String name2="";
	String name3="";
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */



	
	public MyClass() {
		this.c=100;
		this.name1="name1";
		this.name2="name2";
		this.name3="name3";
	}
	
	public MyClass(int c,String name1,String name2,String name3) {
		this.c=c;
		this.name1=name1;
		this.name2=name2;
		this.name3=name3;
	}
	
	
	public MyClass(int a,int b) {
		this();
		this.a=a;
		this.b=b;
		
	}
	
	@Override
	public String toString() {
		return "MyClass [a=" + a + ", b=" + b + ", c=" + c + ", name1=" + name1 + ", name2=" + name2 + ", name3="
				+ name3 + "]";
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
