package Java_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaInputStream {

	public static void main(String[] args) throws IOException {
//		byte[] input=new byte[1024];
//		try(FileInputStream in=new FileInputStream("C:\\Users\\liangyintian\\Desktop\\data.txt")) {
//			int bytesRead=in.read(input);
//			System.out.println(bytesRead);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		//more safe way
		FileInputStream inNew=new FileInputStream("C:\\Users\\liangyintian\\Desktop\\data.txt");
//		int bytesRead=0;
//		int bytesToRead=1024;
//		byte[] inputNew=new byte[bytesToRead];
//		while(bytesRead<bytesToRead) {
//			int result=inNew.read(inputNew,bytesRead,bytesToRead-bytesRead);
//			if(result==-1) break;
//			bytesRead+=result;
//			System.out.println(bytesRead);
//		}
//		
		int bytesAvailable = inNew.available();
		byte[] inputNew2=new byte[bytesAvailable];
		int bytesReadNew=inNew.read(inputNew2,0,bytesAvailable);
		System.out.println(bytesReadNew);
		//立即继续执行程序的其他部分
		
		
		
		
	}
	
}
