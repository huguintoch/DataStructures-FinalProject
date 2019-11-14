
public class Base {
	
	private int level;
	private int[][] location;
	
	public Base(Game game) {
		this.level = 1;
		int[][] location = {{36,30},{37,30},{36,31},{37,31}};
		this.location = location;
		for(int[] cell : this.location) {
			game.setGrid(cell, -4);
		}
	}
	
	//Setters & Getters
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int[][] getLocation() {
		return this.location;
	}

}
