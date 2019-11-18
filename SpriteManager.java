import java.awt.Image;

import javax.swing.ImageIcon;

public class SpriteManager {
	
	private Image[] grid = {new ImageIcon("grid.png").getImage(), 
			                new ImageIcon("grid2.png").getImage()},
			        wall = {new ImageIcon("wall.png").getImage()};

	private Image resource,
				  terrain,
				  base;
	
	public SpriteManager() {
		this.resource = new ImageIcon("resource.png").getImage();
		this.terrain = new ImageIcon("terrain.png").getImage();
		this.base = new ImageIcon("base.png").getImage();
	}
	
	public Image getResourceSprite() {
		return this.resource;
	}
	
	public Image getTerrainSprite() {
		return this.terrain;
	}
	
	public Image getBaseSprite() {
		return this.base;
	}
	
	public Image[] getWallSprite() {
		return this.wall;
	}
	
	public Image[] getGridSprite() {
		return this.grid;
	}
}
