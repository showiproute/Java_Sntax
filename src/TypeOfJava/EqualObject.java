package TypeOfJava;

public class EqualObject {
	public static class Student{
		String name;
		int age;
		public Student(String name,int age) {
			// TODO Auto-generated constructor stub
			this.name=name;
			this.age=age;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			//判断obj是否和this相等，保证自反性
			if(this==obj) {
				return true;
			}		
			//判断obj是否为null，保证最后一条准则
			if(obj==null) {
				return false;
			}		
			//判断两个对象的实际类型是否相等，
			//如果不相等，则说明比较的是两个不同种类的对象，应当返回false
			if(obj.getClass()!=this.getClass()) {
				return false;
			}
			//强制类型转换
			//由于之前已经使用getclass判断过实际类型，因此这里强转是安全的
			Student stu=(Student) obj;
			
			//判断每个属性是否相等
			//对于基本类型的属性用"=="比较，对象类型的属性用equals比较
			if(this.age==stu.age && this.name.equals(stu.name)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		String str="aaaa";
		Student s1 = new Student("xiaoming", 20);
		Student s2= new Student("xiaoming", 20);
		System.out.println("s1.equals(str)="+s1.equals(str));
		System.out.println("s1.equals(s2)="+s1.equals(s2));
	}
}
