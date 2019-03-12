package IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReadTest {

	public static void main(String[] args) throws Exception{
		String path="C:\\Users\\liangyintian\\Desktop\\1.txt";
		
		try(
				Reader reader=new FileReader(path);
				BufferedReader bufferedReader=new BufferedReader(reader);
		)
		{
			StringBuilder sb = new StringBuilder();
			String data;
			
			while((data=bufferedReader.readLine())!=null) {
				sb.append(data).append("\n");
			}
			System.out.println(sb.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
