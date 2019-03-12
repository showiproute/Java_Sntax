package IOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTestBytesTry {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String path="C:\\Users\\liangyintian\\Desktop\\1.png";
		String targetpath="C:\\Users\\liangyintian\\Desktop\\3.png";
		try(
				FileInputStream fis=new FileInputStream(path);
				FileOutputStream fos=new FileOutputStream(targetpath);
		)
		{
			byte[] buff=new byte[24];
			int hasRead;
			while((hasRead=fis.read(buff))!=-1) {
				fos.write(buff,0,hasRead);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
