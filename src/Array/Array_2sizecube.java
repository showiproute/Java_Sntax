package Array;

import java.util.Arrays;

public class Array_2sizecube {

	public static void main(String[] args) {
		
//		int[][] array=new int[3][4];
//		array[0][0]=1111;
//		array[2][3]=4444;
//		
//		for(int i=0;i<=2;i++) {
//			for(int j=0;j<=3;j++) {
//				System.out.println("array:i,j"+array[i][j]);
//			}
//		}
		
//		//动态初始化时，二维数组，只定义行，不定义列
//		int[][] arr=new int[3][];
//		//给arr[0]这个行，设置列数为3列
//		arr[0]=new int[3];
//		//给arr[1]这个行，设置列数为1列
//		arr[1]=new int[1];
//		arr[0][1]=1;
//		arr[0][2]=2;
//		arr[1][0]=10;
//		
//		//对二维数组中的某一行，进行静态初始化时，不能简写成{1,5,7,9}
//		//给arr[2]这一行，设置列数为4列
//		arr[2]=new int[] {1,5,7,8};
//		System.out.println(Arrays.toString(arr[2]));
//		
//		//二维数组的长度，其实是行数
//		System.out.println(arr.length);
//		for(int i=0;i<arr.length-1;i++) {
//			//某一行的列的长度
//			for(int j=0;j<=arr[i].length-1;j++) {
//				System.out.println(arr[i][j]);
//			}
//		}
		
		//定义3行2列静态初始化数组
		//3行:{{},{},{}}
		//某行中的两列:{10,20}
		int[][] arr= {{10,20},{30,40},{50,60}};
		for(int i=0;i<=arr.length-1;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		System.out.println("----------------");
		//定义二维数组3行，第一行3列，第二行2列，第三行1列
		int[][] a= {{10,20,30},{40,50},{60}};
		for(int i=0;i<=a.length-1;i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
		
	}
}
