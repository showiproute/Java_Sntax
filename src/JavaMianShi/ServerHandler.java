package JavaMianShi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket; 
public class ServerHandler implements Runnable{
	private Socket socket;
	public  ServerHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		PrintWriter out=null;
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			String expression;
			String result;
			while(true) {
				if((expression=in.readLine())!=null) break;
				System.out.println("服务器收到消息:"+expression);
				try {
				}catch (Exception e) {
					// TODO: handle exception
					result="计算错误:"+e.getMessage();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(out!=null) {
				out.close();
				out=null;
			}
			if(socket!=null) {
				try {
					socket.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				socket=null;
			}
		}
	}
	
	
}
