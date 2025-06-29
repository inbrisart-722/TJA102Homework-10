package hw6;

import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {
		// user input
		Scanner sc = new Scanner(System.in); 
		// create array for the user input
		int[] answers = new int[2];
		
		// while loop until successfully create a new Calculator
		int counter = 0;
		while(true) {
			if(counter == 0) System.out.println("請輸入x的值：");
			if(counter == 1) System.out.println("請輸入y的值：");
			
			if(sc.hasNextInt()) {
				int temp = sc.nextInt();
				answers[counter] = temp;
				counter++;
			} else {
				sc.next();
				System.out.println("輸入格式不正確"); 
				continue;
			}
			
			if(counter == 2) {
				try {
					Calculator calc = new Calculator(answers[0], answers[1]);
					break;
				} catch(CalException e) {
					System.out.println(e.getMessage());
					counter = 0;
				}
			}
		}
		// release the usage of resources (???)
		sc.close();
	}
}
