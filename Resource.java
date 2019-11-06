import java.awt.*;
import java.util.*;

public class Resource {

	private int size;
	
	private LinkedList<int[]> pos;
	
	private Random rand;
	
	public Resource() {
		this.rand = new Random();
		this.size = 4+rand.nextInt(5);
		
		this.pos = new LinkedList<>();
	}
	
	public void generateResource(Game game, int x, int y, int n) {
		if(n < this.size) {
			int[] block = {x, y};
			
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
				this.pos.add(block);
				this.generateResource(game, block[0], block[1], n+1);
			} else {
				this.generateResource(game, x, y, n+1);
			}
		} else {
			this.size = this.pos.size();
		}
	}
	
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

}
