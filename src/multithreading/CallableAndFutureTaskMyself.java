package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTaskMyself {
	
	public static class callable implements Callable<Integer>{
		private int i;
		
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().isAlive());
			for(;i<10;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
			
			return i;
		}
	}
	
	public static void main(String[] args) {
		callable callable = new callable();
		FutureTask<Integer> futureTask = new FutureTask<>(callable);
		Thread thread = new Thread(futureTask,"线程1");
		
		System.out.println("线程开始:"+System.currentTimeMillis()+"isAlive?:"+thread.isAlive());
		thread.start();
		try {
			Integer integer = futureTask.get();
			System.out.println(integer.toString());
			System.out.println("执行结束:"+System.currentTimeMillis()+"isAlive?"+thread.isAlive());
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
