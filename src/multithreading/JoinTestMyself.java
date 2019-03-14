package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import multithreading.JoinTestMyself.JoinTest;
import multithreading.JoinTestMyself.joinTmp;

public class JoinTestMyself {

	public static class joinTmp implements Runnable{
		private int i;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
		}
	}
	
	
	public static class JoinTest implements Callable<Integer>{
		private int i;
		
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			for(;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
			return i;
		}
		
	}
	
	public static void main(String[] args) {
		JoinTest joinTest = new JoinTest();
		FutureTask<Integer> futureTask = new FutureTask<>(joinTest);
		Thread thread = new Thread(futureTask,"子线程1");
		joinTmp joinTmp = new joinTmp();
		Thread thread2 = new Thread(joinTmp,"子线程2");
		thread.start();
		thread2.start();
		try {
			thread2.join();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("子线程1结束");
	}
	
}
