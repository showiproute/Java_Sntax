package Java_IO;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class ThreadTest {

	
	public static class DigestThread extends Thread{
		private String fileName;
		private byte[] digest;
		
		public DigestThread(String fileName) {
			this.fileName=fileName;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				FileInputStream  in = new FileInputStream(fileName);
				MessageDigest sha = MessageDigest.getInstance("SHA-256");
				DigestInputStream din = new DigestInputStream(in, sha);
				while(din.read()!=-1);
				din.close();
				digest=sha.digest();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		public byte[] getDigest() {
			return digest;
		}
		
	}
	
	
	public static void main(String[] args) {
		
//		DigestThread t = new DigestThread("C:\\Users\\liangyintian\\Desktop\\data.txt");
//		t.start();
//		
//		StringBuilder result=new StringBuilder("C:\\Users\\liangyintian\\Desktop\\data.txt");
//		result.append(":");
//		byte[] digest=t.getDigest();
//		if(digest!=null) {
//			result.append(DatatypeConverter.printHexBinary(digest));
//		}
//		System.out.println(result);

			
		DigestThread[] digests = new DigestThread[args.length];
		
		for(int i=0;i<args.length;i++) {
			//计算摘要
			digests[i]=new DigestThread(args[i]);
			digests[i].start();
			
		}
		
//		for(int i=0;i<args.length;i++) {
//			//现在显示结果
//			StringBuffer result=new StringBuffer(args[i]);
//			result.append(":");
//			byte[] digest=digests[i].getDigest(); 
//			result.append(DatatypeConverter.printHexBinary(digest));
//			System.out.println(result);
//		}

		for(int i=0;i<args.length;i++) {
			while(true) {
				byte[] digest=digests[i].getDigest();
				if (digest!=null) {
					StringBuffer result = new StringBuffer(args[i]);
					result.append(":");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
		
	}
	
}
