package Array;

import java.util.Arrays;

import javax.xml.transform.Templates;

public class Array_sort {

	
	public static void bubbleSort(int[] array) throws Exception{
		int temp;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
	
		System.out.println(Arrays.toString(array));
	}
	
	public static void selectSort(int[] array) throws Exception{
		
		int index;
		for(int i=0;i<array.length;i++) {
			index=i;
			for(int j=i+1;j<array.length;j++) {
				if(array[index]>array[j]) {
					index=j;
				}
			}
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
		}
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void quickSort(int[] a) throws Exception{
		if(a.length>0) {
			int low=0;
			int high=a.length-1;
			quickSort(a,low,high);
		}
	}
	
	
	public static void quickSort(int[] a,int low,int high) throws Exception{
		if(low<high) {
			int middle=getMiddle(a, low, high);
			quickSort(a, 0, middle-1);
			quickSort(a, middle+1, high);
		}
	}
	

	public static int getMiddle(int[] a,int low,int high) throws Exception{
		int tmp=a[low];
		while(low<high) {
			while(low<high && tmp<=a[high]) {
				high--;
			}
			a[low]=a[high];
		
			while(low<high&&tmp>=a[low]) {
				low++;
			}
			a[high]=a[low];
		}
		a[low]=tmp;
		return low;
	}

	

	
	public static void main(String[] args) throws Exception{

		int[] array= {5,7,2,4,1,8,3,6};
//		bubbleSort(array);
		
//		selectSort(array);
		
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
