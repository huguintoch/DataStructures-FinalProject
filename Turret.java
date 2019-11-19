import java.awt.*;

import javax.swing.ImageIcon;

public class Turret implements Runnable {

	private final int DELAY = 50;
	private int x,
				y;
	
	private boolean done = false;

	private int[] pos = new int[2];

	private Thread hilo;

	private Game game;
	
	private Image[] cannonSprites = {new ImageIcon("t0.png").getImage(),
							         new ImageIcon("t30.png").getImage(),
							         new ImageIcon("t45.png").getImage(),
							         new ImageIcon("t60.png").getImage(),
					        		 new ImageIcon("t90.png").getImage(),
							         new ImageIcon("t120.png").getImage(),
							         new ImageIcon("t135.png").getImage(),
							         new ImageIcon("t150.png").getImage(),
							         new ImageIcon("t180.png").getImage(),
							         new ImageIcon("t210.png").getImage(),
							         new ImageIcon("t225.png").getImage(),
							         new ImageIcon("t240.png").getImage(),
					        		 new ImageIcon("t270.png").getImage(),
							         new ImageIcon("t300.png").getImage(),
							         new ImageIcon("t315.png").getImage(),
							         new ImageIcon("t330.png").getImage()};
	
	private Image[] sprite = {new ImageIcon("turret.png").getImage(),
							  new ImageIcon("turret4.png").getImage()};
	
	public Turret(int x, int y, Game game) {
		this.x = x;
		this.y = y;

		this.pos[0] = x;
		this.pos[1] = y; 

		this.game = game;
		
		game.setGrid(this.pos, -5);

		this.hilo = new Thread(this);
		this.hilo.start();
	}

	
	public void paint(Graphics g) {
		g.drawImage(this.sprite[0], Game.CELL_SIZE*x+1, Game.CELL_SIZE*y+1, this.game);
		this.paintCollectorArea(g);
	}
	
	public void paintCollectorArea(Graphics g) {
		g.setColor(new Color(255, 160, 0));
		int x_ = this.x*Game.CELL_SIZE - Game.CELL_SIZE*3;
		int y_ = this.y*Game.CELL_SIZE - Game.CELL_SIZE*3;
		g.drawRect(x_+1, y_+1, Game.CELL_SIZE*7, Game.CELL_SIZE*7);
		g.setColor(new Color(255, 160, 0,50));
		g.fillRect(x_+1, y_+1, Game.CELL_SIZE*7, Game.CELL_SIZE*7);
	}

	public void shoot(Game game) {
		int[] cell = new int[2];
		int min = Math.abs(this.x-(this.x-3))+Math.abs(this.y-(this.y-3));
		int[] minPos = {this.x-3, this.y-3};
		boolean shoot = false;
		
		for(int i = x-3; i < x+4; i++) {
			for (int j = y-3; j < y+4; j++) {
				cell[0] = i;
				cell[1] = j;
				if(game.getGrid(cell) == -1) {
					shoot = true;
					if(min > Math.abs(x-i)+Math.abs(y-j)) {
						min = Math.abs(x-i)+Math.abs(y-j);
						minPos[0] = i;
						minPos[1] = j;
					}
				}
			}
		}
		
		this.selectSprite(minPos);
		
		if(shoot) {
			game.setGrid(minPos, 0);
		}
	}
	
	private void selectSprite(int[] minPos) {
		double x0 = this.x+10,
			   y0 = this.y+10,
			   xf = minPos[0]+10,
			   yf = minPos[1]+10;

	}

	public int[] getPos(){
		return this.pos;
	}
	
	public boolean isDead() {
		return this.done;
	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int cont = 0;

		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
				Thread.sleep(sleep);
				cont++;
				int[] cell = {this.x, this.y};
				if(cont%30 == 0) {
					cont = 0;
					if(game.getGrid(cell) == -5) {
						this.shoot(this.game);
					} 
				}
				
				if(game.getGrid(cell) != -5) {
					this.done = true;
				}
				
			} catch (InterruptedException e) {

			}
            beforeTime = System.currentTimeMillis();
		}
	}

}
