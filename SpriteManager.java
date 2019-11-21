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
			        virus = {new ImageIcon("virus.png").getImage(),
			        		 new ImageIcon("virus2.png").getImage(),
			        		 new ImageIcon("virus3.png").getImage(),
			        		 new ImageIcon("virus4.png").getImage(),
			        		 new ImageIcon("virus5.png").getImage()},
			        wallPanel = {new ImageIcon("wall_panel.png").getImage(),
			        			 new ImageIcon("wall_panel_s.png").getImage()},
			        collectorPanel = {new ImageIcon("collector_panel_1.png").getImage(),
			        		  		  new ImageIcon("collector_panel_1_s.png").getImage(),
			        		  		  new ImageIcon("collector_panel_2.png").getImage(),
			        		  		  new ImageIcon("collector_panel_2_s.png").getImage(),
			        		  		  new ImageIcon("collector_panel_3.png").getImage(),
			        		  		  new ImageIcon("collector_panel_3_s.png").getImage()},
			        turretPanel = {new ImageIcon("turret_panel_1.png").getImage(),
			        		  	   new ImageIcon("turret_panel_1_s.png").getImage(),
			        		  	   new ImageIcon("turret_panel_2.png").getImage(),
			        		  	   new ImageIcon("turret_panel_2_s.png").getImage(),
			        		  	   new ImageIcon("turret_panel_3.png").getImage(),
			        		  	   new ImageIcon("turret_panel_3_s.png").getImage()},
			        basePanel = {new ImageIcon("base_panel_1.png").getImage(),
				        		 new ImageIcon("base_panel_1_s.png").getImage(),
				        		 new ImageIcon("base_panel_2.png").getImage(),
				        		 new ImageIcon("base_panel_2_s.png").getImage(),
				        		 new ImageIcon("base_panel_3.png").getImage()},
			        curePanel = {new ImageIcon("cure_panel_1.png").getImage(),
				        		 new ImageIcon("cure_panel_1s.png").getImage()},
			        btnCollectors = {new ImageIcon("btnCollector.png").getImage(), 
			                		new ImageIcon("btnCollectorS.png").getImage()},
			        btnTurrets = {new ImageIcon("btnTurrets.png").getImage(), 
			                		new ImageIcon("btnTurretsS.png").getImage()},
			        btnConstructor = {new ImageIcon("btnConstructor.png").getImage(), 
					                new ImageIcon("btnConstructorS.png").getImage()},
			        btnDebug = {new ImageIcon("btnDebug.png").getImage(), 
			    			        new ImageIcon("btnDebugS.png").getImage()};
			        

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

	public Image[] getWallPanel() {
		return wallPanel;
	}

	public Image[] getCollectorPanel() {
		return collectorPanel;
	}

	public Image[] getTurretPanel() {
		return turretPanel;
	}

	public Image[] getBasePanel() {
		return basePanel;
	}

	public Image[] getCurePanel() {
		return curePanel;
	}

	public Image[] getBtnCollectors() {
		return btnCollectors;
	}

	public Image[] getBtnTurrets() {
		return btnTurrets;
	}

	public Image[] getBtnConstructor() {
		return btnConstructor;
	}

	public Image[] getBtnDebug() {
		return btnDebug;
	}

}
