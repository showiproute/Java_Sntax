package JavaMianShi;

import java.net.ServerSocket;
import java.net.Socket;

public final class ServerNormal {
	private static int DEFAULT_PORT=12345;
	
	private static ServerSocket server;
	
	public static void start() throws Exception{
		
		start(DEFAULT_PORT);
	}
	
	public synchronized static void start(int port) throws Exception{
		if(server!=null) return;
		try {
			server=new ServerSocket(port);
			System.out.println("服务器已经启动,端口号:"+port);
			
			while(true) {
				Socket socket=server.accept();
				new Thread(new ServerHandler(socket)).start();
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(server!=null) {
				System.out.println("服务器已经关闭");
				server.close();
				server=null;
		
			}
	}
	
	}
}
