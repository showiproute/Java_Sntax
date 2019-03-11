package CollectionReview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		
		Collection c = new ArrayList();
		
		//isEmpty判断空，size为0返回true
		System.out.println("c.isEmpty():"+c.isEmpty());
		//集合长度
		System.out.println("c.size():"+c.size());
		//add添加集合元素
		c.add(111);
		c.add("aaa");
		System.out.println("c.isEmpty():"+c.isEmpty());
		//集合长度
		System.out.println("c.size():"+c.size());
		//删除指定集合元素
		c.remove("aaa");
		System.out.println("c.isEmpty():"+c.isEmpty());
		//集合长度
		System.out.println("c.size():"+c.size());
		System.out.println("c.contains(111):"+c.contains(111));
		//清空集合元素
		c.clear();
		System.out.println("c.isEmpty():"+c.isEmpty());
		c.add(222);
		c.add("bbb");
		
		//调用集合的实现类方法，创建Iterator
		Iterator it = c.iterator();
		//通过iterator变量进行迭代遍历
		while(it.hasNext()) {
			Object obj = it.next();
//			System.out.println(obj);
			//因为集合里面含有不同类型的元素，所以想要获取集合中真正的元素类型，需要判断类型再强转
			if(obj.getClass()==String.class) {
				System.out.println((String)obj);
			}
			if(obj.getClass()==Integer.class) {
				System.out.println((Integer)obj);
			}
		}
		
		//规定集合泛型为String，说明集合里元素只能是String类型
		ArrayList<String> c1 = new ArrayList<String>();
		//如果添加的不是String，则编译器报错
		//c1.add(111);
		c1.add("haha");
		c1.add("ddd");
		c1.add("asdasd");
		Iterator it1 = c1.iterator();
		while (it1.hasNext()) {
			String str = (String)it1.next();
			System.out.print(str+" ");
		}
	}
	
}
