package IOException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileCopyBufferedTest {

	public static void main(String[] args) throws Exception{
		String path="C:\\Users\\liangyintian\\Desktop\\1.png";
		String targetPath="C:\\Users\\liangyintian\\Desktop\\4.png";
		
		try(
			
			InputStream fis=new FileInputStream(path);
			FileOutputStream fos=new FileOutputStream(targetPath);
				
			BufferedInputStream buffis=new BufferedInputStream(fis);
			BufferedOutputStream buffos=new BufferedOutputStream(fos);
				
		)
		{
			byte[] buff=new byte[32];
			
			int hasRead;
			
			while((hasRead=buffis.read(buff))!=-1) {
				buffos.write(buff,0,hasRead);
			}
			buffos.flush();
			System.out.println("end");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
