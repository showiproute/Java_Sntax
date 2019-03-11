package StringReview;

import java.util.Arrays;

public class StringFunctions {

	/*
	 * 字符串方法应用
	 */
	
	public static void main(String[] args) {
		
		char[] ch= {'a','b','c'	};
		//用char数组当参数创建字符串
		String str=new String(ch);
		System.out.println(str.toString());
		
		String str1="12345678";
		//序列的第一个char值位于索引0出，第二个位于索引1出
		System.out.println(str1.charAt(0));
		//charAt里面的index不能超过字符串长度-1，否则抛出异常
//		System.out.println(str1.charAt(20));
		
		//通过ascii来比较字符串
		String str2="aaaa";
		String str3="Baaa";
		System.out.println(str2.compareTo(str3));
		
		//字符串连接，谁调用谁在前
		String str4=str1.concat(str2);
		System.out.println(str4);
	
		System.out.println(str1.startsWith("123"));
		System.out.println(str1.endsWith("789"));
		
		//如果找到就返回其索引值，如果没找到，则返回-1
		//返回指定子字符串在此字符串中第一次出现的索引
		System.out.println(str1.indexOf("4"));
		System.out.println(str.indexOf("9"));
		
		String path="E:\\Java\\JDK6.zip";
		if(path.indexOf(".")==1) {
			System.out.println("path 不是文件路径名");
		}else {
			System.out.println("path 是文件路径名");
		}
		
		//lastIndexOf()返回指定字符在此字符串中最后一次出现处的索引
		//字符串有计算长度方法
		System.out.println(str1.length());
	
		//该子字符串从指定索引处(下标)的字符开始，直到此字符串末尾
		String str10="123456789";
		System.out.println(str10.substring(4));
		//该子字符串从指定的beginIndex处开始，直到索引endIndex-1处的字符结束
		//因此，该子字符串的长度为endIndex-beginIndex;
		System.out.println(str10.substring(4, 8));
		
		
		//截取这个文件的文件格式
		int index = path.lastIndexOf(".");
		System.out.println(path.substring(index+1));
		
		//两种结果都一样，下面属于简写
		System.out.println(path.substring(path.lastIndexOf(".")+1, path.length()));
	
		
		String s1="aaa:bbb:ccc";
		//将字符串，按照":"进行分割，产生三个字符串，生成一个数组，数组长度为3
		String[] arr = s1.split(":");
		System.out.println("arr.length:"+arr.length);
		System.out.println(Arrays.toString(arr));
		
		String[] arr1=s1.split("M");
		System.out.println(arr1.length);
		System.out.println(Arrays.toString(arr1));
		
		//将s1字符串中所有的":"替换成"M"
		String s3=s1.replace(":", "M");
		System.out.println(s3);
		
		char[] chArr=s1.toCharArray();
		System.out.println("chArr.length:"+chArr.length);
		System.out.println(Arrays.toString(chArr));
		String s4="   aaa   bbb   ";
		
		//将字符串中前面的和后面的空格都干掉
		System.out.println(s4.trim());
		
		//new创建，append链接
		StringBuilder sb = new StringBuilder();
		sb.append("aaa").append(123).append("bbb");
		System.out.println(sb.toString());
		
		//new创建,append链接
		StringBuffer sb2= new StringBuffer();
		sb2.append("mmm").append(123);
		System.out.println(sb2.toString());
	}
	
}
