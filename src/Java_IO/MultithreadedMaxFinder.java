package Java_IO;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultithreadedMaxFinder {

	public static int max(int[] data) throws InterruptedException,ExecutionException{
		
		if(data.length==1) {
			return data[0];
		}else if(data.length==0) {
			throw new IllegalArgumentException();
		}
		
		//将任务分解为两个部分
		FindMaxTask task1=new FindMaxTask(data, 0, data.length/2);
		FindMaxTask	task2=new FindMaxTask(data, data.length/2, data.length);
		
		//创建2个线程
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1= service.submit(task1);
		Future<Integer> future2= service.submit(task2);
		
		return Math.max(future1.get(), future2.get());
	}
	
	public static void main(String[] args) throws Exception{
		MultithreadedMaxFinder mtm = new MultithreadedMaxFinder();
		
		int[] data= {4,5,6,7,111222,3333333};
		int result=mtm.max(data);
		System.out.println(result);
		
		
	}
	
	
}