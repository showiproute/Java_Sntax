package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class TheModeOfProduceAndCustomer {

	
	public static class Producer implements Runnable{
		
		private String threadName;
		private ArrayBlockingQueue<String> queue;
		int i=1;
		
		public Producer(ArrayBlockingQueue<String> queue) {
			// TODO Auto-generated constructor stub
			this.queue=queue;
		}
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			this.threadName=Thread.currentThread().getName();
			for(;i<=10;i++) {
				try {
					Thread.sleep(300);
					System.out.println(threadName+"开始生产第"+i+"个苹果");
					queue.put("apple");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("生产者生产完了10个苹果");
			
		}	
	}
	
	public static class Consumer implements Runnable{
		
		private String threadName;
		private ArrayBlockingQueue<String> queue;
		int i=1;
		
		public Consumer(ArrayBlockingQueue<String> queue) {
			// TODO Auto-generated constructor stub
			this.queue=queue;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			this.threadName=Thread.currentThread().getName();
			for(;i<=10;i++) {
				try {
					Thread.sleep(1000);
					System.out.println(threadName+"开始消费第"+i+"个苹果");
					queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("消费者线程执行完毕");
		}
	}
	
	public static void main(String[] args) {
		
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
		Producer producer = new Producer(arrayBlockingQueue);
		Consumer consumer = new Consumer(arrayBlockingQueue);
		
		Thread thread = new Thread(producer,"producer");
		Thread thread2 = new Thread(consumer,"consumer");
		thread.start();
		thread2.start();
		
		
		
	}
	
	
}
