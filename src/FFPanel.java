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

	public FFPanel(){
		this.setPreferredSize(new Dimension(this.SIZE_PANEL,SIZE_PANEL));

	}

	public void start() {
		gameDriver.mappanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"moveLeft");
		gameDriver.getPanel().getActionMap().put("moveLeft",new AbstractAction(){
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gameDriver.pc.moveSide(-10);
						gameDriver.getFrame().repaint();
						findEnemies();
					}
				});	
		
		gameDriver.getPanel().getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"moveRight");
		gameDriver.getPanel().getActionMap().put("moveRight",new AbstractAction(){
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gameDriver.pc.moveSide(10);
						gameDriver.getFrame().repaint();
						findEnemies();
					}
				});	
		
		gameDriver.getPanel().getInputMap().put(KeyStroke.getKeyStroke("UP"),"moveUp");
		gameDriver.getPanel().getActionMap().put("moveUp",new AbstractAction(){
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gameDriver.pc.moveUp(-10);
						gameDriver.getFrame().repaint();
						findEnemies();
					}
				});	
		
		gameDriver.getPanel().getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"moveDown");
		gameDriver.getPanel().getActionMap().put("moveDown",new AbstractAction(){
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gameDriver.pc.moveUp(10);
						gameDriver.getFrame().repaint();
						findEnemies();
					}
				});	
		
				mappanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"select");
				mappanel.getActionMap().put("select",new AbstractAction(){
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gameDriver.ChangedtoFight();
						gameDriver.getFrame().repaint();
					}
				});	
		
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
		supermap.draw(g);
	}
}
