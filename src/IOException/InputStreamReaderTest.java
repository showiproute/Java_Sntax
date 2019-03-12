package IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderTest {

	public static void main(String[] args) throws Exception{
		String path="C:\\Users\\liangyintian\\Desktop\\1.txt";
		String targetPath="C:\\Users\\liangyintian\\Desktop\\2.txt";
		File input=new File(path);
		File output=new File(targetPath);
		try(
				FileInputStream fis=new FileInputStream(input);
				InputStreamReader isr=new InputStreamReader(fis,"gbk");
				
				FileOutputStream fos=new FileOutputStream(output);
				OutputStreamWriter fosw=new OutputStreamWriter(fos,"gbk");
				BufferedReader br=new BufferedReader(isr);
				BufferedWriter bw=new BufferedWriter(fosw);
		)
		{
			String data;
			StringBuilder sb = new StringBuilder();
			while((data=br.readLine())!=null) {
				sb.append(data).append("\n");
				bw.write(sb.toString());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}
