package IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 文件拷贝
 */
public class FileCopyTestBytes {

	public static void main(String[] args) {
		
		String path="C:\\Users\\liangyintian\\Desktop\\1.png";
		String targetPath="C:\\Users\\liangyintian\\Desktop\\2.png";
		System.out.println("start");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			//创建文件输入流
			fis=new FileInputStream(path);
			//创建文件输出流
			fos=new FileOutputStream(targetPath);
			//创建每次读流的单位
			byte[] buff=new byte[32];
			//记录每次读取buff数据的单位
			int hasRead;
			//每次夺取buff这么多数据
			while((hasRead=fis.read(buff))!=-1) {
				//每次写buff数组从下标0开始，你读多少，我写多少
				fos.write(buff,0,hasRead);
			}
			System.out.println("End");
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		finally {
			//关闭流资源
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
