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
		this.WINDOW_HEIGHT = 720;
		
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
		for (int i = 0; i < this.cols; i++) {
			for (int j = 0; j < this.rows; j++) {
				x = 8+this.cellSize*i;
				y = 11+this.cellSize*j;
				g.drawRect(x, y, this.cellSize, this.cellSize);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Prueba p = new Prueba();
	}

}
