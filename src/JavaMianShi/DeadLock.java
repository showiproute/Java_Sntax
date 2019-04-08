package JavaMianShi;

public class DeadLock {

	public static class deadLock implements Runnable{
		public int flag=1;
		
		private static Object o1=new Object();
		private static Object o2=new Object();
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("flag="+flag);
			if(flag==1) {
				synchronized (o1) {
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					synchronized (o2) {
						System.out.println("1");
					}
				}
			}
			if(flag==0) {
				synchronized (o2) {
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}
	public static void main(String[] args) {
		
		deadLock td1 = new deadLock();
		deadLock td2=new deadLock();
		td1.flag=1;
		td2.flag=0;
		
		new Thread(td1).start();
		new Thread(td2).start();
		
	}
}
