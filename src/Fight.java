import java.awt.Color;
import java.awt.Graphics;

public class Fight {

	public Character enemy;

	public Fight() {
		enemy = new Character(false, 1, 100, 100);

	}


	public void draw(Character pc, Graphics g) {
		pc.draw(g);
		enemy.draw(g);
	}
}
