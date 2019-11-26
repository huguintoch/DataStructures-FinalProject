//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Base {
	
	private int level;
	private int[][] location;
	
	private Game game;
	
	private Image sprite = new ImageIcon("base.png").getImage();
	
	public Base(Game game) {
		this.level = 1;
		int[][] location = {{36,30},{37,30},{36,31},{37,31}};
		this.location = location;
		for(int[] cell : this.location) {
			game.setGrid(cell, -4);
		}
		this.game = game;
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.sprite, this.location[0][0]*Game.CELL_SIZE+1, this.location[0][1]*Game.CELL_SIZE+1, this.game);
	}
	
	//Setters & Getters
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int[][] getLocation() {
		return this.location;
	}

}
