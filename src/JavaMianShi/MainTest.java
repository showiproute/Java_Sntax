package JavaMianShi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MainTest {

	public static void main(String[] args) throws Exception{
		String pathName="C:\\Users\\liangyintian\\Desktop\\data.txt";
		FileReader reader = new FileReader(pathName);
		BufferedReader br = new BufferedReader(reader);
		String line;
		
		Map<String, Integer> treeMap=new TreeMap<>();
		while((line=br.readLine())!=null) {
			if(treeMap.containsKey(line)) {
				treeMap.put(line,treeMap.get(line)+1);
			}else {
				treeMap.put(line, 1);
			}
		}
		List<Entry<String,Integer>> list=new ArrayList<Entry<String, Integer>>(treeMap.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
	    
		for(Entry<String, Integer> e : list) {
			System.out.println(e.getKey()+":"+e.getValue());
		}

		
	}
	
	
}
