import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class VirusSpawner {
	
	private int life;
	private int[][] location;
	
	private Game game;
	
	private Image sprite = new ImageIcon("virusSpawner.png").getImage();
	
	public VirusSpawner(Game game) {
		this.life = 100;
		int[][] location = {{2,2},{2,3},{3,2},{3,3}};
		this.location = location;
		for(int[] cell : this.location) {
			game.setGrid(cell, -1);
		}
		this.game = game;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		float alpha = 0.60f; 
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
		g2D.setComposite(ac);
		g2D.drawImage(this.sprite, Game.CELL_SIZE*2+1, Game.CELL_SIZE*2+1, this.game);
	}
	
	//Setters & Getters

	public void setLife(int life) {
		this.life += life;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int[][] getLocation() {
		return this.location;
	}

}
