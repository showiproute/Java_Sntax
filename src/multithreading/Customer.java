package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

/*
 * 创建消费者线程
 * 每1000ms消费一个苹果
 */

public class Customer implements Runnable{
	private ArrayBlockingQueue<String> queue;
	
	public Customer(ArrayBlockingQueue<String> queue) {
		this.queue=queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=1;
		String name=Thread.currentThread().getName();
		for(;i<=10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(name+"消费第"+i+"个苹果开始");
				//调用take方法，如果队列空了，则阻塞队列
				queue.take();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println(name+"消费第 "+ i + "个苹果结束");
	}

	public static void main(String[] args) {
		//创建线程队列
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		//创建生产者线程
		Thread pThread = new Thread(new Producter(queue),"生产者线程:");
		pThread.start();
		//创建消费者线程
		Thread cThread=new Thread(new Customer(queue),"消费者线程");
		cThread.start();
	}
}
