package BIO;

import java.util.Random;


public class TestMain {

	public static void main(String[] args) throws Exception{
		//运行服务器
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerBetter.start();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}}).start();
		//比卖你客户端先于服务器启动前执行代码
		Thread.sleep(100);
		
		//运行客户端
		char[] operators= {'+','-','*','/'};
		Random random = new Random(System.currentTimeMillis());
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					//随机产生算术表达式
					String expression=random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1);
					Client.send(expression);
					try {
						Thread.currentThread().sleep(random.nextInt(1000));
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
	}
}
