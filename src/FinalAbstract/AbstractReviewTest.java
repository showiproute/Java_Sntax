package FinalAbstract;


public class AbstractReviewTest {

	public static abstract class Shape{
		//声明抽象方法，获取图形面积
		abstract double getArea();
		
		//声明抽象方法，获取图形周长
		abstract double getPerimeter();
	}
	
	public static class Rectangular extends Shape{

		private double length;
		
		private double width;
		
	    public Rectangular(double length,double width) {
			// TODO Auto-generated constructor stub
			this.length=length;
			this.width=width;
		}
		
		@Override
		double getArea() {
			// TODO Auto-generated method stub
			return this.length*this.width;
		}

		@Override
		double getPerimeter() {
			// TODO Auto-generated method stub
			return (this.length+this.width)*2;
		}	
	}
	
	public static class Circular extends Shape{
		private double r;
		
		public Circular(double r) {
			this.r=r;
		}

		@Override
		double getArea() {
			// TODO Auto-generated method stub
			return Math.PI*r*r;
		}

		@Override
		double getPerimeter() {
			// TODO Auto-generated method stub
			return 2*Math.PI*r;
		}
	}
	
	public static void main(String[] args) {
		//创建矩形对象赋值给shape引用变量----多态
		 Shape s1 = new Rectangular(10.0, 5.0);
		 System.out.println("矩形周长="+s1.getPerimeter());
		 System.out.println("矩形面积="+s1.getArea());
	
		 //创建圆形对象赋值给shape引用变量----多态
		 Circular s2= new Circular(10.0);
		 System.out.println("圆形周长="+s2.getPerimeter());
		 System.out.println("圆形面积="+s2.getArea());
	}
	
}
