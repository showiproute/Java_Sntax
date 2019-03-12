package ExceptionReview;

public class TryCatchException {

	//声明一个方法，如果这个方法内抛出了数组越界的异常，则自己不处理，向上抛出
	//如果方法内有try catch块的话，优先处理try catch块
	
	private static void ma() throws IndexOutOfBoundsException{
		int[] arr=new int[] {1,2,3};
		System.out.println(arr[4]);
	}
	
	private static void mb() throws ClassCastException{
		Object obj = new String("a");
		Integer n=(Integer)(obj);
	}
	
	private static void mc() throws NumberFormatException{
		int m=Integer.valueOf("a");
	}
	
	
	public static void main(String[] args) {
		//try里面的某个步骤抛出异常了，抛出异常下面的所有代码都不执行
		//如果抛出的异常catch块能匹配上，则进入相应的catch块逻辑
		try {
			System.out.println("111");
			mc();
			ma();
			mb();
			return;
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数组越界");
		}catch (ClassCastException e2) {
			// TODO: handle exception
			e2.printStackTrace();
			System.out.println("强制类型转换报错");
		}catch (Exception e3) {
			// TODO: handle exception
			e3.printStackTrace();
			
			System.out.println("其他异常");
		}finally {
			System.out.println("回收");
		}
	}
	
	
	
}
