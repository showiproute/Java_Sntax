package Java_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
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
		
		InputStream in=null;
		try {
			in=new FileInputStream("/tmp/data.txt");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try(FileInputStream in2=new FileInputStream("/tmp/data.txt")){
		
			System.out.println("new way");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		byte[] input=new byte[10];
		for(int i=0;i<input.length;i++) {
			int b=in.read();
			if(b==-1) break;
			input[i]=(byte)b;
		}
		
		byte[] input2=new byte[1024];
		int bytestRead=in.read(input2);
		
		
		
	}
	
}
