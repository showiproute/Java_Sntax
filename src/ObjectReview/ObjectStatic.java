package ObjectReview;

public class ObjectStatic {

//	String name="PERSON";
//	public int age=10;
//	public static final int EYE_NUM=10;
//	
//	public ObjectStatic() {
//		this.age=20;
//		this.name="saasd";
//	}
//
//	
//	
//	
//	public void talk() {
//		System.out.println("talk");
//	}
//	
//	public static void main(String[] args) {
////		ObjectStatic objectStatic = new ObjectStatic();
////		objectStatic.talk();
////		System.out.println(objectStatic.name+objectStatic.age);
////		System.out.println(ObjectStatic.EYE_NUM);
////		System.out.println(new ObjectStatic().age+""+new ObjectStatic().EYE_NUM);
//	
//	}
	
	int a;
	int b=100;
	int c=3;
	String name="";
	String name2="";
	String name3="";
	public ObjectStatic() {
		this.c=100;
		this.name="name1";
		this.name3="name3";
	}
	
	public ObjectStatic(int c,String name) {
		this();
		this.c=233;
		this.name=name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.c+""+this.name+this.name2+this.name3;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new ObjectStatic(22,"hello").toString());
		
	}
}
