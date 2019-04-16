package BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class IOServer {
	
	public static final int PORT=3333;
	
	public static ServerSocket serverSocket=null;
	
	public static class ThreadServer extends Thread{
		
		public ThreadServer(String name) {
			// TODO Auto-generated constructor stub
			super(name);
		}
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				serverSocket=new ServerSocket(PORT);
				ServerHandler serverHandler = new ServerHandler();
				new Thread(serverHandler,"threadServer").start();
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static class ServerHandler extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Socket socket = serverSocket.accept();
					
					try {
						int len;
						byte[] data=new byte[1024];
						InputStream inputStream = socket.getInputStream();
						
						while((len=inputStream.read(data))!=-1) {
							System.out.println(new String(data,0,len));
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ThreadServer threadServer = new ThreadServer("服务端线程1");
		new Thread(threadServer).start();
		
	}
	
}
