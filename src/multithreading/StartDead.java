package multithreading;

public class StartDead implements Runnable{
	private int i;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;i<=100;i++) {
			if(i==20) {
				try {
					//睡眠5秒
					Thread.sleep(5000);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()
					+" "+i+"alive is:"+Thread.currentThread().isAlive());
		}
	}
	
	public static void main(String[] args) {
		StartDead startDead = new StartDead();
		Thread thread = new Thread(startDead,"线程1");
		thread.start();
	}
	

}
