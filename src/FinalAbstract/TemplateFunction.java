package FinalAbstract;

public class TemplateFunction {

	//创建形状抽象类，在抽象类内部定义求图形周长和面积的和
	public static abstract class Shape{
		//声明抽象方法，获取图形面积
		abstract double getArea();
		
		//声明抽象方法，获取图像周长
		abstract double getPerimeter();
		
		/*
		 * add()只是定义一个算法的骨架在add（）方法里
		 * 1）计算图形的周长
		 * 2）计算图形的面积
		 * 3）计算周长、面积的和
		 * 
		 * add()只负责定义，具体的求周长、面积由子类来实现
		 */
		public double add() {
			//调用的是子类的实现方法
			double perimeter=this.getPerimeter();
			//调用的是子类的实现方法
			double area=this.getArea();
			return perimeter+area;
		}
		/*
		 * sub()之定义一个算法的骨架在sub()方法里
		 * 1）计算图形的周长
		 * 2）计算图像的面积
		 * 3)计算面积-周长
		 * sub() 只负责定义，具体的求周长、面积由子类来实现
		 */
		public double sub() {
			//调用的是子类的实现方法
			double perimeter = this.getPerimeter();
			//调用的是子类的实现方法
			double area = this.getArea();
			return area-perimeter;
		}
	}
	
	public static class Rectangular extends Shape{
		private double length;

		private double width;
		
		public Rectangular(double length,double width) {
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
		
		//创建矩形对象赋值给shape引用变量-----多态
		Shape s1 = new Rectangular(10, 5);
		System.out.println("矩形周长="+s1.getPerimeter());
		System.out.println("矩形面积="+s1.getArea());
		
		//创建圆形对象赋值给shape引用变量----- 多态
		Shape s2 = new Circular(10);
		System.out.println("圆形周长="+s2.getPerimeter());
		System.out.println("圆形面积="+s2.getArea());
		
		System.out.println("-------------------");
		//计算形状的周长和面积的和
		//如果要算和，需要算周长、面积、再加和，需要3步，如果有n个图形，那需要3n步，重复性太高
		double perimeter = s1.getPerimeter();
		double area = s1.getArea();
		System.out.println(perimeter+area);
		
		System.out.println("-------------------");
		System.out.println("矩形周长+面积="+s1.add());
		System.out.println("矩形面积-周长="+s1.sub());
		System.out.println("圆形周长+面积="+s1.add());
		System.out.println("圆形面积-周长="+s2.sub());
		
		
	}
	
}
