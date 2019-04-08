package JavaMianShi;

import java.util.concurrent.ArrayBlockingQueue;

import multithreading.Customer;

public class BlockingQueueTest {

	public static class Producer implements Runnable{
		
		private ArrayBlockingQueue<String> queue;
		public Producer(ArrayBlockingQueue<String> queue) {
			this.queue=queue;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i=1;
			String name=Thread.currentThread().getName();
			for(;i<=10;i++) {
				try {
					Thread.sleep(300);
					System.out.println(name+"生产第"+i+"个苹果开始");
					queue.put("Apple");
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			System.out.println(name+"生产第"+i+"个苹果结束");
		}
	}
	
	public static class Consumer implements Runnable{
		private ArrayBlockingQueue<String> queue;
		public Consumer(ArrayBlockingQueue<String> queue) {
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
					queue.take();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println(name+"消费第"+i+"个苹果结束");
			}
			
		}
	}
	
	public static void main(String[] args) {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		Thread pThread = new Thread(new Producer(queue),"生产者线程:");
		pThread.start();
		
		Thread cThread = new Thread(new Customer(queue),"消费者线程");
		cThread.start();
	}
	
	
}
