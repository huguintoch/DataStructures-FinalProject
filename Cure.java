public class Cure {
	
	private int size;
	
	public Cure(int size, int x, int y, Game game) {
		this.size = size;
		this.updateGrid(game, this.getCellsToCure(x,y));
	}
	
	private int[][] getCellsToCure(int x, int y) {
		int cont = 0;
		int[][] cellsToCure = new int[this.size*this.size][2];
		for(int i=0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				int[] tmp = {x+i,y+j};
				cellsToCure[cont] = tmp;
				cont++;
			}
		}
		return cellsToCure;
	}
	
	public void updateGrid(Game game, int[][] cells) {
		for(int[] cell : cells) {
			game.setGrid(cell, 0);
		}
	}

}
