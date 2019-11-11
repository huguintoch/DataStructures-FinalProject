
public class VirusSpawner {
	
	private int life;
	private int[][] location;
	
	public VirusSpawner(Game game) {
		
		this.life = 20;
		
		int[][] location = {{2,2},{2,3},{3,2},{3,3}};
		this.location = location;
		for(int[] cell : this.location) {
			game.setGrid(cell, -1);
		}
		
	}
	
	//Setters & Getters

	public void setLife(int life) {
		this.life = life;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int[][] getLocation() {
		return this.location;
	}

}
