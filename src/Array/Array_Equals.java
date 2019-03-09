package Array;

import java.util.Arrays;

public class Array_Equals {
	
	/*
	 * 判断两个数组的元素是否相等
	 * 1、如果两个数组是统一地址，返回true
	 * 2、如果两个数组中有一个是null，返回false
	 * 3、判断两个数组的长度
	 * 4、两个数组的每一个元素要相等
	 */
	private static boolean isEquals(int[] a,int[] b) {
		if(a==b) {
			return true;
		}
		//防御式编程
		//防御a或b为null类型
		if(a==null|| b==null) {
			return false;
		}
		//判断两个数组的长度
		//null.length就报空指针
		if(a.length!=b.length) {
			return false;
		}
		for(int i=0;i<a.length;i++) {
			//判断两个数组元素中，如果有不相等的值，就返回false
			if(a[i]!=b[i]) {
				return false;
			}
		}
		//如果两个数组元素都比较完了，并且都相等，返回true
		return true;
	
	}
	
	public static void main(String[] args) {
		int[] a=new int[] {3,5,7,2};
		int[] b=null;
		
		int[] c=a;
		
		//判断两个数组的元素是相等的，如何判断
		//对于引用对象来说，==判断的是两个引用对象所指的首地址是否相同
		System.out.println("\na==c:"+(a==c));
		//equals()方法，默认是判断的两个引用对象所指的首地址是否相同
		System.out.println("a.equals(b):"+a.equals(b));
		
		System.out.println(isEquals(a, b));
		System.out.println(isEquals(a, c));
		System.out.println(Arrays.equals(a, b));
		System.out.println(Arrays.equals(a, c));
		
	}
}
