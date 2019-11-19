import java.awt.Color;
import java.awt.Graphics;

import javax.swing.CellEditor;
import javax.swing.ImageIcon;

public class Constructor implements Runnable {
	
	private final int DELAY = 50;
	
	private int x,
				y,
				type;
	
	private Game game;
	
	private Thread hilo;
	
	private boolean done = false;
	
	public Constructor(int x, int y, int type, Game game, boolean start) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.game = game;
		this.hilo = new Thread(this);
		if(start) {
			this.hilo.start();
		}
		int[] cell = {x, y};
		this.game.setGrid(cell, -7);
	}
	
	public void start() {
		this.hilo.start();
	}
	
	public void paintConstructor(Graphics g) {
		g.drawImage(new ImageIcon("constructor.png").getImage(),this.x*Game.CELL_SIZE, this.y*Game.CELL_SIZE, game);
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
				if(cont%100 == 0 && !this.done) {
					this.done = true;
					if(type == 1) {
						this.game.addCollector(new Collector(this.x, this.y, game));
					} else {
						this.game.addTurret(new Turret(this.x, this.y, game));
					}
				}
				
				int[] cell = {this.x, this.y};
				if(this.game.getGrid(cell) != -7) {
					this.done = true;
				}
			} catch (InterruptedException e) {

			}
            beforeTime = System.currentTimeMillis();
		}
	}
	
}
