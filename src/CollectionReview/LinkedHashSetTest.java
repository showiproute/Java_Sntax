package CollectionReview;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		Set set=new LinkedHashSet();
		set.add("hello");
		set.add("world");
		set.add("java");
		//顺序插入 并且插入的值唯一
//		set.add("hello");
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
