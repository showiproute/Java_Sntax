package DesinOfType;


/*
 * 懒汉式单例模式
 * 全局的单例实例在第一次被使用时构建
 */

public class SingleLazy {
	//私用静态类成员变量
	private static SingleLazy instance;
	//私有构造器，外部类不能new对象
	private SingleLazy() {}
	
	//用static修饰的原因是，构造器私有，不能new实例，只能通过类名.的方式调用
	public static SingleLazy getInstace() {
		if(instance==null) {
			instance=new SingleLazy();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingleLazy s1= SingleLazy.getInstace();
		SingleLazy s2 = SingleLazy.getInstace();
		System.out.println(s1==s2);
		
		//因为构造器是私有的，外部类不能通过new对象的方式创建
//		SingleHungry s3 = new SingleHungry();
//		System.out.println(s3.equals(s2));

		
		
	}
	
}
