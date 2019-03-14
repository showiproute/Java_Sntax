package multithreading;

public class TestYieldMyself extends Thread{

	private int i;
	
	public TestYieldMyself(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;i<10;i++) {
			if(i==3) {
				Thread.yield();
			}
			System.out.println(super.getName()+"i="+i);
		}
		
	}
	
	public static void main(String[] args) {
		
		TestYieldMyself t1=new TestYieldMyself("线程1");
		TestYieldMyself t2=new TestYieldMyself("线程2");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		
	}
	
}
