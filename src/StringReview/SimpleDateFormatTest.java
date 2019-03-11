package StringReview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日期时间格式化
public class SimpleDateFormatTest {

	//这些可以多个类共用，且不需要修改
	public static final SimpleDateFormat DF=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat DF2=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	
	public static void main(String[] args) throws ParseException {
		//创建Calendar对象
		Calendar calendar = Calendar.getInstance();
		//重新设置日历
		calendar.set(2016, 00,02,03,04,05);
		
		//Date转String
		//format方法，格式化Date对象为String类型，根据格式化模板进行格式化
		System.out.println(DF2.format(calendar.getTime()));
		//创建个字符串里面是日期格式
		String str="2016年01月02日 03时04分05秒";
		//parse方法，格式化日期字符串为Date对象，根据格式化模板进行格式化
		//你的字符串，要与模板相同，否则格式化抛异常
		Date date=DF2.parse(str);
		System.out.println(DF2.format(date));
		
	}
	
			
			
}
