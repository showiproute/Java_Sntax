package BIO;

import java.net.Socket;
import java.util.Date;

public class BIOClient {
	public static class IOClient{
		@SuppressWarnings("resource")
		public static void main(String[] args) {
			
			
			new Thread(()->{
				System.out.println("Client start");
				try {
					Socket socket = new Socket("127.0.0.1",5555);
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
