package Array;

public class Array_Static_init {

	public static void main(String[] args) {
		//定义一个int类型的数组 a
		//Type[] arrayName; 声明
		//arrayName=new Type[]{element1,element2,element3....};
		int[] a;
		a=new int[] {1,2,3,4};
		//定义一个int类型的数组b,初始化{5,4,3,2,1}
		int[] b=new int[]{5,4,3,2,1};
		//声明数组，并给数组静态初始化，简写方式
		int[] c= {2,4,6,8,10};
		
		//遍历数组
		
		//1)获取数组的长度
		int length=c.length;
		System.out.println("数组c的长度:"+length);
		//2)获取数组的下标，数组下标的范围[0 -- 数组的长度-1]
		
		//3)获取数组的元素，根据数组的下标来获取
		/*
		 * 获取数组的第一个元素 a[0];
		 * 获取数组的第二个元素 a[1];
		 * 获取数组的最后一个元素: a[a.length-1];
		 */
		//变量i 相当于数组的下标
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"]:"+a[i]);
		}
		
	}
	
	
}
