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

public class gameDriver {

	private static final int SIZE_PANEL = 600;
	public JFrame frame;
	public FFPanel mappanel = new FFPanel();
	public FFPanel savedpanel;
	FFFightPanel fightpanel;
	Map supermap = new Map();
	public Character pc = new Character(true, 1, 100, 100);

	private void main(String[] args) {
		new gameDriver().start();
	}

	private void start() {
		
		frame = new JFrame("Welcome to Final Fantasy XX");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mappanel);
		frame.pack();
		frame.setVisible(true);
		mappanel.start();
		
		mappanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"moveLeft");
		mappanel.getActionMap().put("moveLeft",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pc.moveSide(-10);
				frame.repaint();
				mappanel.findEnemies();
			}
		});	

		mappanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"moveRight");
		mappanel.getActionMap().put("moveRight",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pc.moveSide(10);
				frame.repaint();
				mappanel.findEnemies();
			}
		});	

		mappanel.getInputMap().put(KeyStroke.getKeyStroke("UP"),"moveUp");
		mappanel.getActionMap().put("moveUp",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pc.moveUp(-10);
				frame.repaint();
				mappanel.findEnemies();
			}
		});	

		mappanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"moveDown");
		mappanel.getActionMap().put("moveDown",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pc.moveUp(10);
				frame.repaint();
				mappanel.findEnemies();
			}
		});	

		mappanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"select");
		mappanel.getActionMap().put("select",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangetoFight();
			}
		});	

	}

	public void ChangetoFight() {
		savedpanel = mappanel;
		frame.remove(mappanel);
		frame.add(fightpanel = new FFFightPanel());
		frame.pack();
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}
	
	public void ChangetoMap() {
		frame.remove(fightpanel);
		frame.add(savedpanel);
		frame.pack();
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}
	
	public void gameend() {
		JOptionPane.showMessageDialog(frame, "You died! Try fighting more monsters to level up and get stronger!");
	}
	
	public FFPanel getPanel() {
		return mappanel;
	}
	
	public JFrame getFrame() {
		return frame;
	}

}

