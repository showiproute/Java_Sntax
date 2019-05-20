package Java_IO;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) {
		OutputStream out=null;
		try {
			out=new FileOutputStream("/tmp/data.txt");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(out!=null) {
				try {
					out.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		try(OutputStream out2=new FileOutputStream("/tmp/data.txt")){
			System.out.println("in jdk1.7");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
