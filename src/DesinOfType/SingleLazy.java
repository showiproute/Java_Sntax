package DesinOfType;


/*
 * 懒汉式单例模式
 * 全局的单例实例在第一次被使用时构建
 */

public class SingleLazy {
	
	private static SingleLazy instance;
	
	private SingleLazy() {}
	
	public static SingleLazy getInstance() {
		if(instance==null) {
			instance = new SingleLazy();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingleLazy s1 = SingleLazy.getInstance();
		SingleLazy s2 = SingleLazy.getInstance();
		System.out.println(s1==s2);
		
		SingleLazy s3 = new SingleLazy();
		System.out.println(s3.equals(s2));
		
	}
	
}
