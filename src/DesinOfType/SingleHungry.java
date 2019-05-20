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

	private static final SingleHungry INSTANCE=new SingleHungry();
	
	private  SingleHungry() {}
	
	public static SingleHungry getSingleHungry() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		SingleHungry s1 = SingleHungry.getSingleHungry();
		SingleHungry s2 = SingleHungry.getSingleHungry();
		System.out.println(s1==s2);
	}
	
}
