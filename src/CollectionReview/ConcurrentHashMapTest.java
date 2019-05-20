package CollectionReview;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> concurrentHashMap=new ConcurrentHashMap<>();
		
		concurrentHashMap.put(1, 111);
		concurrentHashMap.put(2, 222);
		for (Entry<Integer, Integer> keyValue : concurrentHashMap.entrySet()) {
			System.out.println(keyValue.getKey());
			System.out.println(keyValue.getValue());
		}
	}
	
	
}




