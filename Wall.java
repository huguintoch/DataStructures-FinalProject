public class Wall {
	
	private int life,
	            wallId;
	
	private int[][] gridCells;
	
	public Wall(int wallId, int type, int x, int y, Game game) {
		
		if(type == 2) {
			
			this.life = 15;
			this.wallId = wallId;
			
			int[][] gridCells = {{x,y},{x+1,y},{x,y+1},{x+1,y+1}};
			this.gridCells = gridCells;
			
		}else {
			
			this.life = 7;
			this.wallId = wallId;
			
			int[][] gridCells = {{x,y}};
			this.gridCells = gridCells;
			
		}
		
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
