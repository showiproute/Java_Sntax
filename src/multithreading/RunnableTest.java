package multithreading;

public class RunnableTest {

	//创建Runnable实现类
	public static class Runnable1 implements Runnable{
		private int i;
		//重写run方法
		@Override
		public void run() {
			for(;i<=10;i++) {
				//只能用Thread.currentThread()获取当前运行的线程对象
				System.out.println(Thread.currentThread().getName()+"i="+i);
				
			}
		}
	}
	

	public static void main(String[] args) {
		//创建Runnable 实现类对象
		Runnable1 n1=new Runnable1();
		//将实现类的对象包装成Thread类对象
		Thread thread1=new Thread(n1,"线程1");
		Thread thread2=new Thread(n1,"线程2");
		//调用start()执行
		thread1.start();
		thread2.start();
		
		
	}
	
}
