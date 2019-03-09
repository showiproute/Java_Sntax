package Basic_Syntax;

public class Cat extends Animal{
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	public Cat(int sex,int age) {
		super(sex, age);
	}
	
	public void catchMouse() {
		System.out.println("catch mouse");
	}
	

}
