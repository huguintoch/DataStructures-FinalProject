public class Wall {
	
	private int life,
	            wallId;
	
	private int[][] gridCells = new int[4][2];
	
	public Wall(int wallId, int x, int y, Game game) {
		
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
		
		this.updateGrid(game, this.wallId);
	}
	
	public void updateGrid(Game game, int value) {
		for(int[] cell : this.gridCells) {
			game.setGridCell(cell, value);
		}
	}
	
	public void setLife(int damage) {
		this.life += damage;
	}
	
	public int getLife() {
		return this.life;
	}
	
}
