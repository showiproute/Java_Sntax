package JavaMianShi;

public class ThreadYield {
	public static class TestYield extends Thread{
		public TestYield(String name) {
			// TODO Auto-generated constructor stub
			super(name);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10;i++) {
				System.out.println(getName()+" "+i);
				if(i==3) {
					Thread.yield();
				}
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		TestYield t1=new TestYield("低级");
		TestYield t2=new TestYield("高级");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
	}
	
	
	
}
