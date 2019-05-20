package JavaMianShi;

import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s="abc";
		String s1=new String("abc");
		String s2=new String("abc");
		String s3="abc";
		if(s1==s) {
			System.out.println("s1=s");
		}else {
			System.out.println("s1!=s");
		}
		if(s2==s) {
			System.out.println("s2=s");
		}else {
			System.out.println("s2!=s");
		}
		if(s3==s) {
			System.out.println("s3=s");
		}else {
			System.out.println("s3!=s");
		}
		if(s1==s2) {
			System.out.println("s1=s2");
		}else {
			System.out.println("s1!=s2");
		}
		
		
	}
	
}
