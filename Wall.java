public class Wall {
	
	private int life,
	            wallId;
	
	private int[][] gridCells;
	
	public Wall(int wallId, int type, int x, int y, Game game) {
		
		if(type == 2) {
			this.gridCells = new int[4][2];
			this.life = 15;
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
		}else {
			this.gridCells = new int[1][2];
			this.life = 7;
			this.wallId = wallId;
			
			int[] block1 = {x,y};
			this.gridCells[0] = block1;
			
			this.updateGrid(game, this.wallId);
		}
		
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
