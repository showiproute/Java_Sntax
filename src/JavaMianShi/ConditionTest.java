package JavaMianShi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	public static class Message{
		private ReentrantLock lock=new ReentrantLock();
		
		private Condition cond=lock.newCondition();
		
		public void doWait(String threadName) {
			lock.lock();
			
			try {
				System.out.println(threadName+"wait开始");
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
		
		public void doNotify(String threadName) {
			lock.lock();
			try {
				System.out.println(threadName+"notify开始");
				try {
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
	
}
