package JavaMianShi;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThreading {

	public static class Thread1 extends Thread{
		private int i;
		public Thread1() {
			
		}
		
		public Thread1(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(;i<=10;i++) {
				System.out.println(super.getName()+"i="+i);
			}
		}
		
	}
	
	public static class Runnable1 implements Runnable{
		private int i;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			for(;i<=10;i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public static class Callable1 implements Callable<Integer>{
		private int i;
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().isAlive());
			for(;i<=10;i++) {
				System.out.println(Thread.currentThread().getName());
			}
			
			return i;
		}
	}
	
	
	public static void main(String[] args) {
		
//		System.out.println(Thread.currentThread().getName());
//		
//		Thread1 t1 = new Thread1("线程1");
//		Thread1 t2=new Thread1("线程2");
//		
//		Thread thread1 = new Thread(t1);
//		Thread thread2 = new Thread(t2);
//	
//		thread1.start();
//		thread2.start();
//		Runnable1 n1 = new Runnable1();
//		Thread thread1=new Thread(n1,"线程1");
//		Thread thread2=new Thread(n1,"线程2");
//		thread1.start();
//		thread2.start();
//		Runnable n1=new Runnable() {
//			private int i;
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for(;i<=10;i++) {
//					System.out.println(Thread.currentThread().getName());
//				}
//			}
//		};
//		
//		Thread thread1=new Thread(n1,"线程1");
//		Thread thread2=new Thread(n1,"线程2");
//		Thread thread3=new Thread(n1,"线程3");
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		
		Callable1 callable1 = new Callable1();
		FutureTask<Integer> futureTask=new FutureTask<>(callable1);
		
		Thread t1=new Thread(futureTask,"线程1");
		System.out.println("Start前:"+t1.isAlive());
		System.out.println(System.currentTimeMillis());

		t1.start();
		try {
			System.out.println(futureTask.get());
			
			System.out.println(System.currentTimeMillis());
			System.out.println("子线程结束后:"+t1.isAlive());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
