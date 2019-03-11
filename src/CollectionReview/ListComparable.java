package CollectionReview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Collections排序，需要list里面的元素，实现Comparable接口
 */

public class ListComparable {

	public static class Student implements Comparable<Student>{

		private String name;
		
		/*分数
		 */
		private int score;
		
		public Student(String name,int score) {
			this.name=name;
			this.score=score;
		}
		//实现compareTo方法，进行比较降序排序
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			if(this.score<o.score) {
				return 1;
			}else if(this.score == o.score) {
				return 0;
			}else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("ming", 90);
		Student s2 = new Student("aaa", 22);
		Student s3 = new Student("ddd", 333);
		ArrayList<Student> arrayList = new ArrayList<>();
		arrayList.add(s1);
		arrayList.add(s2);
		arrayList.add(s3);
		
		for (Student s : arrayList) {
			System.out.println(s.name+"\t"+s.score);
		}
		System.out.println("-----------------");
		//对arraylist进行排序
		Collections.sort(arrayList);
		for (Student s : arrayList) {
			System.out.println(s.name+"\t"+s.score);
		}
		System.out.println("-------------treeSet-------------");
		//由于Student实现了Comparable类的compareTo方法，treeSet会根据Student类的排序算法进行排序
		Set set=new TreeSet();
		set.add(new Student("TOM", 90));
		set.add(new Student("JIM", 60));
		set.add(new Student("jerry", 80));
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Student stu = (Student)iter.next();
			System.out.println(stu.name+" "+stu.score);
		}
		
		//TreeMap已经实现了Comparable接口
		Map<String, String> map = new TreeMap<>();
		map.put("7", "777");
		map.put("5", "555");
		map.put("9", "999");
		//由于string已经实现了Comparable类的comapreTo方法
		Set<Entry<String, String>> set2 = map.entrySet();
		Iterator<Entry<String, String>> iterator = set2.iterator();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+"-->"+next.getValue());
		}
		
	}
	
}
