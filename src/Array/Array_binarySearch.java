package Array;

public class Array_binarySearch {

	private static int binarySearch(int[] array,int key) {
		int low=0;
		int high=array.length-1;
		while(low<=high) {
			int middle=(low+high)/2;
			if(key>array[middle]) {
				low=middle+1;
			}
			else if(key<array[middle]) {
				high=middle-1;
			}else {
				return middle;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
			
		int[] array= {1,2,3,4,5,6,7};
		int result = binarySearch(array, 3);
		System.out.println(result);
	}
	
}
