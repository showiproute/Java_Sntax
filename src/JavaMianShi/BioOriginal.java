package JavaMianShi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class BioOriginal {

	public static class Client{
		final static String ADDRESS="127.0.0.1";
		final static int PORT=7788;
		
		public static void main(String[] args) throws UnknownHostException, IOException {
			
			Socket socket=null;
			BufferedReader in=null;
			PrintWriter out=null;
			socket=new Socket(ADDRESS,PORT);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			
			out.println("接收到客户端的请求数据1111....");
			String response=in.readLine();
			System.out.println("Client:"+response);	
		}
	}
	
	public static class Server{
		final static int PORT=7788;
		public static void main(String[] args) throws Exception{
			
			ServerSocket server=null;
			server=new ServerSocket(PORT);
			//进行阻塞
			Socket socket=server.accept();
			
			//新建一个线程执行客户端任务
			new Thread(new ServerHandler(socket)).start();
			
		}
	}
	
	public static class ServerHandler implements Runnable{
		
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
				new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				out=new PrintWriter(this.socket.getOutputStream(),true);
				String body=null;
				while(true) {
					body=in.readLine();
					if(body==null) break;
					System.out.println("Server:"+body);
					System.out.println("服务器端回送响应的数据");
				}

			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
}
