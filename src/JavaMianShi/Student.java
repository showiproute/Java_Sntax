package JavaMianShi;

import java.awt.print.Printable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Student {
	public String name;
	protected int age;
	char sex;
	private String phoneNum;
	
	Student(String str){
		System.out.println("default constructor"+str);
	}
	
	public Student() {
		System.out.println("调用了公有、无参构造方法执行了");
	}

	public Student(char name) {
		System.out.println("姓名:"+name);
	}
	
	public Student(String name,int age) {
		System.out.println("姓名"+name+"年龄"+age);
	}
	
	protected Student (boolean n) {
		System.out.println("受保护的构造方法n="+n);
	}
	
	private Student(int age) {
		System.out.println("私有的构造方法:"+age);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:"+name+"age"+age+"sex"+sex+"phoneNum"+phoneNum;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Class stuClass = Class.forName("JavaMianShi.Student");
		
		System.out.println("*****获取所有公有的字段******");
		Field[] fieldArray = stuClass.getFields();
		for (Field f : fieldArray) {
			System.out.println(f);
		}
		
		System.out.println("*******获取所有的字段（包括私有、受保护、默认的)*********");
		fieldArray = stuClass.getDeclaredFields();
		for (Field f : fieldArray) {
			System.out.println(f);
		}
		
		System.out.println("***********获取共有字段并调用*************");
		Field f = stuClass.getField("name");
		System.out.println(f);
		
		//产生Student对象->Student stu=new Student();
		Object obj=stuClass.getConstructor().newInstance();
		//为字段设置值
		f.set(obj, "liedehua"); //为Student对象中的name属性赋值，stu.name=liudehua
		
		Student stu=(Student)obj;
		System.out.println("验证姓名:"+stu.name);
		
		System.out.println("***********获取私有字段********并调用*******");
		f=stuClass.getDeclaredField("phoneNum");
		System.out.println(f);
		f.setAccessible(true);
		f.set(obj, "188899999999");
		System.out.println("验证电话:"+stu);
	}
	
	
}
