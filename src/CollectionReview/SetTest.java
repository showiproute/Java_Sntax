package CollectionReview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("hello");
		set.add("world");
		set.add("java");
		//加入重复元素时，add方法会返回false
//		set.add("hello");
		//迭代办理
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Object value = iter.next();
			System.out.println(value);
		}
	}
}
