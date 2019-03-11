package CollectionReview;

//自实现泛型类，定义Apple类是使用了泛型声明
public class FanXingObejctReview {

	public static class Apple<T>{
		//使用T类型形参定义示例变量
		private T info;
		//下面方法中使用T类型形参来定义构造器
		public Apple(T info) {
			this.info=info;
		}
		

		public T getInfo() {
			return this.info;
		}
	}
	
	public static void main(String[] args) {
		
		//构造器的参数为String
		Apple<String> a1 = new Apple<String>("苹果");
		System.out.println(a1.getInfo());
		//构造器的参数为Integer
		Apple<Integer> a2=new Apple<Integer>(123);
		System.out.println(a2.getInfo());
		
	}
}
