package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestMyself {

	public static class Message{
		
		ReentrantLock lock=new ReentrantLock();
		Condition cond=lock.newCondition();
		
		public void waiter(String threadName) {
			
			lock.lock();
			try {
				System.out.println(threadName+"await start");
				cond.await();
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				System.out.println(threadName+"await end");
				lock.unlock();
			}
		}
		
		public void notify(String threadName) throws InterruptedException {
			Thread.sleep(1000);
			lock.lock();
			try {
				System.out.println(threadName+"singall start");
				cond.signalAll();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				System.out.println(threadName+"singall end");
				lock.unlock();
			}
		}
		
	}
	
	public static class Waiter implements Runnable{
		private Message mss;
		
		public Waiter(Message mss) {
			// TODO Auto-generated constructor stub
			this.mss=mss;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			mss.waiter(Thread.currentThread().getName());
			
			
		}
	}
	
	public static class Notify implements Runnable{
		private Message mss;
		
		public Notify(Message mss) {
			this.mss=mss;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				mss.notify(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Message message = new Message();
		Waiter waiter = new Waiter(message);
		Waiter waiter2 = new Waiter(message);
		
		Notify notify = new Notify(message);
		
		Thread thread = new Thread(waiter,"thread1");
		Thread thread2 = new Thread(waiter2,"thread2");
		Thread thread3 = new Thread(notify,"notify");
		
		thread.start();
		thread2.start();
		thread3.start();
		
		
		
	}

}
