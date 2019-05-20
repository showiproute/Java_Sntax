package Java_IO;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class CallbackDigest  implements Runnable{
	
	private String fileName;
	
	public CallbackDigest(String fileName) {
		this.fileName=fileName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream in = new FileInputStream(fileName);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read()!=-1);
			din.close();
			byte[] digest = sha.digest();
			CallbackDigestUserInterface.receiveDigest(digest,fileName);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
