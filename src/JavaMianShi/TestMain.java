package JavaMianShi;


public class TestMain {
	
	public static class Student{
		private String name;
		private int age;
		public Student(String name,int age) {
			// TODO Auto-generated constructor stub
			this.name=name;
			this.age=age;
		}
	}
	
	public static void main(String[] args) {
//		Student stu = new Student("aa", 11);
//		Class<? extends Student> stuclass = stu.getClass();
//		System.out.println(stuclass.getName());
//		
//		Class stuClass2=Student.class;
//		System.out.println(stuclass==stuClass2);
//	
//		try {
//			Class stuClass3=Class.forName("JavaMianShi.TestMain$Student");
//			System.out.println(stuClass3==stuClass2);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		String s1="Abc";
		String s2 = new String("Abc");
		String s3="Abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1==s3);
		StringBuilder sb=new StringBuilder("111");
		StringBuilder sb2=new StringBuilder("111");
		System.out.println(sb.equals(sb2));
	}
	
}



