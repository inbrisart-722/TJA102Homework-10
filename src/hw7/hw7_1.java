package hw7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class hw7_1 {
	public static void main(String[] args) throws IOException{
		File sampleFile = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/Sample.txt");
		
		// 有確認編碼都是 utf-8
		FileReader fr = new FileReader(sampleFile);
		BufferedReader bsr = new BufferedReader(fr);
		
		int countChar = 0;
		int countLine = 1;
		
		int temp;
		while( (temp = bsr.read()) != -1 ) {
			countChar += 1;
			if(temp == 10) countLine++;
		}
		
		// 會遺漏 \n \r 可用上方 println temp 檢查 (10, 13)
//		String str;
//		while( (str = bsr.readLine()) != null ) {
//			countChar += str.length();
//			countLine += 1;
//		}
		
		bsr.close();
		fr.close();
		
		// 結果輸出
		System.out.print(sampleFile.getName() + "檔案共有");
		System.out.print(sampleFile.length() + "個位元組，");
		System.out.print(countChar + "個字元，");
		System.out.print(countLine + "列資料");
			
	}
}
