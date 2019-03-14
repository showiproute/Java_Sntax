package multithreading;

public class WaiterMyself implements Runnable{
	
	private MessageMyself mm;
	
	public WaiterMyself(MessageMyself mm) {
		// TODO Auto-generated constructor stub
		this.mm=mm;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mm.doWait(Thread.currentThread().getName());
		
	}

}
