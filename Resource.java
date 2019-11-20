import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Resource implements Runnable {
	
	private final int DELAY = 50;

	protected int size;
	
	protected LinkedList<int[]> pos;
	
	protected Random rand;
	
	protected Game game;
	
	protected Thread hilo;
	
	protected Image[] sprites = {new ImageIcon("resource1.png").getImage(),
			                     new ImageIcon("resource2.png").getImage(),
			                     new ImageIcon("resource3.png").getImage(),
			                     new ImageIcon("resource4.png").getImage(),
			                     new ImageIcon("resource5.png").getImage(),
			                     new ImageIcon("resource.png").getImage()};
	
	protected Image sprite = new ImageIcon("resource.png").getImage();
	
	public Resource(Game game) {
		this.rand = new Random();
		this.size = 4+rand.nextInt(5);
		this.pos = new LinkedList<>();
		this.game = game;
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void generateResource(int x, int y, int n) {
		if(n < this.size) {
			int[] block = {x, y};
			
			int dir = rand.nextInt(4);
			switch(dir) {
				case 0:
					block[0] = (x+1)%Game.COLS;
					block[1] = y;
					break;
				case 1:
					block[0] = x;
					block[1] = (y+1)%Game.ROWS;
					break;
				case 2:
					block[0] = (x+Game.COLS-1)%Game.COLS;
					block[1] = y;
					break;
				case 3:
					block[0] = x;
					block[1] = (y+Game.ROWS-1)%Game.ROWS;
					break;
			}
			
			if(this.game.getGrid(block) != -2 && this.game.getGrid(block) != -4 && this.game.getGrid(block) != -1 && this.game.getGrid(block) != -6) {
				this.pos.add(block);
				this.game.setGrid(block, -2);
				this.generateResource(block[0], block[1], n+1);
			} else {
				this.generateResource(x, y, n+1);
			}
		} else {
			this.size = this.pos.size();
		}
	}
	
	public void paintResource(Graphics g) {
		for(int[] cell : this.pos) {
			g.drawImage(this.sprite, Game.CELL_SIZE*cell[0]+1, Game.CELL_SIZE*cell[1]+1, this.game);
		}
	}
	
	//Setters and Getters
	
	public int[][] getGridCells() {
		int[][] temp = new int[this.pos.size()][2];
		int index = 0;
		for(int[] i : this.pos) {
			temp[index] = i;
			index++;
		}
		return temp;
	}
	
	public int getSize() {
		return this.size;
	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int cont = 0;
        int index = 0;
        boolean anim = false;
       
		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
				Thread.sleep(sleep);
				cont++;

				if(anim && cont%2 == 0) {
					this.sprite = this.sprites[index++];
				}

				if(cont%12 == 0) {
					index = 0;
					anim = false;
				}
				
				if(cont%50 == 0) {
					cont = 0;
					if(rand.nextInt(8) == 4) {
						anim = true;
					};
				}
				
			
			} catch (InterruptedException e) {

			}
            beforeTime = System.currentTimeMillis();
		}
	}
	
}
