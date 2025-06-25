package hw5;

// 皮一下
import static java.lang.Math.*;

// 第4頁的題目
public class Hw5_4 {
	private static String getAuthCode() {
		// 48~57 0~9
		// 65~90 A~Z
		// 97~122 a~z
		int[] authCode = new int[8];
		
		int counter = 0;
		while(counter < 8) {
			// 等同於寫 Math.floor( Math.random() )...
			int randomInt = (int) floor(random() * 75) + 48; // 48 ~ 122
			// 無效數字就跳過這圈！
			if( (randomInt >= 58 && randomInt <= 64) ||
				(randomInt >= 91 && randomInt <= 96) 
			  ) {
				continue;
			  }
			// 有效數字就來處理！
			authCode[counter] = randomInt;
			counter++;
		}
		
		// 好了 我現在有長度 8 放滿 int 的陣列 來把它變成 指定字串！
		String result = "";
		
		// for-each loop
		for(int num : authCode) {
			result += (char)num;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("本次隨機產生驗證碼為：");
		System.out.println( getAuthCode() );
	}	
}
