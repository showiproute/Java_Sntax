package multithreading;

public class NotifyMyself implements Runnable{

	private MessageMyself mm;
	
	public NotifyMyself(MessageMyself mm) {
		this.mm=mm;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mm.doNotify(Thread.currentThread().getName());
	}
	
}
