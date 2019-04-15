package JavaMianShi;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_Test {

	public static void main(String[] args) {
		ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();
		concurrentHashMap.put("111", "aaa");
		concurrentHashMap.put("222", "aaa");
		concurrentHashMap.put("222", "ccc");
		
		System.out.println(concurrentHashMap.toString());
		
	}
	
}
