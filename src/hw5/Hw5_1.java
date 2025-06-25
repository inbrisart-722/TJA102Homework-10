package hw5;

import java.util.Scanner;
import java.lang.Math;

// 第1頁的題目
public class Hw5_1 {
	// 第1頁第1題 refactor method for printing starSquare
	public static void starSquare(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println(); // 最後一圈也印，但算了啦 XD
		}
	}

	// 第1頁第2題 refactor method
	public static void randAvg() {
		// 要裝亂數的陣列
		int[] randomNums = new int[10];
		System.out.println("本次亂數結果：");
		
		// 要計算總和的變數
		int sum = 0;
		for (int i = 0; i < randomNums.length; i++) {
			// 可以直接給值，但這樣感覺比較清晰？
			int temp = (int)Math.floor(Math.random() * 101);
			randomNums[i] = temp;
			sum += randomNums[i];
			System.out.print(randomNums[i] + " "); // 最後一個空格不管 XD
		}
		System.out.println();
		System.out.println(sum / 10); // 其實要除以 randomNums.length
	}

	public static void main(String[] args) {
		// 第1頁第1題
		// 建立 scanner instance
		Scanner sc = new Scanner(System.in);
		// 用戶輸入提示
		System.out.println("請輸入長方形的寬與高：");
		// 儲存 寬與高 的變數先建立好
		int[] rectangle = new int[2]; // width + height

		int counter = 0;
		while (counter < 2) { // 其實應該寫 rectangle.length
			// 有下個 int
			if (sc.hasNextInt()) {
				int temp = sc.nextInt();
				// 如果整數 > 0
				if (temp > 0) {
					System.out.println("✅ 收到你的第一個正整數: " + temp);
					rectangle[counter] = temp;
					counter++;
					// 如果整數 <= 0
				} else {
					System.out.println("❌ 雖然是整數，但不得 <= 0！");
					continue; // 下一圈！（其實不用寫）
				}
				// 完全不是 int
			} else {
				sc.next(); // 丟掉它！
				System.out.println("❌ 請輸入整數！"); // 錯誤提示
				continue; // 下一圈！（其實不用寫）
			}
		}
		sc.close();

		// 寫這樣清楚一點點，就拆一下吧！
		int width = rectangle[0];
		int height = rectangle[1];
		// 呼叫方法 印出結果！
		starSquare(width, height);

		////////////////////////////////////////////
		////////////////////////////////////////////
		////////////////////////////////////////////
		
		//第1頁第2題
		randAvg();
	}

}
