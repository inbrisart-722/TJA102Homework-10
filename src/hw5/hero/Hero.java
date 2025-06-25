package hw5.hero;

// 其實這好像應該是個 abstract class （但是 抽象概念 和這裡的 Strategy 沒差先不管）
public class Hero {
	// 省略 getter/setter...

	private String name;
	private int level;
	private double exp;

	private IAttackStrategy attackS; // private vs protected
	private IMoveStrategy moveS;
	private IDefendStrategy defendS;

	public Hero() {
		this("David", 1, 0);
	}

	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}

	// 偷加一個印出屬性
	public String printHero() {
		return (name + " is level " + level + " having " + exp + " exp.");
	}

	public void setAttackStrategy(IAttackStrategy attackS) {
		this.attackS = attackS;
	}

	public void setMoveStrategy(IMoveStrategy moveS) {
		this.moveS = moveS;
	}

	public void setDefendStrategy(IDefendStrategy defendS) {
		this.defendS = defendS;
	}

	public void attack() {
		if(attackS != null) attackS.attack();
		else System.out.println(name + " has no attack strategy.");
	}

	public void move() {
		if(moveS != null) moveS.move();
		else System.out.println(name + " has no move strategy.");
	}

	public void defend() {
		if(defendS != null) defendS.defend();
		else System.out.println(name + " has no defind strategy.");
	}

}
