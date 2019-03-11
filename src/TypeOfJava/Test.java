package TypeOfJava;

public class Test {

	public static void main(String[] args) {
		
		int n=100;
		//int 转Integer
		Integer nIn = new Integer(n);
		System.out.println(nIn);
		
		//Integer转int,Integer引用.intValue();
		int m = nIn.intValue();
		System.out.println(m);

		//int转字符串，用String.valueOf()
		String str = String.valueOf(m);
		System.out.println(str);
		
		//String转int，包装类Integer.parseInt()
		int k = Integer.parseInt(str);
		System.out.println(k);
		
		//String转long，包装类Long.parseLong()
		String ss="123123";
		long ls = Long.parseLong(ss);
		System.out.println(ls);
		
		//String转包装类，new 包装类()
		Integer in = new Integer(ss);
	
		//包装类转String，包装类引用.toString()
		String str1 = in.toString();
		System.out.println(str1);
		
		Integer integer = new Integer(200);
		int mmm=integer;
		int ooo=integer.intValue();
		System.out.println(mmm+""+ooo);
	}
	
}
