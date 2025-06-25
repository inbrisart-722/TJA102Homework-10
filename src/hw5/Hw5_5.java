package hw5;

//第5頁的題目
public class Hw5_5 {
	public static void main(String[] args) {
		Pen p1 = new Pencil("Brand-Pencil", 100);
		Pen p2 = new InkBrush("Brand-InkBrush", 250);
		
		System.out.println( p1.getPrice() );
		p1.write();
		System.out.println( p2.getPrice() );
		p2.write();
	}
}

abstract class Pen{
	private String brand;
	private double price;
	
	public Pen() {}
	public Pen(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	abstract public void write();
}

class Pencil extends Pen{
	Pencil() {}
	Pencil(String brand, double price){
		super(brand, price);
	}
	public double getPrice() {
		return (super.getPrice() * 0.8); // 封裝不能直接叫唷！
	}
	public void write() {
		System.out.println("削鉛筆再寫");
	}
}

class InkBrush extends Pen{
	InkBrush() {}
	InkBrush(String brand, double price){
		super(brand, price);
	}
	public double getPrice() {
		return (super.getPrice() * 0.9); // 封裝不能直接叫唷！
	}
	public void write() {
		System.out.println("沾墨汁再寫");
	}
}
