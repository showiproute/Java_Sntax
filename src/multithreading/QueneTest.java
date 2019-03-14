package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class QueneTest {

	public static void main(String[] args) {
		
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(2);
		//-------从队列里出-------
		//System.out.println(q.add("111"));
		//remove方法，如果队列为空，抛出异常
//		System.out.println(q.remove());
		//poll方法，如果队列为空，取不到，返回null
//		System.out.println(q.poll());
		
		//take方法，如果队列为空，则阻塞该线程
		try {
			q.take();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//-----往队列里放-------
		System.out.println(q.add("111"));
		System.out.println(q.offer("222"));
		//add方法如果队列满了，抛出异常
//		System.out.println(q.add("333"));
		
		//put方法，方法如果队列满了，就阻塞
		try {
			q.put("333");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//offer方法，如果队列满了，返回false，否则返回true
		System.out.println(q.offer("333"));
	}
	
}
