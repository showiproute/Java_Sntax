package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTaskTest {

	public static class Callable1 implements Callable<Integer>{
		private int i;
		@Override
		public Integer call() throws Exception{
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().isAlive());
			for(;i<=10;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
			return i;
		}
	}
	
	public static void main(String[] args) {
		//创建Callable实现类对象实例
		Callable1 callable1 = new Callable1();
		//用FutureTask类来包装Callable实现类对象
		FutureTask<Integer> future = new FutureTask<>(callable1);
		//用Thread类包装FutureTask类对象
		Thread t1 = new Thread(future,"线程1");
		System.out.println("Start前："+t1.isAlive());
		System.out.println(System.currentTimeMillis());
		t1.start();
		try {
			
			//等待t1线程执行结束后返回结果
			Integer integer = future.get();
			System.out.println(integer.toString());
			System.out.println(System.currentTimeMillis());
			System.out.println("子线程结束后:"+t1.isAlive());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
