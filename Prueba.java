import javax.swing.*;
import java.awt.*;

public class Prueba extends JFrame {

	private final int WINDOW_WIDTH,
			  		  WINDOW_HEIGHT;
	
	private int cellSize,
				cols,
				rows;
	
	private int[][] grid;
	
	public Prueba() {
		super();
		
		this.WINDOW_WIDTH = 1077;
		this.WINDOW_HEIGHT = 721;
		
		this.setSize(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.cellSize = 10;
		this.cols = this.WINDOW_WIDTH/this.cellSize;
		this.rows = this.WINDOW_HEIGHT/this.cellSize;
		
		this.grid = new int[this.cols][this.rows];
		
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void paint(Graphics g) {
		int x, y;
		updateGrid(6, this.cols/2, this.rows/2);
		for (int i = 0; i < this.cols; i++) {
			for (int j = 0; j < this.rows; j++) {
				if(grid[i][j] == 1) {
					g.setColor(new Color(0, 0, 0));
				} else {
					g.setColor(new Color(240, 240, 240));
				}
				x = 8+this.cellSize*i;
				y = 12+this.cellSize*j;
				g.fillRect(x, y, this.cellSize, this.cellSize);
			}
		}
		
	}
	
	public void updateGrid(int n, int x, int y) {
		grid[x][y] = 1;
		if(n > 1) {
			if(grid[x+1][y] == 0) {
				this.updateGrid(n-1, x+1, y);
			}
			if(grid[x-1][y] == 0) {
				this.updateGrid(n-1, x-1, y);
			}
			if(grid[x][y+1] == 0) {
				this.updateGrid(n-1, x, y+1);
			}
			if(grid[x][y-1] == 0) {
				this.updateGrid(n-1, x, y-1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Prueba p = new Prueba();
	}

}
