package Java_IO;

import javax.xml.bind.DatatypeConverter;

public class CallbackDigestUserInterface {

	public static void receiveDigest(byte[] digest,String name) {
		StringBuffer result = new StringBuffer(name);
		result.append(":");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		for(String filename:args) {
			//计算摘要
			CallbackDigest cb = new CallbackDigest(filename);
			Thread t = new Thread(cb);
			t.start();
		}
		
	}
}
