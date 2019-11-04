import java.util.Arrays;

public class Wall {
	
	private int life,
	            wallId;
	
	private int[][] gridCells = new int[4][2];
	
	public Wall(int wallId, int x, int y) {
		
		this.life = 10;
		this.wallId = wallId;
	
		int[] block1 = {x,y};
		this.gridCells[0] = block1;
		int[] block2 = {x+1,y};
		this.gridCells[1] = block2;
		int[] block3 = {x,y+1};
		this.gridCells[2] = block3;
		int[] block4 = {x+1,y+1};
		this.gridCells[3] = block4;
	
	}
	
	private updateGrid() {
		for() {
			
		}
	}
	
	public void setLife(int damage) {
		this.life += damage;
	}
	
	public static void main(String[] args) {		
		
	}
	
}
