package hw5;

// 第3頁的題目
// 我把 Hw5_3 當作題目說的 MyRectangleMain
public class Hw5_3 {
	public static void main(String[] args) {
	// 建立物件
	MyRectangle rec1 = new MyRectangle();
	MyRectangle rec2 = new MyRectangle(10, 20); // 傳 int 去給 double 吃
	
	// 手動設定那個只呼叫到空建構子的實體的屬性
	rec1.setWidth(10);
	rec1.setDepth(20);
	
	// 印出答案
	System.out.println(rec1.getArea());
	System.out.println(rec2.getArea());
	}
}

class MyRectangle{
	double width;
	double depth;
	
	// constructor 
	public MyRectangle() {}
	public MyRectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}
	
	// other methods
	void setWidth(double width) {
		this.width = width;
	}
	void setDepth(double depth) {
		this.depth = depth;
	}
	double getArea() {
		return width * depth;
	}
}
