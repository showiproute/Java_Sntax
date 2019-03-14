package multithreading;

public class RunnableTest2 {

	public static void main(String[] args) {
		
		//创建Runnable匿名类
		Runnable n1=new Runnable() {
			private int i;
			
			//重写run方法
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(;i<=10;i++) {
					//只能用Thread.currentThread()获取当前运行的线程对象
					System.out.println(Thread.currentThread().getName()+"i="+i);
				}
			}
		};
		
		//将实现类包装成Thread类对象
		Thread thread1 = new Thread(n1,"线程1");
		Thread thread2=new Thread(n1, "线程2");
		
		thread1.start();
		thread2.start();
	
	}
	
	
}
