package Array;

public class Array_copy {
	/*
	 * 数组的拷贝
	 */

	public static void main(String[] args) {
		int[] a=new int[] {3,5,7,2};
		int[] b=new int[4];
		//将数组a中的内容拷贝到数组b中
		b[0]=a[0];
		b[1]=a[1];
		//用循环来给b赋值
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");
			b[i]=a[i];
		}
		System.out.println("-------------");
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]+" ");
		}
	}
}
