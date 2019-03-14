package multithreading;

/*
 * 类里有同步方法doWait()和doNotify()
 */
public class Message {

	public synchronized void doWait(String threadName) {
		System.out.println(threadName+"wait开始");
		//调用wait方法后，使得等待调用notify或notifyAll方法取消等待，并且释放同步锁
		try {
			this.wait();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public synchronized void doNotify(String threadName) {
		System.out.println(threadName+"notify开始");
		try {
			//随机唤醒一个被wait的线程
			this.notify();
			//唤醒所有被wait的线程
//			this.notifyAll();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(threadName+"notify结束");
	}
	
	
	
}
