package multithreading;

public class JoinTest {

	public static class JoinThread implements Runnable{
		private int i;
		@Override
		public void run() {
			for(;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
		}
	}
	
	public static void main(String[] args) {
		JoinThread jt= new JoinThread();
		Thread t = new Thread(jt,"子线程");
		System.out.println("子线程启动");
		t.start();
		try {
			t.join();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("子线程结束");
	}
	
}
