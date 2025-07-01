package hw7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class hw7_3 {
	public static void main(String[] args) throws IOException {
		// from file
		File a = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/Sample.txt");
		// to file
		File b = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/SampleCopy.txt");
		
		// callFunc
		try {
			copyFile(a, b);
			System.out.println("copy succeeded");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("copy failed");
		}
	}
	private static void copyFile(File a, File b) throws IOException{
		// from
		FileInputStream fis = new FileInputStream(a);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// to 
		FileOutputStream fos = new FileOutputStream(b);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int len;
		byte[] temp = new byte[8192];
		while( (len = bis.read(temp)) != -1) {
			bos.write(temp, 0, len);
			// no flush because there'd be no use using buffer
		}
		
		bos.close();
		fos.close();
		bis.close();
		fis.close();
	}
}
