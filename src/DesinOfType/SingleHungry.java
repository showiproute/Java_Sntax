package DesinOfType;


/*
 * 单例模式之 饿汉式
 * 全局的单例实例在类装载时创建
 * 什么是类装载时:
 * 1)生成该对象的时候，会加载该类及该类的所有父类
 * 2)访问该类的静态成员的时候
 * 3)class.forName("类名")(反射);
 */

public class SingleHungry {

	//直接创建对象给类成员
	private static final SingleHungry INSTANCE=new SingleHungry();
	
	//构造器私有
	private SingleHungry() {}
	
	public static SingleHungry getInstace() {
		return INSTANCE;
	}
	
	
	public static void main(String[] args) {
		SingleHungry s4 = SingleHungry.getInstace();
		SingleHungry s5 = SingleHungry.getInstace();
		
		System.out.println(s4==s5);
		System.out.println(s4.equals(s5));
		
	}
}
