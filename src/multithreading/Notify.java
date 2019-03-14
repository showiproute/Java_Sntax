package multithreading;

public class Notify implements Runnable{
	private Message message;
	
	public Notify(Message message) {
		this.message=message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	//先睡眠3000ms
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("3000ms 后");
		//调用message对象的同步方法
		message.doNotify(Thread.currentThread().getName());
	}
}
