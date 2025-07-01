package hw7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class hw7_2 {
	public static void main(String[] args) throws IOException{
		File destFile = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/Data.txt");
		
		FileOutputStream fos = new FileOutputStream(destFile, true);
		PrintStream ps = new PrintStream(fos);
		
		int[] random = new int[10];
		for(int el : random) {
			int ran = (int)(Math.random() * 1000) + 1;
			el = ran;
			ps.println(el);
		}
		
		ps.close();
		fos.close();
	}
}
