package hw1;

public class hw1_1 {
	public static void main(String[] args) {
		// 1
		System.out.println("============1============");
		System.out.println(12 + 6);
		System.out.println(12 * 6);
		
		// 2
		System.out.println("============2============");
		int eggDozen = 200 / 12;
		int eggSingle = 200 % 12;
		System.out.println(eggDozen + "打" + eggSingle + "顆");
		
		// 3
		System.out.println("============3============");
		/*
		int day = 256559 / (60 * 60 * 24);
		int hour = (256559 - day * 60 * 60 * 24) / (60 * 60); 
		int min = (256559 - day * 60 * 60 * 24 - hour * 60 * 60) / 60;
		int sec = 256559 - day * 60 * 60 * 24 - hour * 60 * 60 - min * 60;
		
		System.out.println(day + "天 " + hour + "小時 " + min + "分 " + sec + "秒");
		*/
		int totalSeconds = 256559;
		
		int day = totalSeconds / (60 * 60 * 24);
		int hour = (totalSeconds % (60 * 60 * 24)) / (60 * 60);
		int min = (totalSeconds % (60 * 60)) / 60;
		int sec = totalSeconds % 60;
		
		System.out.println(day + "天 " + hour + "小時 " + min + "分 " + sec + "秒");
				
		// 4
		System.out.println("============4============");
		double PI = 3.1415;
		double area = Math.pow(5, 2) * PI;
		double perimeter = (2 * 5) * PI;
		System.out.println("面積= " + area + "; 周長= " + perimeter);
		System.out.printf("面積= %.3f; 周長= %.3f%n", area, perimeter);
		
		// 5
		System.out.println("============5============");
		double savings = 1500000 * Math.pow(1 + 0.02, 5);
		System.out.println(savings + "元");
		System.out.printf("%.2f元%n", savings);
		
		// 6
		System.out.println("============6============");
		System.out.println(5 + 5); // 數字相加
		System.out.println(5 + '5'); // 數字+字元 => '5"經過unicode轉換為16進位的0035 => 3*16+5 = 53 => 53 + 5 = 58
		System.out.println(5 + "5"); // 數字+字串 => 型別轉換(type coercion) to String => "5" + "5" => "55" 
		System.out.println((5 + "5") instanceof String); // true
	}
}
