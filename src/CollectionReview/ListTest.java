package CollectionReview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		//isEmpty判断空，size为0返回true
		System.out.println("list.isEmpty():"+list.isEmpty());
		//List长度
		System.out.println("list.size():"+list.size());
		//add添加List元素
		list.add(111);
		list.add("aaa");
		System.out.println("list.isEmpty():"+list.isEmpty());
		//List长度
		System.out.println("list.size():"+list.size());
		//删除指定List元素
		list.remove("aaa");
		System.out.println("list.isEmpty():"+list.isEmpty());
		//List长度
		System.out.println("list.size():"+list.size());
		System.out.println("list.contains(111):"+list.contains(111));
		
		//清空list元素
		list.clear();
		System.out.println("list.isEmpty():"+list.isEmpty());
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ccc");
		String str="ccc";
		//str在List中的下标是多少，找到返回下标，找不到返回-1
		int index = list1.indexOf(str);
		System.out.println("str index:"+index);
		System.out.println("取List第0个下标的元素:"+list1.get(0));
		list1.add(1,"ddd");
		System.out.println("取List第1个下标的元素:"+list1.get(1));
		System.out.println("str index:"+list1.indexOf("bbb"));
		
		//List遍历方式for循环
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("\n-----------------------");
		
		//foreach循环遍历，前提List必须有泛型
		for (String s : list1) {
			System.out.print(s+" ");
		}
		System.out.println("\n-----------------------");
		list1.remove("ddd");
		list1.add("ddd");
		for (String s : list1) {
			System.out.println(s+" ");
		}
		
		//Iterator迭代遍历
		Iterator<String> it1 = list1.iterator();
		while(it1.hasNext()) {
			String s = it1.next();
			System.out.println(s+" ");
		}
	}
	
}
