package IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReadestChar {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path="C:\\Users\\liangyintian\\Desktop\\1.png";
		File file=new File(path);
		
		//关闭资源处理
		try (
			FileReader reader = new FileReader(file);
			
		)
		{
			StringBuilder sb = new StringBuilder();
			char[] cuff=new char[4];
			int hasRead;
			while((hasRead=reader.read(cuff))!=-1) {
				sb.append(cuff,0,hasRead);
			}
			System.out.println(sb.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
