public class Wall {
	
	private int life,
	            wallId;
	
	private int[] gridCell;
	
	public Wall(int wallId, int x, int y, Game game) {

		this.life = 7;
		this.wallId = wallId;
		
		int[] gridCell = {x,y};
		this.gridCell = gridCell;
			
		game.setGrid(this.gridCell, this.wallId);
		
	}
	
	//Setters and Getters
	
	public void setLife(int damage) {
		this.life += damage;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int[] getGridCell(){
		return this.gridCell;
	}
	
}
