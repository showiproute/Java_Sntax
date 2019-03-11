package CollectionReview;

import java.util.HashSet;

/*
 * 实现类 HashSet
 * 如果要正常使用HashSet存放对象，为了保证对象的内容不重复，则要求这个对象满足:
 * 1.覆盖equals方法，要求相同的对象，调用equals方法返回true
 * 2.覆盖hashcode方法，要求，相同对象的hashcode相同，不同对象的hashcode尽量不同
 * HashSet存放字符串，因为字符串重写了Object的equals和hashcode方法，所以可以用HashSet给字符串去重
 */

public class HashCodeTest {

	private int n;

	public HashCodeTest(int n) {
		this.n=n;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("do equals()");
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("do hashCode()");
		return this.n;
	}
	
	public static void main(String[] args) {
		HashSet<HashCodeTest> set = new HashSet<HashCodeTest>();
		HashCodeTest h1 = new HashCodeTest(1);
		HashCodeTest h2= new HashCodeTest(2);
		HashCodeTest h3 = new HashCodeTest(1);
		
		System.out.println("--------");
		//先调hashCode()方法得到hash值，再和set集合里的其他hash值进行比对，如果不同，则添加进去
		//如果有相同则调用equals()方法与hash值相同的对象进行判断，是否是同一对象
		//如果是，则添加失败;否则添加成功
		set.add(h1);
		System.out.println("----------");
	
		if(!set.add(h2)) {
			System.out.println("添加失败");
		}else {
			System.out.println("添加成功");
		}
		
		if(!set.add(h3)) {
			System.out.println("添加失败");
		}else {
			System.out.println("添加成功");
		}
	
	}
	
	/*
	 * 结论：
	 * 对于两个对象
	 * 1)如果调用equals方法得到的结果为true，则两个对象的hashcode值必定相等
	 * 2)如果equals方法得到的结果为false，则两个对象的hashcode值不一定不同
	 * 3)如果两个对象的hashcode值不等，则equals方法得到的结果必定为false
	 * 4)如果两个对象的hashcode值相等，则equals方法得到的结果未知
	 */
	
}
