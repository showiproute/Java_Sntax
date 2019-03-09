package Array;

public class Array_Foreach {

	/*
	 * 数组正向遍历、反向遍历、foreach遍历
	 */
	public static void main(String[] args) {
		
		int[] a=new int[4];
		a[0]=10;
		a[2]=20;
		System.out.println("反向遍历：");
		for(int i=a.length-1;i>=0;i--) {
			System.out.println(a[i]+" ");
		}
		System.out.println("\n正向遍历:");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");
		}
		System.out.println("\n---------------");
		System.out.println("foreach遍历数组写法");
		for (int i : a) {
			System.out.println(i);
		}
	}
	
}
