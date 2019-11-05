
public class Cure {
	
	private int type;
	
	public Cure(int type, int x, int y, Game game) {
		this.type = type;
		this.updateGrid(game, this.getCellsToCure(x,y));
	}
	
	private int[][] getCellsToCure(int x, int y) {
		int[][] cellsToCure;
		switch (this.type) {
		case 1:
			cellsToCure = new int[4][2];
			int[] block1 = {x,y};
			cellsToCure[0] = block1;
			int[] block2 = {x+1,y};
			cellsToCure[1] = block2;
			int[] block3 = {x,y+1};
			cellsToCure[2] = block3;
			int[] block4 = {x+1,y+1};
			cellsToCure[3] = block4;
			return cellsToCure;
		case 2:
			
		default:
			int[][] def = {{0,0},{1,1}};
			return def;
		}
	}
	
	public void updateGrid(Game game, int[][] cells) {
		for(int[] cell : cells) {
			game.setGrid(cell, 0);
		}
	}

}
