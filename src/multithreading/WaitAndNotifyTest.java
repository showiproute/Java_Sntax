package multithreading;

public class WaitAndNotifyTest {

	public static void main(String[] args) {
		//创建Message对象
		Message message=new Message();
		//创建两个Waiter线程
		new Thread(new Waiter(message),"wait线程1").start();
		new Thread(new Waiter(message),"wait线程2").start();

		//创建一个notify线程
		new Thread(new Notify(message),"Notify线程1").start();
	
	}
	

}
