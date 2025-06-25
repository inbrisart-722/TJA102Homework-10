package hw5.hero;

//第6頁的題目 - Hero那個 暗黑破壞神啥的 XD
public class Hw5_6_Main {
	// 測試直接寫這吧！（懶）
	public static void main(String[] args) {
		Hero hero1 = new ArrowMan();
		Hero hero2 = new SwordMan("Brian", 30, 50);

		System.out.println(hero1.printHero());
		System.out.println(hero2.printHero());
		System.out.println();

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
}
