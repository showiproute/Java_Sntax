package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

/*
 * 创建生产苹果线程
 * 每隔300ms，生产一个苹果
 */

public class Producter implements Runnable{
	//队列
	private ArrayBlockingQueue<String> queue;
	//构造方法，给属性队列赋值
	public  Producter(ArrayBlockingQueue<String> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=1;
		String name=Thread.currentThread().getName();
		for(;i<=10;i++) {
			try {
				Thread.sleep(300);
				System.out.println(name+"生产第"+i+"个苹果开始");
				//调用put方法，如果队列满了，则阻塞队列
				queue.put("Apple");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println(name+"生成第"+i+"个苹果结束");
	}
}
