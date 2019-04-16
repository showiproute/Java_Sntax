package BIO;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BIOModle_ver2 {

	public static class IOServer{
		public static void main(String[] args) throws Exception{
			ServerSocket serverSocket = new ServerSocket(8000);
			
			//(1)接受新连接线程
			new Thread(()->{
				while(true) {
					try {
						//(1)阻塞方法获取新的连接
						Socket socket=serverSocket.accept();
						
						//(2)为每个新的连接创建一个线程，负责读取数据
						new Thread(()->{
							try {
								byte[] data=new byte[1024];
								InputStream inputStream=socket.getInputStream();
								while(true) {
									int len;
									//(3)按字节流的方式读取数据
									while((len=inputStream.read(data))!=-1) {
										System.out.println(new String(data,0,len));
									}
								}
							}catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						});
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}).start();;
		}
	}
	
	public static class IOClient{
		@SuppressWarnings("resource")
		public static void main(String[] args) {
			new Thread(()->{
				try {
					Socket socket = new Socket("127.0.0.1",8000);
					while(true) {
						socket.getOutputStream().write((new Date()+":helloworld").getBytes());
						Thread.sleep(1000);
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			}).start();;
		}
	}
	
	
}
