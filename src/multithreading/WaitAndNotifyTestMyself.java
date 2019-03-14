package multithreading;

public class WaitAndNotifyTestMyself {

	public static void main(String[] args) {
		
		MessageMyself messageMyself = new MessageMyself();
		WaiterMyself waiterMyself = new WaiterMyself(messageMyself);
		WaiterMyself waiterMyself2 = new WaiterMyself(messageMyself);
		
		Thread thread = new Thread(waiterMyself,"thread1");
		Thread thread2 = new Thread(waiterMyself2,"thread2");
		
		thread.start();
		thread2.start();
		
		NotifyMyself notifyMyself = new NotifyMyself(messageMyself);
		Thread thread3 = new Thread(notifyMyself,"notify");
		
		thread3.start();
		
		
		
	}
}
