import java.awt.*;
import java.util.Random;

public class Resource {

	private int x,
				y,
				size;
	
	private int[][] pos;
	
	public Resource(int x, int y) {
		this.x = x*10;
		this.y = y*10;
		Random rand = new Random();
		this.size = 4+rand.nextInt(9);
		this.pos = new int[this.size][2];
	}
	
	public void paintResource(Graphics g) {
		for (int i = 0; i < this.size; i++) {
			g.fillRect(this.pos[i][0]*10, this.pos[i][1]*10, 10, 10);
		}
	}
	
	public void generateResource() {
		
	}

}
