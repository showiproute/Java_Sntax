package Basic_Syntax;

import java.util.Arrays;

public class data_type {

	public int add(int i,int j,int k) {
		return i+j+k;
	}
	
	public int del(int i) {
		return i;
	}
	
	private static void printinfo() {
		int n;
		int m=1;
		
		int s=1;
		
		final int s1=10;
		
		byte n1=127;
		
		long n2=422424L;
		
		double pi=3.14;
		
		float f=1.1f;
		
		char value='a';
		
		boolean flag=true;
	}
	private static void test2() {
		int m=5;
		while (m>1) {
			System.out.println("m+"+m);
			m--;
		}
	}
	
	public static void modify(int[] arr) {
		arr[0]=33;
	}
	
	public static void array_test() {
		int[] array=new int[4];
		array[0]=10;
		array[1]=20;
		array[2]=30;
		for(int s:array) {
			System.out.println(s+" ");
		}
		
		modify(array);
		for(int s:array) {
			System.out.println(s+" ");
		}

		int[] a= {3,5,7,2};
		int[] b=new int[4];
		
		b[0]=a[0];
		b[1]=a[1];
		
		int[][] arr_two=new int[3][4];
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				arr_two[i][j]=i+j;
			}
		}
	}
	public static void array_two_size() {
		int[][] arr=new int[3][];
		
		arr[0]=new int[3];
		
		arr[1]=new int[1];
		
		arr[0][1]=1;
		
		arr[0][2]=2;
		arr[1][0]=10;
		
		arr[2]=new int[] {1,2,3,4};
		
		arr[1]=new int[] {3,4,5,2};
	}
	public static void array_test3() {
		int[][] arr= {{10,20,30},{30,40},{50,60}};
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
			System.out.println(arr[i]);
		}
		
		for(int[] i:arr) {
			for(int j:i) {
				System.out.println(j);
			}
		}
	}
	public static void array_test4() {
		int[] a =new int[] {1,2,3};
		int[] b=new int[] {1,2,3};
		int[] c=a;
		System.out.println(a.equals(b));
		System.out.println(Arrays.equals(a, c));
		System.out.println("---------------------");
		System.out.println(a.toString());
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void array_test5() {
		int[] a=new int[]{1,3,4,5};
		int[] c=new int[] {5,6,7,8};
		int[] d=Arrays.copyOf(a, 5);
		System.out.println(Arrays.toString(d));
		int[] e=Arrays.copyOfRange(c, 1, 3);
		System.out.println(Arrays.toString(e));
	}
	
	public class Person{
		String name;
		public int age=10;
		public static final int EYE_NUM=2;
		
		public void talk() {
			System.out.println("do talk()");
		}

		public void action(String content) {
			System.out.println("do action():"+content);
		}
		
		public void play(String content) {
			System.out.println("do play()"+content);
		}
		
	}

	public static void play(String content) {
		System.out.println("do play:"+content);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		
		
	
				
		
			
	}













}
