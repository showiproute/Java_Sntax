package multithreading;

public class ThreadTest_myself {

	public static class ThreadTest extends Thread{
		
		private int i=0;
		
		public ThreadTest() {
			// TODO Auto-generated constructor stub
		}
		
		public ThreadTest(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(;i<10;i++) {
				System.out.println("i="+i+this.getName());
			}
		}
	}
	
	public static void main(String[] args) {
		
		ThreadTest threadTest1 = new ThreadTest("First");
		ThreadTest threadTest2 = new ThreadTest("Second");
		
		Thread thread1 = new Thread(threadTest1);
		Thread thread2 = new Thread(threadTest2);
		
		thread1.start();
		thread2.start();
		
		
	}
	
}
