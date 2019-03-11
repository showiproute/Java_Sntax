package InterfaceReview;

public class jieouhe {

	public static class RedBulb implements Bulb{
		public void shine() {
			System.out.println("Shine in red");
		}
	}
	
	public static class YellowBulb implements Bulb{
		public void shine() {
			System.out.println("Shine in yellow");
		}
	}
	
	public static class GreenBulb implements Bulb{
		public void shine() {
			System.out.println("Shine in green");
		}
	}
	
	public static class Lamp{
		private Bulb bulb;
		public void setBulb(Bulb bulb) {
			this.bulb=bulb;
		}
		
		public void on() {
			bulb.shine();
		}
		
	}
	
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		RedBulb rb = new RedBulb();
		lamp.setBulb(rb);
		lamp.on();
		
		GreenBulb gb = new GreenBulb();
		lamp.setBulb(gb);
		lamp.on();
	}
	
	
}
