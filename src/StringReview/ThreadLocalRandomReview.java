package StringReview;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomReview {

	
	public static void main(String[] args) {
		
		//随机数，产生0.0-1.0，但不包括1.0
		System.out.println(Math.random());
		
		Random random = new Random();
		//在0（包括）和指定值（不包括）之间均匀分布的int值，r.nextInt(10)得到0-9
		for(int i=0;i<20;i++) {
			System.out.println(random.nextInt(10));
		}
		
		System.out.println("------------------");
		ThreadLocalRandom current = ThreadLocalRandom.current();
		//返回10到20之间的随机数
		System.out.println(current.nextInt(10,20));
		System.out.println(current.nextInt(19));
		
		
	}
	
}
