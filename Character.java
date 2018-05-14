import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {

	private int Exp;
	private int Level;
	private int Health;
	private int Mana;
	private int x;
	private int y;
	private boolean Type;
	private Image pic;

	public Character(boolean type, int level, int health, int mana) {
		Exp = 0;
		Level = level;
		Health = health;
		Mana = mana;
		Type = type;
	}

	public void setHealth(int newHealth) {
		Health = newHealth;
	}

	public void setMana(int newMana) {
		Mana = newMana;
	}

	public void Levelup() {
		Level++;
	}

	public int attack(Character opponent) {
		return (int) Math.random()*10 + Level*5;
	}
	
	public void moveSide(int direction) {
		x += direction;
	}
	
	public void moveUp(int direction) {
		y += direction;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int X) {
		x = X;
	}
	
	public void setY(int Y) {
		y = Y;
	}
	
	public void draw(Graphics g) {
		if(Type) {
			try {
				pic = ImageIO.read(new File ("src/arthas.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pic, x, y, 25, 30, null);
		}
		else if(Type == false) {
			try {
				pic = ImageIO.read(new File ("src/dungeon.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pic, 0, 0, null);
		}
	}

}
