package multithreading;

public class MessageMyself {
	
	public synchronized void doWait(String threadName) {
		System.out.println(threadName+"wait开始");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void doNotify(String threadName) {
		System.out.println(threadName+"notify开始");
		try {
			//随机唤醒
			this.notify();
			//唤醒所有
//			this.notifyAll();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("notify结束");
	}	

}
