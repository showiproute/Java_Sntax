package SerializableTest;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * Person类：实现序列化
 */
public class Person implements Serializable{

	private static final long serialVersionUID=-2222222222222L;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	private String name;
	
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age=age;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		Person p1 = new Person("aaa", 22);
		
		String path="C:\\Users\\liangyintian\\Desktop\\data.txt";
		
		try(
				FileOutputStream fos=new FileOutputStream(path);
		
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				
		){
			oos.writeObject(p1);
			oos.flush();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		try(
				FileInputStream fis=new FileInputStream(path);
				ObjectInputStream ois=new ObjectInputStream(fis);
		){
			Person result = (Person) ois.readObject();
			System.out.println(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
