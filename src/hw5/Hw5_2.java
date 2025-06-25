package hw5;

// 第2頁的題目
public class Hw5_2 {
	// overloading of the int version
	public static int maxElement(int[][] x) {
		int maxElement = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > maxElement)
					maxElement = x[i][j];
			}
		}
		return maxElement;
	}
	// overloading of the double version
	public static double maxElement(double[][] x) {
		double maxElement = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > maxElement)
					maxElement = x[i][j];
			}
		}
		return maxElement;
	}

	public static void main(String[] args) {
		int[][] intArray = { { 1, 6, 3 }, { 9, 5, 2 } };
		double[][] doubleArray = { { 1.2, 3.5, 2.2 }, { 7.4, 2.1, 8.2 } };

		// 雖然看題目寫要我用 instance method, yet 我想寫 static XD
		System.out.println(maxElement(intArray));
		System.out.println(maxElement(doubleArray));
	}
}
