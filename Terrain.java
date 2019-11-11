
public class Terrain extends Resource {
	
	public Terrain() {
		super();
		this.size = 6+rand.nextInt(3);
	}
	
	public void generateResource(Game game, int x, int y, int n) {
		if(n < this.size) {
			int[] block = {x, y};
			
			int dir = rand.nextInt(4);
			switch(dir) {
				case 0:
					block[0] = (x+1)%Game.COLS;
					block[1] = y;
					break;
				case 1:
					block[0] = x;
					block[1] = (y+1)%Game.ROWS;
					break;
				case 2:
					block[0] = (x+Game.COLS-1)%Game.COLS;
					block[1] = y;
					break;
				case 3:
					block[0] = x;
					block[1] = (y+Game.ROWS-1)%Game.ROWS;
					break;
			}
			
			if(game.getGrid(block) != -2 && game.getGrid(block) != -4 && game.getGrid(block) != -1 && game.getGrid(block) != -6) {
				this.pos.add(block);
				game.setGrid(block, -6);
				this.generateResource(game, block[0], block[1], n+1);
			} else {
				this.generateResource(game, x, y, n+1);
			}
		} else {
			this.size = this.pos.size();
		}
	}
}
