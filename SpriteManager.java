import java.awt.Image;

import javax.swing.ImageIcon;

public class SpriteManager {
	
	private Image[] grid = {new ImageIcon("grid.png").getImage(), 
			                new ImageIcon("grid2.png").getImage()},
			        wall = {new ImageIcon("wall.png").getImage(),
			        		new ImageIcon("wall2.png").getImage(),
			        		new ImageIcon("wall3.png").getImage()},
			        collector = {new ImageIcon("collector.png").getImage(),
					        	 new ImageIcon("collector2.png").getImage(),
					        	 new ImageIcon("collector3.png").getImage()},
			        turret = {new ImageIcon("turret.png").getImage(),
			        		  new ImageIcon("turret2.png").getImage(),
			        		  new ImageIcon("turret3.png").getImage()},
			        virus = {new ImageIcon("virus.png").getImage()};

	private Image resource,
				  terrain,
				  base,
				  virusSpawner;
	
	public SpriteManager() {
		this.resource = new ImageIcon("resource.png").getImage();
		this.terrain = new ImageIcon("terrain.png").getImage();
		this.base = new ImageIcon("base.png").getImage();
		this.virusSpawner = new ImageIcon("virusSpawner.png").getImage();
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
	
	public Image[] getCollectorSprite() {
		return this.collector;
	}
	
	public Image[] getTurretSprite() {
		return this.turret;
	}
	
	public Image[] getVirusSprite() {
		return this.virus;
	}
	
	public Image getVirusSpawnerSprite() {
		return this.virusSpawner;
	}
	
	public Image[] getGridSprite() {
		return this.grid;
	}
}
