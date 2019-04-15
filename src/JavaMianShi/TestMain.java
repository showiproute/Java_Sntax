package JavaMianShi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestMain {
	
	public static class Student implements Comparator<Student>{
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		public String name;
		public int age;
		public Student(String name,int age) {
			// TODO Auto-generated constructor stub
			this.name=name;
			this.age=age;
		}
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o2.age-o1.age;
		}
		
	}
		
	public static void main(String[] args) {
		Student student=new Student("aa", 11);
		Student student2=new Student("bb", 22);
		HashSet<Student> hashSet=new HashSet<>();
		hashSet.add(student);
		hashSet.add(student);
		Iterator<Student> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		HashSet<String> hashSet2=new HashSet<>();
		hashSet2.add("asd");
		hashSet2.add("bbb");
		hashSet2.add("bbb");
		System.out.println(hashSet2.toString());
		
	}
	
}



