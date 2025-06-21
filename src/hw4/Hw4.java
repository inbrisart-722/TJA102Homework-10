package hw4;

import java.util.Scanner;

public class Hw4 {
	public static void main(String[] args) {
		// 1

//		// 1-1
//		int[] arr1 = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
//		int sum = 0;
//		for(int i = 0; i < arr1.length; i++) {
//			sum += arr1[i];
//		}
//		int avg = sum / arr1.length;// 如果剛好整除又只要求 大於 會沒處理到 等號 的部分
//		System.out.println("avg= " + avg);
//		for(int i = 0; i < arr1.length; i++) {
//			if(arr1[i] >= avg) {
//				 System.out.print(arr1[i] + " "); // 先不處理最後一個空格
//			}
//		}
//		System.out.println();
//		
//		// 1-2
//		String s1 = "Hello World";
//		for(int i = 0 ; i < s1.length(); i++) {
//			System.out.print(s1.charAt(s1.length() - 1 - i));
//		}
//		System.out.println();
//		
//		// 1-3
//		String[] sArr1 = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
//		int count1 = 0;
//		for(int i = 0 ; i < sArr1.length ; i++) {
//			for(int j = 0 ; j < sArr1[i].length(); j ++) {
//				if(sArr1[i].charAt(j) == 'a' ||
//				   sArr1[i].charAt(j) == 'e' ||
//				   sArr1[i].charAt(j) == 'i' ||
//				   sArr1[i].charAt(j) == 'o' ||
//				   sArr1[i].charAt(j) == 'u')
//					count1++;
//			}
//		}
//		System.out.println(count1);

		// 2

//		Scanner sc1 = new Scanner(System.in);
//		int target1 = 0;
//		System.out.println("小華想借多少錢：");
//		if(sc1.hasNextInt()) {
//			target1 = sc1.nextInt();
//		}
//		
//		int[][] employeeMoney = {
//				{25,2500},
//				{32,800},
//				{8,500},
//				{19,1000},
//				{27,1200}
//		};
//		System.out.println("有錢可借的員工編號: ");
//		
//		int count2 = 0;
//		for(int i = 0 ; i < employeeMoney.length; i++) {
//			if(employeeMoney[i][1] >= target1) {
//				System.out.print(employeeMoney[i][0] + " ");
//				count2++;
//			}
//		}
//		System.out.println("共 " + count2 + " 人！");

		// 3

		System.out.println(calculateAccDays());

		// 4

//		int[][] arrExam = {
//				{10,35,40,100,90,85,75,70},
//				{37,75,77,89,64,75,70,95},
//				{100,70,79,90,75,70,79,90},
//				{77,95,70,89,60,75,85,89},
//				{98,70,89,90,75,90,89,90},
//				{90,80,100,75,50,20,99,75}
//		};
//		int[] highestScoreTimes = new int[8];
//		
//		for(int i = 0 ; i < arrExam.length ; i++) {
//			int singleTestHighest = 0;
//			int singleTestHighestPointer = 0;
//			for(int j = 0 ; j < arrExam[i].length ; j++) {
//				if (arrExam[i][j] > singleTestHighest) { // 不處理同分狀況！
//					singleTestHighest = arrExam[i][j];
//					singleTestHighestPointer = j;
//				}
//			}
//			highestScoreTimes[singleTestHighestPointer] += 1;
//		}
//	
//		for(int i = 0 ; i < highestScoreTimes.length ; i++) {
//			System.out.println("第" + (i+1) + "人: " + highestScoreTimes[i]);
//		}
//
//	}
		
	}
	
	// 1st refactor 把日子那題拿出來不然好長
	public static int calculateAccDays() {
		// 月份配對天數
		int[] yearToDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		// 先設定好 Scanner 可以接住訊息 以及 要裝結果的 array
		Scanner sc2 = new Scanner(System.in);
		int[] arrInput1 = new int[3];
		
		// 直到滿了幾個有效輸入才結束 counter 設定
		int counter = 0;
		while (counter < arrInput1.length) {
			System.out.println("請輸入第 " + (counter + 1) + " 個整數");
			
			// 如果是整數的話
			if (sc2.hasNextInt()) {
				int temp = sc2.nextInt();
				// 檢驗月份輸入
				if (counter == 1) {
					if (temp < 1 || temp > 12) {
						System.out.println("月份只能是1~12月哦！");
						continue;
					}
				}
				// 檢驗日期輸入（是否符合該月份應有天數）
				if (counter == 2) {
					if (temp > yearToDays[arrInput1[1] - 1]) {
						System.out.println(arrInput1[1] + "月份不能超過" + (yearToDays[arrInput1[1] - 1]) + "天哦！");
						continue;
					}
				}
				// 符合所有條件的 main block
				arrInput1[counter] = temp;
				System.out.println(arrInput1[counter]);
				counter++;
				if (counter == 1) {
					if (checkLeapYear(arrInput1[0])) {
						yearToDays[1] += 1;
					}
				}
			}
			// 完全不是整數的狀況
			else {
				System.out.println("輸入內容不符規定，請重新輸入");
				sc2.next();
			}
		}

		sc2.close();
		
		// 開始計算 totalDays
		// 1 當月：先直接把日期當初始值
		int totalDays = arrInput1[2];
		// 2 當月以前：之前的月份所有的天數再加上去
		for (int i = 0; i < arrInput1[1] - 1; i++) {
			totalDays += yearToDays[i];
		}
		
		return totalDays;
	}

	// 2nd refactor 
	// 拿來檢查是否為 leap year
	public static boolean checkLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0)
				return false;
			return true;
		}
		return false;
	}
	
}
