//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall {
	
	private int life,
	            wallId;
	
	private int[] gridCell;
	
	private Game game;
	
	private Image sprite = new ImageIcon("wall.png").getImage();
	
	public Wall(int wallId, int x, int y, Game game) {

		this.life = 7;
		this.wallId = wallId;
		
		int[] gridCell = {x,y};
		this.gridCell = gridCell;
		
		this.game = game;
		this.game.setGrid(this.gridCell, this.wallId);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.sprite, Game.CELL_SIZE*this.gridCell[0]+1, Game.CELL_SIZE*this.gridCell[1]+1, this.game);
	}
	
	
	//Setters and Getters
	
	public void setLife(int damage) {
		this.life += damage;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int[] getGridCell(){
		return this.gridCell;
	}
	
}
