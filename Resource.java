import java.awt.*;
import java.util.*;

public class Resource {

	private int x,
				y,
				size;
	
	private int[][] pos;
	
	private Random rand;
	
	public Resource(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.rand = new Random();
		this.size = 4+rand.nextInt(5);
		
		this.pos = new int[this.size][2];

		this.generateResource(this.x, this.y, 0);
	}
	
	public void paintResource(Graphics g) {
		g.setColor(Color.GREEN);
  
		for (int i = 0; i < this.size; i++) {
			g.fillRect(this.pos[i][0], this.pos[i][1], Game.CELL_SIZE, Game.CELL_SIZE);
		}
	}
	
	public void generateResource(int x, int y, int n) {
		if(n < this.size-1) {
			int dir = rand.nextInt(4);
			switch(dir) {
				case 0:
					
					break;
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
			}
		}
	}

}
