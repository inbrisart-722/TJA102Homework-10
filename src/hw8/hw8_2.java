package hw8;

import java.util.Objects;
import java.util.TreeSet;

/* 請設計一個Train類別，並包含以下屬性：
- 班次 number，型別為int - 車種 type，型別為String - 出發地 start，型別為String
- 目的地 dest，型別為String - 票價 price，型別為double
• 設計對應的getter/setter方法， */

class Train implements Comparable<Train> {
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;

	public Train() {
	}

	public Train(int number, String type, String start, String dest, double price) {
		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}

	// getter group
	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getStart() {
		return start;
	}

	public String getDest() {
		return dest;
	}

	public double getPrice() {
		return price;
	}

	// setter group
	public void setNumber(int number) {
		this.number = number;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dest, number, price, start, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return Objects.equals(dest, other.dest) && number == other.number
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(start, other.start) && Objects.equals(type, other.type);
	}
	
	@Override
	public int compareTo(Train other) {
		if(this.number > other.number) return -1;
		if(this.number < other.number) return 1;
		return 0;
	}
}

public class hw8_2 {
	public static void main(String[] args) {
		Train[] ts = new Train[7];
		ts[0] = new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		ts[1] = new Train(1254, "區間", "屏東", "基隆", 700);
		ts[2] = new Train(118, "自強", "高雄", "台北", 500);
		ts[3] = new Train(1288, "區間", "新竹", "基隆", 400);
		ts[4] = new Train(122, "自強", "台中", "花蓮", 600);
		ts[5] = new Train(1222, "區間", "樹林", "七堵", 300);
		ts[6] = new Train(1254, "區間", "屏東", "基隆", 700);
		/* 請寫一隻程式，能印出不重複的Train物件
		 • 請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出
		 • 承上，不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件
		 • (以上三題請根據使用的集合，練習各種取值寫法，如迭代器、for迴圈或foreach等) */
		
//		ArrayList<Train> al = new ArrayList<>();
//		PriorityQueue<Train> pq = new PriorityQueue<>();
//		LinkedList<Train> ll = new LinkedList<>();
//		HashSet<Train> hs = new HashSet<>();
//		TreeMap<Integer, Train> tm = new TreeMap<>();
//		HashMap<Integer, Train> hm = new HashMap<>();

//		// 1. treeset
		TreeSet<Train> tse = new TreeSet<>();
		for(int i = 0 ; i < ts.length ; i++) {
			tse.add(ts[i]);
		}
//		// 1-1. treeset for-each
//		for(Train t: tse) {
//			System.out.println(t.getNumber());
//		}
//		// 1-2. treeset iterator
//		Iterator<Train> itts = tse.iterator();
//		while(itts.hasNext()) {
//			System.out.println(itts.next().getNumber());
//		}
		// 1-3. treeset toArray + for loop
		Train[] tArr = tse.toArray(new Train[0]);
		for(int i = 0 ; i < tArr.length ; i ++) {
			System.out.println(tArr[i].getNumber());
		}
	
		
	}
}
