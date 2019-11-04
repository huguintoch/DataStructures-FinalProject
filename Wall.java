public class Wall {
	
	private int life,
	            wallId;
	
	private int[][] gridCells = new int[4][2];
	
	public Wall(int wallId, int x, int y, Game game) {
		
		this.life = 5;
		this.wallId = wallId;
	
		int[] block1 = {x,y};
		this.gridCells[0] = block1;
		int[] block2 = {x+1,y};
		this.gridCells[1] = block2;
		int[] block3 = {x,y+1};
		this.gridCells[2] = block3;
		int[] block4 = {x+1,y+1};
		this.gridCells[3] = block4;
		
		this.updateGrid(game, this.wallId);
	}
	
	public void updateGrid(Game game, int value) {
		for(int[] cell : this.gridCells) {
			game.setGrid(cell, value);
		}
	}
	
	//Setters and Getters
	
	public void setLife(int damage) {
		this.life += damage;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int[][] getGridCells(){
		return this.gridCells;
	}
	
}
