package Java_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.zip.CRC32;

public class FilterStreamIO {

	public static void filterInputStream() throws Exception{
		InputStream fin=new FileInputStream("C:\\Users\\liangyintian\\Desktop\\data.txt");
		fin=new BufferedInputStream(fin);
		byte[] input=new byte[1024];
		int read = fin.read(input);
		System.out.println(read);
		
		DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\liangyintian\\Desktop\\data.txt")));
	}

	
	public static void dataInputStreamTest() throws Exception{
		InputStream in=new FileInputStream("C:\\\\Users\\\\liangyintian\\\\Desktop\\\\data.txt");
		in=new DataInputStream(in);
		byte[] output=new byte[1024];
		int read = in.read(output);
			
		System.out.println(read);
		System.out.println(new String(output));
		
	}
	
	public static void readAndWriteTest() throws Exception{
		Writer w=new FileWriter("C:\\\\Users\\\\liangyintian\\\\Desktop\\\\data.txt");
		char[] network= {'N','e','t','w','o','r','k'};
		w.write(network,0,network.length);
		w.close();
		
		Reader r=new FileReader("C:\\\\Users\\\\liangyintian\\\\Desktop\\\\data.txt");
		r=new BufferedReader(r);
		char[] output=new char[1024];
		r.read(output);
		System.out.println(output);
		r.close();
		
	}
		
	
	public static void inputStreamReaderTest() throws Exception{
		InputStream in=new FileInputStream("C:\\\\Users\\\\liangyintian\\\\Desktop\\\\data.txt");
		InputStreamReader isr=new InputStreamReader(in,"UTF-8");
		int read=0;
		StringBuilder sb=new StringBuilder();
		while((read=isr.read())!=-1) {
			sb.append((char)read);
		}
		
		System.out.println(sb.toString());
		isr.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
//		dataInputStreamTest();
//		readAndWriteTest();
		inputStreamReaderTest();
		
		
		
	}
	
}
