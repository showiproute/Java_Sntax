package BIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 *用于处理一个客户端的socket链路
 */
public class ServerHandler implements Runnable{

	private Socket socket;
	public ServerHandler(Socket socket) {
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
				//通过BufferedReader读取一行
				//如果已经读到输入流尾部，返回null，推出循环
				//如果得到非空值，就尝试计算结果并返回
				if((expression=in.readLine())!=null) break;
				System.out.println("服务器收到消息:"+expression);
				try {
					result=Calculator.cal(expression).toString();
				}catch (Exception e) {
					// TODO: handle exception
					result="计算错误:"+e.getMessage();
				}
				out.println(result);
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//一些必要的清理工作
			if(in!=null) {
				try {
					in.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				in=null;
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
