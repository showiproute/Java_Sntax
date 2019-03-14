package multithreading;

public class Waiter implements Runnable{

	private Message message;
	public Waiter(Message message) {
		this.message=message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//调用message对象的同步方法
		message.doWait(Thread.currentThread().getName());
	}
	
}
