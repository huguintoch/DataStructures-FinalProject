import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Prueba extends JPanel implements Runnable{

	private final int WINDOW_WIDTH,
			  		  WINDOW_HEIGHT,
			  		  DELAY;
	
	private Thread animator;
	
	private int cellSize,
				cols,
				rows;
	
	private int[][] grid;
	
	public Prueba() {
		super();
		
		this.WINDOW_WIDTH = 1080;
		this.WINDOW_HEIGHT = 720;
		this.DELAY = 1000;
		
		this.setSize(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		
		this.cellSize = 10;
		this.cols = this.WINDOW_WIDTH/this.cellSize;
		this.rows = this.WINDOW_HEIGHT/this.cellSize;
		
		this.grid = new int[this.cols][this.rows];
		
		this.grid[70][35] = 1;
		
		this.animator = new Thread(this);
	    this.animator.start();
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.paintVirus(g);
	}
	
	public void paintVirus(Graphics g) {
		int x, y;
		for (int i = 0; i < this.cols; i++) {
			for (int j = 0; j < this.rows; j++) {
				if(grid[i][j] == 1) {
					g.setColor(new Color(0, 0, 0));
				} else {
					g.setColor(new Color(240, 240, 240));
				}
				x = this.cellSize*i;
				y = this.cellSize*j;
				g.fillRect(x, y, this.cellSize, this.cellSize);
			}
		}
	}
	
	public void updateGrid() {
		ArrayList<int[]> cellsToChange = new ArrayList<>();
		for(int i=1; i<this.cols-1; i++) {
    		for(int j=1; j<this.rows-1; j++) {
    			if(grid[i+1][j] == 1 || grid[i-1][j] == 1 || grid[i][j+1] == 1 || grid[i][j-1] == 1) {
    				int[] toAdd = {i,j}; 
    				cellsToChange.add(toAdd);
    			}
    		}
    	}
		for(int i=0; i<cellsToChange.size(); i++) {
			this.grid[cellsToChange.get(i)[0]][cellsToChange.get(i)[1]] = 1;
		}
	}
	

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (true) {

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
                this.updateGrid();
                this.repaint();
            } catch (InterruptedException e) {
            
            }
            beforeTime = System.currentTimeMillis();
            
        }
    }
	
	public static void main(String[] args) {
		
		Prueba p = new Prueba();
		
		JFrame jf = new JFrame();
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1077, 721);
		jf.setVisible(true);
		jf.add(p);

	}

}
