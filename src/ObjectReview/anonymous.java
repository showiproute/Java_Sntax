package ObjectReview;

public class anonymous {

	
	public static class Car{
		static String name;
		String color;
		int num;
		
		public void fun() {
			System.out.println("name:"+name);
			System.out.println("color:"+color);
			System.out.println("num:"+num);
		}
		
		
		public void fun1(Car car) {
			car.name="ggg";
			car.color="rr";
			car.num=6;
			System.out.println("name:"+this.name+"color"+this.color+"num"+this.num);
		}
		
	}
	

	
	public static void main(String[] args) {
//		Car.name="sss";
//		new Car().fun();
//		Car c=new Car();
//		c.fun();
		
		new Car().fun1(new Car());
		
	}
	
}
