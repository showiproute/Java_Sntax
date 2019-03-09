package Array;

public class Array_search {

	
	private static int search(int key,int[] a) {
		int i=0;
		for(;i<=a.length-1;i++) {
			if(a[i]==key) {
				break;
			}
		}
		if(i==a.length) {
			return -1;
		}else {
			return i;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] a= {2,4,6,2,3,7,8,5};
		int key=8;
		int index=search(key, a);
		System.out.println(index);
		
	}
	
}
