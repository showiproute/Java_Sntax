package ExceptionReview;

import java.io.FileInputStream;
import java.io.IOException;

public class CreateException {

	private static void test() throws IOException{
		String path="a.txt";
		try {
			FileInputStream fis = new FileInputStream(path);	
		}catch (Exception e) {
			// TODO: handle exception
			throw new IOException(path+"dose not exist");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			test();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("-------");
			e.printStackTrace();
		}
	}
	
}
