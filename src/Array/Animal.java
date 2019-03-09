package Basic_Syntax;

public class Animal {

	private int sex;
	private int age;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	
	public Animal(int sex,int age) {
		this.sex=sex;
		this.age=age;
	}
	
	public void eat() {
		System.out.println("Animal eat");
	}
	
	@Override
	public String toString() {
		return "Animal [sex=" + sex + ", age=" + age + "]";
	}

	
}
