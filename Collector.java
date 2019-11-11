import java.awt.*;

public class Collector implements Runnable {

	private final int DELAY = 50;
	private int x,
				y;
	
	private int[][] gridCells = new int[4][2];
	
	private Thread hilo;
	
	private Game game;
	
	public Collector(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		
		int[] block1 = {x,y};
		this.gridCells[0] = block1;
		int[] block2 = {x+1,y};
		this.gridCells[1] = block2;
		int[] block3 = {x,y+1};
		this.gridCells[2] = block3;
		int[] block4 = {x+1,y+1};
		this.gridCells[3] = block4;
		
		this.game = game;
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void paintCollectorArea(Graphics g) {
		g.setColor(new Color(255, 0, 255));
		int x_ = this.x*Game.CELL_SIZE - Game.CELL_SIZE*3;
		int y_ = this.y*Game.CELL_SIZE - Game.CELL_SIZE*3;
		g.drawRect(x_, y_, Game.CELL_SIZE*8, Game.CELL_SIZE*8);
	}
	
	public int collect(Game game) {
		int sum = 0;
		int[] cell = new int[2];
		for(int i = x-3; i < x+5; i++) {
			for (int j = y-3; j < y+5; j++) {
				cell[0] = i;
				cell[1] = j;
				if(game.getGrid(cell) == -2) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	public void updateGrid(Game game, int value) {
		for(int[] cell : this.gridCells) {
			game.setGrid(cell, value);
		}
	}
	
	public int[][] getGridCells(){
		return this.gridCells;
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
				if(cont%50 == 0) {
					cont = 0;
					game.accumMoney(collect(game));
				}
			} catch (InterruptedException e) {
				
			}
            beforeTime = System.currentTimeMillis();
		}
	}

}
