package hw1;

// 要記得把課堂上巢狀迴圈的99乘法表拿進來
public class hw2 {
	public static void main(String[] args) {
		// 99乘法表 for + while 
//		for (int j = 1; j <= 9; j++) {
//			int k = 1;
//			while (k <= 9) {
//				System.out.print(j + "*" + k + "=" + (j*k) + "\t");
//				k++; 
//			}
//		 System.out.println();
//		}
	
		
		 // 99乘法表 for + do while
//		for (int r = 1; r <= 9; r++) {
//			int t = 1;
//			do {
//				System.out.print(r + "*" + t + "=" + (r * t) + "\t"); t += 1;
//			} while ( t <= 9 ); 
//			System.out.println();
//	   	}
		
		
		 // 99乘法表 while + do while 
//		 int x = 1;
//		 while(x <= 9) {
//			 int y = 1;
//			 do {
//				 System.out.print(x + "*" + y + "=" + (x * y) + "\t");
//				 y++;
//			 } while(y <= 9);
//			 x++;
//			 System.out.println();
//		 }

		 // 1-1
//		 int sum1 = 0; 
//		 for (int i = 2; i <= 1000; i += 2) 
//			 sum1 += i;
//		 System.out.println(sum1);
		 
		 // 1-2 
//		 int sum2 = 1;
//		 for (int i = 1; i <= 10; i += 1) sum2 *= i;
//		 System.out.println(sum2);
		 
		 // 1-3 
//		 int sum3 = 1;
//		 int i = 1;
//		 while(i <= 10) {
//			 sum3 *= i;
//			 i++; 
//		 };
//		 System.out.println(sum3);
		 
		 // 1-4
//		 for (int j = 1; j <= 10; j++) {
//			 System.out.print( (int)Math.pow(j, 2) );
//			 if (j != 10) {
//				 System.out.print(" ");
//			 }
//		 } 
//		 System.out.println();
		
		 // 2-1 
//		 for (int j = 1; j <= 49; j++) {
//			 if( (j - 4) % 10 !=  0 && (j / 10) != 4 )
//				 System.out.print(j + " "); 
//		 }
//		 System.out.println();
		
		 // 2-2 
//		 for (int j = 1; j <= 10; j++) {
//			 for (int k = 1; k <= 11 - j ; k++) {
//				 System.out.print(k + " "); 
//			 }
//			 	System.out.println();
//		 }
	
	
		 // 3-1 // 0041 ~ 0046 (65+) 好呆的方法 => 改更乾淨一點 
//		 for (char j = 'A' ; j <= 'F'; j++) {
//			 for (char k = 1; k <= j - 64; k++) { // char 被 promoted to int
//				 System.out.print(j); 
//			}
//			 System.out.println();
//		 }

		// 3-1 成功了！
//		System.out.println( (char)48 );
//		System.out.println( (char)65 );
		
//		for (int j = 1; j <= 6; j++) {
//			for (int k = 1; k <= j; k++) {
//				System.out.print((char) (j + 64));
//			}
//			System.out.println();
//		}
		
//		System.out.println("3" == "3");
//		
//		String numberStr = "123";
//		int number = Integer.parseInt(numberStr);
//		
//		double pi = 3.14159;
//		String piStr = Double.toString(pi);
//		
//		System.out.println(number);
//		System.out.println(number + 1);
//		System.out.println(piStr);
//		System.out.println(piStr + " is pi");
//		
//		int k = 3;
//		Integer.toString(k);
//		System.out.println(Integer.toString(k) instanceof String);
//		
//		System.out.printf("|%10s|%n", "Hello");  // 右對齊，前面空格n  |Hello
//		System.out.printf("|%-10s|%n", "Hello"); // 左對齊，後面空格
//		System.out.printf("|%05d|%n", 42);       // 補 0 → 00042
//		System.out.printf("|%10.2f|%n", 3.14159); // 浮點數，欄寬 10，小數點後 2 位
//
//		String name = "Tom";
//        int age = 25;
//        double score = 87.54321;
//        char grade = 'A';
//
//        // 基本輸出
//        System.out.printf("Name: %s%n", name); // Name: Tom
//        System.out.printf("Age: %d%n", age); // Age: 25
//        System.out.printf("Score: %.2f%n", score); //  Score: 87.54
//        System.out.printf("Grade: %c%n", grade); // Grade: A
//
//        // 欄寬設定
//        System.out.printf("|%10s|%n", name);     //|       Tom|
//        System.out.printf("|%-10s|%n", name);    //|Tom       |
//        System.out.printf("|%05d|%n", age);      //|00025|
//        System.out.printf("|%10.2f|%n", score);  //|     87.54|
//
//        // 輸出百分比符號
//        System.out.printf("Progress: %d%%%n", 75);  // Progress: 75%
//
//        // 多參數混用 Name: Tom       | Age: 25 | Score:   87.5 | Grade: A
//        System.out.printf("Name: %-10s | Age: %02d | Score: %6.1f | Grade: %c%n", name, age, score, grade);

	}}

class Student {
	static String schoolName = "ABC High School";
	String name;
	int score;

	public static void main(String[] args) {
		Student student1 = new Student("Brian", 100);
		student1.showInfo();
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public void showInfo() {
		int score = 999;
		System.out.println(Student.schoolName);
		System.out.println(name);
		System.out.println(this.score);
		System.out.println(score);
	}
}
