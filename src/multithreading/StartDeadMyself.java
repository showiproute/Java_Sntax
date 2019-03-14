package multithreading;

public class StartDeadMyself{
	
	public static void main(String[] args) {
		Runnable run1=new Runnable() {
			private int i;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(;i<1000;i++) {
					if(i==50) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(System.currentTimeMillis()+"i="+i+
							Thread.currentThread().getName()+"is alive?"+Thread.currentThread().isAlive());
				}
			}
		};
		
		Thread thread = new Thread(run1,"线程1");
		thread.start();
		
	}
	
}
