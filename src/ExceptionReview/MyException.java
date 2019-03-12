package ExceptionReview;

import java.io.IOException;

/*
 * 自我实现异常类，用于封装Exception
 * 
 */
public class MyException extends Exception{

	//错误码
	private String errorCode;
	
	public MyException() {}
	//创建构造方法，参数错误码，错误说明
	public MyException(String errorCode,String message) {
		//调用父类的构造方法给message赋值
		super(message);
		this.errorCode=errorCode;
	}
	
	
	public MyException(Throwable cause) {
		super(cause);
	}
	
	public MyException(String errorCode,Throwable cause) {
		super(cause);
		this.errorCode=errorCode;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode=errorCode;
	}
	
	public static void main(String[] args) {
		MyException e = new MyException("ER001","系统找不到指定的文件");
		System.out.println(e.getErrorCode()+":"+e.getMessage());
		MyException e2 = new MyException();
		e2.setErrorCode("ER002");
		System.out.println(e2.getErrorCode()+":"+e2.getMessage());
		MyException e3 = new MyException("ER002",new IOException("系统找不到指定的文件"));
		System.out.println(e3.getErrorCode()+":"+e3.getMessage());
	}
	
}



