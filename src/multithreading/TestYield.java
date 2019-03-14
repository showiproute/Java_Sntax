package multithreading;

public class TestYield extends Thread{

	public TestYield(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==3) {
				//线程让步
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		TestYield t1=new TestYield("低级");
		TestYield t2=new TestYield("高级");
		//设置成低优先级
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		//设置成高优先级
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
	}
	
	
}
