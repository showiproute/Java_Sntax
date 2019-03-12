package IOException;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamOutputStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path="C:\\Users\\liangyintian\\Desktop\\1.txt";
		
		try(
				//创建节点流
				FileOutputStream fout=new FileOutputStream(path);
				
				//封装数据流
				DataOutputStream dout=new DataOutputStream(fout);
		){
			//写数据
			dout.writeDouble(99.99);
			//关闭外层流
			dout.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try (
			//创建节点流
			FileInputStream fis=new FileInputStream(path);
			
			//封装过滤流
			DataInputStream din=new DataInputStream(fis);
		){
			//读数据
			double pi=din.readDouble();
			
			//关闭外层流
			din.close();
			System.out.println(pi);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
