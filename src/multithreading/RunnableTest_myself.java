package multithreading;

public class RunnableTest_myself {
	
	public static class RunnableTestmyself implements Runnable{
		private int i;	
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(;i<10;i++)
				System.out.println(Thread.currentThread().getName()+"i="+i);

		}
		
	}

	
	public static void main(String[] args) {

		RunnableTestmyself run1 = new RunnableTestmyself();
		RunnableTestmyself run2 = new RunnableTestmyself();
		
		Thread thread1=new Thread(run1, "Thread1");
		Thread thread2=new Thread(run2,"Thread2");
		
		thread1.start();
		thread2.start();
		
		Runnable runnable=new Runnable() {
			private int i;
			public void run() {
				for(;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"i="+i);
				}
			}
		};
		
		Thread thread = new Thread(runnable,"new Thread");
		thread.start();
		
	}
	
}
