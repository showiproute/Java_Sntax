package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	public static class Message{
		private ReentrantLock lock=new ReentrantLock();
		
		private Condition cond=lock.newCondition();
		
		public void doWaitttt(String threadName) {
			lock.lock();
			try {
				System.out.println(threadName+"wait开始");
				//调用await方法后，使其等待，并且释放锁
				try {
					cond.await();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println(threadName+"wait结束");
			}finally {
				lock.unlock();
			}
			
		}
		
		public void doNotifyyyy(String threadName) {
			lock.lock();
			try {
				System.out.println(threadName+"notify开始");
				try {
					//随机唤醒一个被await的线程
					//cond.singal()
					//唤醒所有被await的线程
					cond.signalAll();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println(threadName+"notify结束");
			}finally {
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
			mss.doWaitttt(Thread.currentThread().getName());
			
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
			mss.doNotifyyyy(Thread.currentThread().getName());
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Message message = new Message();
		Waiter waiter = new Waiter(message);
		Waiter waiter2 = new Waiter(message);
		
		Thread thread = new Thread(waiter,"thread1");
		Thread thread2 = new Thread(waiter2,"thread2");
		
		thread.start();
		thread2.start();
		
		Notify notify = new Notify(message);
		Thread thread3 = new Thread(notify,"notify");
		thread3.start();
		
	}
	
	
}
