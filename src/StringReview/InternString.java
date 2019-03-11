package StringReview;

public class InternString {

	public static void main(String[] args) {
		
		//在常量池里创建"aaa"
		String str1="aaa";
		
		//常量池里的"aaa"已经存在，不需要创建
		String str2="aaa";
		
		//str1与str2是同一地址
		System.out.println(str1==str2);
		
		//在常量池里创建"aaabbb"
		String str3="aaabbb";
		//"aaa"+"bbb"="aaabbb",拿aaabbb去常量池里找有没有匹配的
		String str4="aaa"+"bbb";
		System.out.println(str3==str4);
		
		//变量只有在运行时才能确定
		String str5=str1+"bbb";
		System.out.println(str3==str5);
		//下面共创建了3个对象，常量池"aaa"和两个new对象
		String str6=new String("aaa");
		String str7=new String("aaa");
		
		System.out.println(str6==str7);
		
		System.out.println("str1==str6:"+(str1==str6));
		//去常量池里找的有没有一样的字符串，如果有返回常量池的字符串，如果没有，在常量池里新建字符串再返回
		//str6.intern()在常量池找到了匹配的字符串，然后就返回该常量池字符串
		str6=str6.intern();
		System.out.println("str1==str6:"+(str1==str6));
		
		
	}
	
}
