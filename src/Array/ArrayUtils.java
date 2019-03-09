package Array;

import java.util.Arrays;

public class ArrayUtils {

	/*
	 * 1、boolean equals(type[] a, type[b]);
该方法表示如果a数组和b数组的长度相等，而且a数组和b数组的数组元素也一一相同，该方法将返回true。
数组的引用变量也可以调用equals方法，但该equals方法继承了Object的equals，而Object的equals方法是比对两个对象是否相等，通常没有太大实用价值。
	 */
	
	private static void testEquals() {
		int[] a=new int[] {1,2,3};
		int[] b=new int[] {1,2,3};
		int[] c=a;
		System.out.println(a.equals(b)); //输出false，a和b不是统一数组
		System.out.println(a == b); //false a和b不是同一数组
		System.out.println(a.equals(c)); //true 引用
		System.out.println(Arrays.equals(a, b)); //true 比较长度 再比较元素是否一致
	}
	
	private static void testSort() {
		int[] a=new int[] {3,1,2};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static void testCopy() {
		int[] a= {1,5,8,3};
		int[] b=Arrays.copyOf(a, 2);
		int[] c=Arrays.copyOf(a, 6);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}
	
	private static void testCopyOfRange() {
		int[] a= {1,2,3};
		int[] d=Arrays.copyOfRange(a, 0, 1);
		System.out.println(Arrays.toString(d));
	}
	
	public static void main(String[] args) {
//		testEquals();
//		testSort();
//		testCopy();
		testCopyOfRange();
		
	}
	
}
