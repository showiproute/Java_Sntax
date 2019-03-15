package multithreading;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolReview {

	public static class ThreadPoolTest implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				Thread.sleep(300);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
		RejectedExecutionHandler handler=new ThreadPoolExecutor.DiscardPolicy();
		ThreadPoolExecutor threadPool= new ThreadPoolExecutor(5, 10, 60, 
				TimeUnit.SECONDS, queue,handler);
	
		
		for(int i=0;i<16;i++) {
			threadPool.execute(
					new Thread(new ThreadPoolTest(),"Thread".concat(i+"")));
			System.out.println("线程池中活跃的线程数:"+threadPool.getPoolSize());
			if(queue.size()>0) {
				System.out.println("---------------队列中阻塞的线程数："+queue.size());
			}
			
		}
		threadPool.shutdown();
		
	}
	
}
