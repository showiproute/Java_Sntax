package CollectionReview;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class mapKeyValueReview {

	private static final String Integer = null;

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		System.out.println("map.isEmpty():"+map.isEmpty());
		System.out.println("map.size():"+map.size());
		map.put(1, "a");
		map.put(5, "a");
		map.put(3, "n");
		map.put(9, "m");
		System.out.println("map.size():"+map.size());
		System.out.println("map.containsKey(5):"+map.containsKey(5));
		System.out.println("map.containsValue(n):"+map.containsValue("n"));
		
		System.out.println("------map.remove(3)后------");
		map.remove(3);
		System.out.println("map.size():"+map.size());
		
		System.out.println("-------map.clear()后------");
		map.clear();
		System.out.println("map.isEmpty():"+map.isEmpty());
		System.out.println("-----------------------");
		
		map.put(1, "a");
		map.put(5, "a");
		map.put(3, "n");
		map.put(9, "m");
		/*
		 * Map的遍历
		 * 1、获取map中的set键
		 * 2、遍历set
		 * 3、根据map的key来获取value
		 */
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key =(Integer) it.next();
			//map.get(key); 获取map的键对应的值
			String value=map.get(key);
			System.out.println(key+"-->"+value);
		}
		
		System.out.println("--------------------");
		/*
		 * 用map.entrySet()获取Entry的set集合
		 * 遍历Entry的set集合，获取每个Entry对象
		 * 根据entry.getKey获取key值
		 * 根据entry.getValue来获取value值
		 * 注意：如果map中的key值有null，不要用此种方法遍历，小心空指针
		 */
		Set<Entry<Integer, String>> set1 = map.entrySet();
		Iterator<Entry<Integer, String>> iterator = set1.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> entry =(Entry) iterator.next();
			//获取键
			int key =(Integer) entry.getKey();
			//获取值
			String value = entry.getValue();
			System.out.println(key+"-->"+value);
		}
		
		//获取所有值集合
		Collection<String> c = map.values();
		Iterator<String> iterator2 = c.iterator();
		while(iterator2.hasNext()) {
			String s = (String)iterator2.next();
			System.out.print(s+" ");
		}
	
	}
	
}
