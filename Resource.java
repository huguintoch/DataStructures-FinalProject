import java.awt.*;
import java.util.*;

public class Resource {

	public int size;
	
	private int[][] pos;
	
	private Random rand;
	
	public Resource() {
		this.rand = new Random();
		this.size = 4+rand.nextInt(5);
		
		this.pos = new int[this.size][2];
	}
	
	public void generateResource(Game game, int x, int y, int n) {
		if(n < this.size) {
			int[] block = {x, y};
			pos[n][0] = block[0];
			pos[n][1] = block[1];
			
			game.setGrid(block, -2);
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
			
			if(game.getGrid(block) != -2) {
				this.generateResource(game, block[0], block[1], n+1);
			} else {
				this.generateResource(game, x, y, n);
			}
		}
	}
	
	public int[][] getGridCells() {
		return this.pos;
	}

}
