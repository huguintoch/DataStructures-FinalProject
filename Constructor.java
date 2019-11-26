//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.CellEditor;
import javax.swing.ImageIcon;

public class Constructor implements Runnable {
	
	private final int DELAY = 50;
	
	private int x,
				y,
				type,
				progressBar;
	
	private Game game;
	
	private Thread hilo;
	
	private Image sprite = new ImageIcon("constructor.png").getImage(),
			      dustSprite;
	
	private Image[] dustsSprites = {new ImageIcon("Layer 1.png").getImage(),
								    new ImageIcon("Layer 2.png").getImage(),
								    new ImageIcon("Layer 3.png").getImage(),
								    new ImageIcon("Layer 4.png").getImage(),
								    new ImageIcon("Layer 5.png").getImage(),
								    new ImageIcon("Layer 6.png").getImage(),
								    new ImageIcon("Layer 7.png").getImage(),
								    new ImageIcon("Layer 8.png").getImage(),
								    new ImageIcon("Layer 9.png").getImage(),
								    new ImageIcon("Layer 10.png").getImage()};
	
	private boolean done = false;
	
	public Constructor(int x, int y, int type, Game game, boolean start) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.progressBar = 0;
		this.game = game;
		this.hilo = new Thread(this);
		if(start) {
			this.hilo.start();
		}
		int[] cell = {x, y};
		this.game.setGrid(cell, -7);
		this.dustSprite = this.dustsSprites[0];
	}
	
	public void start() {
		this.hilo.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.dustSprite, this.x*Game.CELL_SIZE-8, this.y*Game.CELL_SIZE+12, 35, 15, game);
		g.drawImage(this.sprite,this.x*Game.CELL_SIZE, this.y*Game.CELL_SIZE, game);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.GREEN);
		g2.drawLine(this.x*Game.CELL_SIZE, this.y*Game.CELL_SIZE+22, x*Game.CELL_SIZE+this.progressBar, y*Game.CELL_SIZE+22);
	}
	
	public boolean isDead() {
		return this.done;
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int cont = 0;
        int animIndex = 0;

		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
				Thread.sleep(sleep);
				cont++;
				
				if(cont%2 == 0) {
					this.dustSprite = this.dustsSprites[animIndex++];
				}
				
				if(cont%20 == 0) {
					animIndex = 0;
				}
				
				if(cont%30 == 0) {
					this.progressBar+=2;
				}
				
				if(cont%300 == 0 && !this.done) {
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
				//
			}
            beforeTime = System.currentTimeMillis();
		}
	}

	//Setters and Getters
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getType() {
		return this.type;
	}

}
