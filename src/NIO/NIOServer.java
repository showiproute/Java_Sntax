package NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	public static void main(String[] args) throws Exception{
		//1.serverSelector 负责轮询是否有新的连接，服务端检测到有新的连接之后，不再创建一个新的线程
		//而是直接将新连接绑定到clientSelector上，这样就不用IO模型中1w个while循环在死等
		
		Selector serverSelector = Selector.open();
		//2. clientSelector负责轮询连接是否有数据可读
		Selector clientSelector = Selector.open();
		
		new Thread(()->{
			try {
				//对应IO编程中服务端启动
				ServerSocketChannel listenerChannel = ServerSocketChannel.open();
				listenerChannel.socket().bind(new InetSocketAddress(3333));
				listenerChannel.configureBlocking(false);
				listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
			
				while(true) {
					//检测是否有新的连接，这里1指的是阻塞的时间为 1ms
					if(serverSelector.select(1)>0) {
						Set<SelectionKey> set = serverSelector.selectedKeys();
						Iterator<SelectionKey> keyIterator = set.iterator();
					
						while(keyIterator.hasNext()) {
							SelectionKey key = keyIterator.next();
							if(key.isAcceptable()) {
								try {
									//(1)
									//每次来一个新的连接，不需要创建一个线程，而是直接注册到clientSelector上
									SocketChannel clientChannel=((ServerSocketChannel) key.channel()).accept();
									clientChannel.configureBlocking(false);
									clientChannel.register(clientSelector, SelectionKey.OP_READ);
								}finally {
									keyIterator.remove();
								}
							}
						}
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()->{
			try {
				while(true) {
					//(2)批量轮询是否有那些连接有数据可读，这里的1指的是阻塞的时间为1ms
					if(clientSelector.select(1) > 0) {
						Set<SelectionKey> set = clientSelector.selectedKeys();
						Iterator<SelectionKey> keyIterator = set.iterator();
					
						while(keyIterator.hasNext()) {
							SelectionKey key = keyIterator.next();
						
							if(key.isReadable()) {
								try {
									SocketChannel clientChannel=(SocketChannel)key.channel();
									ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
									//(3)面向buffer
									clientChannel.read(byteBuffer);
									byteBuffer.flip();
									System.out.println(
											Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}finally {
									keyIterator.remove();
									key.interestOps(SelectionKey.OP_READ);
								}
							}
						}
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}).start();
		
		
	}
	
	
}
