package Basic_Syntax;

import java.util.Arrays;

class Persontest implements Comparable<Persontest>
{
	public Persontest(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}




	private String name;
	int age;
	
	
	
	
	@Override
	public int compareTo(Persontest o) {
		// TODO Auto-generated method stub
		return this.age-o.getAge();
	}
	
}


public class Comparable_test {
	
	public static void main(String[] args) {
		Persontest p1 = new Persontest("a",11);
		Persontest p2 = new Persontest("b", 22);
		Persontest[] people={p2,p1};
		for(Persontest person:people) {
			System.out.println(person.getName());
		}
		System.out.println("排序后");
		Arrays.sort(people);
		for(Persontest person:people) {
			System.out.println(person.getName());
		}
		
	}
}
