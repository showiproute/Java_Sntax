package InterfaceReview;

public class Teacher extends Person{

	@Override
	public void wear() {
		// TODO Auto-generated method stub
		System.out.println("Teacher wear");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Teacher eat");
	}
	
	public static void main(String[] args) {
		
		Person teacher = new Teacher();
		teacher.wear();
		teacher.eat();
		
	}
}
