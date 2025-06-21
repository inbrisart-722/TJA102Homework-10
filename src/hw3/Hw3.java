package hw3;

import java.util.Scanner;
import java.util.Arrays;

public class Hw3 {
	public static void main(String[] args) {
		////////////////////////////////// 1 （直接寫成進階了）

		// 1-1. system hint
//		System.out.println("請輸入三個整數：");
//
//		// 1-2. variable declaration
//		Scanner sc = new Scanner(System.in);
//		int[] arr = new int[3];
//
//		// 1-3. user input
//		for (int i = 0; i < arr.length; i++) {
//			if (sc.hasNextInt())
//				arr[i] = sc.nextInt();
//		}
//		
//		// 1-4. result
//		System.out.println(getTriangleType(arr[0], arr[1], arr[2]));

		////////////////////////////////// 2 （userGuess要先初始化)（直接寫成進階了）

//		// 2-1. system hint
//		System.out.println("開始猜數字吧！");
//		guessNumber();
//		guessNumberAdvanced();

		////////////////////////////////// 3

		// 3-1. 阿文
		System.out.println("阿文...請輸入你討厭哪個數字？");
		awenLottery();
		
	}

	public static String getTriangleType(int... sideArr) {
		int s0 = sideArr[0];
		int s1 = sideArr[1];
		int s2 = sideArr[2];
		String type = "";
		if (s0 + s1 > s2 && s1 + s2 > s0 && s2 + s0 > s1) {
			if (s0 == s1 || s1 == s2 || s2 == s0) {
				type = "等腰三角形";
				if (s0 == s1 && s1 == s2)
					type = "正三角形";
			} else if (Math.pow(s0, 2) + Math.pow(s1, 2) == Math.pow(s2, 2)
					|| Math.pow(s0, 2) + Math.pow(s2, 2) == Math.pow(s1, 2)
					|| Math.pow(s1, 2) + Math.pow(s2, 2) == Math.pow(s0, 2)) {
				type = "直角三角形";
			} else
				type = "其他三角形";
		} else
			type = "不是三角形";
		return type;
	}

	public static void guessNumber() {
		// 2-2. variable declartion
		Scanner sc2 = new Scanner(System.in);
		int answer = (int) (Math.random() * 10);
		int userGuess = -1; // 如果在使用前只有宣告但沒賦值（if條件不算）就會報錯

		// 2-3. user input & infinite loop
		if (sc2.hasNextInt())
			userGuess = sc2.nextInt();
		while (userGuess != answer) {
			System.out.println("猜錯囉");
			userGuess = sc2.nextInt();
		}

		// 2-4. base condition == true;
		System.out.println("答對了！答案就是" + answer);
	}

	public static void guessNumberAdvanced() {
		// 2-2. variable declartion
		Scanner sc2 = new Scanner(System.in);
		int answer = (int) (Math.random() * 10);
		int userGuess = -1; // 如果在使用前只有宣告但沒賦值（if條件不算）就會報錯

		// 2-3.
		answer = (int) (Math.random() * 101);
		if (sc2.hasNextInt())
			userGuess = sc2.nextInt();
		while (userGuess != answer) {
			if (userGuess > answer)
				System.out.print("再小一些！\n");
			if (userGuess < answer)
				System.out.print("再大一些！\n");
			userGuess = sc2.nextInt();
		}

		System.out.println("答對了！答案就是" + answer);
	}

	public static void awenLottery() {
		int userHate = -1;

		Scanner sc3 = new Scanner(System.in);
		if (sc3.hasNextInt())
			userHate = sc3.nextInt();

		int counter = 0;
		int[] arr = new int[49]; // 用現有教的方法來找方法看看 （沒有的話再去查 other array methods）
		
		for (int i = 1; i <= 49; i++) {
			if (i % 10 == userHate || (i / 10) == userHate)
				continue;
			System.out.print(i + "\t");
			arr[counter] = i; // 不會被篩掉的字就更新該位置上 arr 的值為該字
			counter++;
			if (counter % 6 == 0) System.out.println();
		}
		System.out.println("總共有" + counter + "數字可選");
		awenLotteryAdvanced(arr, counter);
	}
	
	public static void awenLotteryAdvanced(int[] arr, int counter) { // 用現有方法感覺好笨....
		int count = 0;
		int[] arrResult = new int[6];
		while(count <= 5) {
			int num = (int)(Math.random() * counter);
			Arrays.sort(arrResult, 0, count);
			if( Arrays.binarySearch(arrResult, 0, count, arr[num]) < 0) { // 要記得 import..
				arrResult[count] = arr[num];
				count++;
			}
		}
		System.out.println("下面這六組字給你參考啦：");
		for(int i = 0; i <= 5; i++) {
			System.out.print(arrResult[i] + " ");
		}
	}
}
