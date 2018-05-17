import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import javafx.scene.paint.Color;

public class FFPanel extends JPanel{

	private Image picture;
	private static final int SIZE_PANEL = 600;
	Map supermap = new Map();
	private Character pc;

	public FFPanel(){
		this.setPreferredSize(new Dimension(this.SIZE_PANEL,SIZE_PANEL));

	}

	public void start(Character character) {
		pc = character;
		
}

	public boolean findEnemies() {
		if (Math.random()*10 < 2)
			return true;
		else
			return false;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			picture = ImageIO.read(new File ("src/dungeon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(picture, 0, 0, SIZE_PANEL, SIZE_PANEL, null);
		supermap.draw(pc, g);
	}
}
