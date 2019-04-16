package BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BIOModel {

	public static final String HOSTNAME="127.0.0.1";
	public static final int PORT=3456;
	
	
	public static class ThreadClient extends Thread{
		
		public static String ThreadName;
		
		public static int counts=0;
		
		public ThreadClient(String name) {
			// TODO Auto-generated constructor stub
			this.ThreadName=name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Socket socket = new Socket(HOSTNAME,PORT);
				while(true) {
					OutputStream out = socket.getOutputStream();
					out.write((new Date()+"from client"+"ThreadName:"+this.ThreadName).getBytes());
					Thread.sleep(2000);
				}
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static class ThreadServer extends Thread{
		public static String ThreadServerName;
		
		public ThreadServer(String name) {
			// TODO Auto-generated constructor stub
			this.ThreadServerName=name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				new ServerHandler(this.ThreadServerName).start();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class ServerHandler extends Thread{
		public static String ThreadServerName;
		
		public ServerHandler(String name) {
			// TODO Auto-generated constructor stub
			this.ThreadServerName=name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				ServerSocket serverSocket = new ServerSocket(PORT);
				Socket accept = serverSocket.accept();
				while(true) {
					int len=0;
					byte[] data=new byte[1024];
					InputStream inputStream = accept.getInputStream();
					while((len=inputStream.read(data))!=-1) {
						System.out.println(new String(data,0,len)+this.ThreadServerName);
					}
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadServer("server1").start();
//		new ThreadServer("server2").start();

		
//		ThreadClient threadClient = new ThreadClient("client1");
//		threadClient.setPriority(Thread.MAX_PRIORITY);
//		threadClient.start();
//		
//		ThreadClient threadClient2 = new ThreadClient("client2");
//		threadClient2.setPriority(Thread.MIN_PRIORITY);		
//	    threadClient2.start();

		//using threadPool
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i=0;i<3;i++) {
			fixedThreadPool.execute(new ThreadClient("client1"));
		}
		fixedThreadPool.shutdown();
		
		
		
	}
	
}
