package ObjectReview;

public class ObjectAnnotationEffect {

	
	public static class Animal{
		
		private int age;
		private int sex;
		
		public Animal() {
			
		}
		
		public Animal(int sex,int age) {
			this.sex=sex;
			this.age=age;
		}
		
		public void eat() {
			System.out.println("do animal eat()");
			
		}
		
		public void printInfo() {
			System.out.println("Sex:"+this.sex+"age"+this.age);
		}
		
	}
	
	public static class Cat extends Animal{
		public Cat() {
			
		}
		
		public Cat(int sex,int age) {
			super(sex,age);
		}
		
		public void catchMouse() {
			System.out.println("do Cat catchMouse");
		}
		
		@Override
		public void eat() {
			System.out.println("cat eat fish");
		}
		
	}
	
	public static class Breader{
		public void feed(Animal animal) {
			animal.eat();
		}
	}
	
	
	public static void main(String[] args) {
		
		new Breader().feed(new Cat());
		
	}
}
