package BIO;

import java.net.Socket;
import java.util.Date;



public class IOClient {

	public static final int PORT=3333;
	public static final String HOSTNAME="127.0.0.1";
	
	public static class ThreadClient extends Thread{
		
		public static String ThreadClientName;
		public static int counts=0;
		
		public ThreadClient(String name) {
			// TODO Auto-generated constructor stub
			this.ThreadClientName=name;
		}
		
		
		@SuppressWarnings("resource")
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Socket socket = new Socket(HOSTNAME,PORT);
				while(true) {
					try {
						socket.getOutputStream().write((new Date()+":from client!"+this.ThreadClientName).getBytes());
						Thread.sleep(5000);
						counts++;
						if(counts==5) {
							ThreadClient threadClient2 = new ThreadClient("线程2");
							new Thread(threadClient2).start();
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ThreadClient threadClient = new ThreadClient("线程1");
		new Thread(threadClient).start();;
		Thread.sleep(5000);
		
	}
	
}
