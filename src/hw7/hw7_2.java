package hw7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class hw7_2 {
	public static void main(String[] args) throws IOException{
		File destFile = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/Data.txt");
		
		FileOutputStream fos = new FileOutputStream(destFile, false);
		PrintStream ps = new PrintStream(fos);
		
		for(int i = 0 ; i < 10 ; i++) {
			int ran = (int)(Math.random() * 1000) + 1;
			ps.println(ran);
		}
		
		ps.close();
		fos.close();
	}
}
