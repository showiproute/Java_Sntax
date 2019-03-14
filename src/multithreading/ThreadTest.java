package multithreading;

public class ThreadTest {

//创建一个线程类，继承Thread类
	public static class Thread1 extends Thread{
		//定义一个属性
		private int i;
		public Thread1() {
			
		}
		
		//创建带有线程名称的构造方法
		public Thread1(String name) {
			//调用的是父类的构造方法
			super(name);
		}
		
		//重写run()方法
		@Override
		public void run() {
			for(;i<=10;i++) {
				//继承Thread类的线程类，可以用this.getName()方法获取当前线程名称
				System.out.println(super.getName()+"i="+i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		//main方法是主线程
		System.out.println(Thread.currentThread().getName());
		//创建线程对象，调用带有线程名称的构造方法
		Thread1 t1= new Thread1("线程1");
		Thread1 t2 = new Thread1("线程2");
		//Thread t1=new Thread();
		//创建Thread类的对象，调用Thread(t1)
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		//调用start方法，执行线程
		//继承Thread类的线程类，多个线程对象不共享类里面的属性
		thread1.start();
		thread2.start();
	}
	
}
