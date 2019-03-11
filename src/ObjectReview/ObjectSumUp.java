package ObjectReview;

public class ObjectSumUp {

	public static class HardwareInfo{
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "HardwareInfo [brand=" + brand + ", type=" + type + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}

		private String brand;
		private String type;
		     
		public HardwareInfo(String brand,String type) {
			this.brand=brand;
			this.type=type;
		}
	
	}
	
	public static class Keyboard extends HardwareInfo{

		public Keyboard(String brand, String type) {
			super(brand, type);
			// TODO Auto-generated constructor stub
		}
		
		public void printInfo() {
			System.out.println("键盘:"+super.toString());
		}
		
		public void input() {
			printInfo();
			System.out.println("从键盘输入数据");
		}
	}
	
	public static class Screen extends HardwareInfo{

		public Screen(String brand, String type) {
			super(brand, type);
			// TODO Auto-generated constructor stub
		}
		public void printInfo() {
			System.out.println("显示器:"+super.toString());
		}
		
		public void show() {
			printInfo();
			System.out.println("显示输入的数据");
		}
		
	}
	
	public static class Computer{
		private Keyboard keyboard;
		private Screen screen;
		
		public Computer(Keyboard keyboard,Screen screen) {
			this.keyboard=keyboard;
			this.screen=screen;
		}
		
		public void inputAndShow() {
			keyboard.input();
			screen.show();
		}
		
	}
	
	public static void main(String[] args) {
		
		Keyboard keyboard = new Keyboard("luoji", "luoji001");
		Screen screen = new Screen("samsumng", "001");
		Computer computer = new Computer(keyboard, screen);
		computer.inputAndShow();
		
		
	}
}
