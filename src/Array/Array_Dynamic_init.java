package Array;

public class Array_Dynamic_init {

	/*
	 * 数组动态初始化
	 */
	
	public static void main(String[] args) {
		//先声明，后进行动态初始化
		int[] a;
		a=new int[6];
		//声明同时进行动态初始化
		int[] b=new int[6];
		//程序员设置数组长度，系统会自动给数组赋初始值，仅限于动态初始化
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");
		}
		
		//给数组a的第一个元素赋值3
		a[0]=3;
		//给数组a的最后一个元素赋值6
		a[a.length-1]=6;
		System.out.println("\n---------------");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		
	}
}
