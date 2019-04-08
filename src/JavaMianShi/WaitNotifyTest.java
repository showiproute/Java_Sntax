package JavaMianShi;

public class WaitNotifyTest {
	public static class Message{
		public synchronized void doWait(String threadName) {
			System.out.println(threadName+"wait开始");
			try {
				this.wait();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(threadName+"wait结束");
		}
		
		public synchronized void doNotify(String threadName) {
			System.out.println(threadName+"notify开始");
			try {
				this.notifyAll();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(threadName+"notify结束");
		}
	}
	
	public static class Waiter implements Runnable{
		private Message message;
		public Waiter(Message message) {
			this.message=message;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			message.doWait(Thread.currentThread().getName());
		}
	}
	
	public static class Notify implements Runnable{
		
		private Message message;
		
		public Notify(Message message) {
			this.message=message;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("3000ms后:");
			message.doNotify(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Message message = new Message();
		new Thread(new Waiter(message),"wait线程1").start();
		new Thread(new Waiter(message),"wait线程2").start();
		
		new Thread(new Notify(message),"notify线程1").start();

	}
	
}
