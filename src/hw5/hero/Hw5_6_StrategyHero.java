package hw5.hero;

//第6頁的題目 - Hero那個 暗黑破壞神啥的 XD
public class Hw5_6_StrategyHero {
	// 測試直接寫這吧！（懶）
	public static void main(String[] args) {
		Hw5_6_StrategyHero hero1 = new ArrowMan();
		Hw5_6_StrategyHero hero2 = new SwordMan("Brian", 30, 50);
		
		System.out.println( hero1.printHero() );
		System.out.println( hero2.printHero() );
		
		IAttackStrategy arrow = new AttackArrow();
		IAttackStrategy sword = new AttackSword();
		
		IDefendStrategy action = new DefendAction();
		
		IMoveStrategy run = new MoveRun();
				
		hero1.setAttackStrategy(arrow);
		hero1.setDefendStrategy(action);
		hero1.setMoveStrategy(run);
		
		hero2.setAttackStrategy(sword);
		hero2.setDefendStrategy(action);
		hero2.setMoveStrategy(run);
		
		hero1.attack();
		hero1.defend();
		hero1.move();
		System.out.println();
		hero2.attack();
		hero2.defend();
		hero2.move();
	}
	
	// 省略 getter/setter...
	
	private String name;
	private int level;
	private double exp;
	
	protected IAttackStrategy attackS; // private 可以嗎??
	protected IMoveStrategy moveS;
	protected IDefendStrategy defendS;
	
	public Hw5_6_StrategyHero() {
		this("David", 1, 0);
	}
	public Hw5_6_StrategyHero(String name, int level, double exp) {
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
		attackS.attack();
	}
	public void move() {
		moveS.move();
	}
	public void defend() {
		defendS.defend();
	}
}
