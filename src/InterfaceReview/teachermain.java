package InterfaceReview;

public class teachermain {

	public static teach choose(String str) {
		
		if("english".equals(str)) {
		return new EnglishTeacher();
		}else {
			return new ChineseTeacher();
		}
	}
	
	public static void main(String[] args) {
		
		String string="english";
		teach result = choose(string);
		result.teaching();
		
	}
	
}
