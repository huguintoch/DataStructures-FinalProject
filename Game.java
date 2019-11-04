import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Game extends JPanel implements Runnable, MouseListener{
	
	public static final int CELL_SIZE = 10;
	
	private final int DELAY,
					  COLS,
					  ROWS;
	
	private byte[][] grid;
	
	private Thread animator;
	
	public Game() {
		super();
		
		this.DELAY = 100;
		
		this.COLS = Window.WIDTH/Game.CELL_SIZE;
		this.ROWS = Window.HEIGHT/Game.CELL_SIZE;
		
		this.grid = new byte[this.COLS][this.ROWS];
	
		this.addMouseListener(this);
		
		this.animator = new Thread(this);
	    this.animator.start();
	    
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		this.paintGrid(g);
		this.paintVirus(g);
	}
	
	private void paintGrid(Graphics g) {
		g.setColor(new Color(230, 230, 230));
		for (int i = 0; i < this.COLS; i++) {
			g.drawLine(i*Game.CELL_SIZE, 0, i*Game.CELL_SIZE, Window.HEIGHT);
		}
		
		for (int i = 0; i < this.ROWS; i++) {
			g.drawLine(0, i*Game.CELL_SIZE, Window.WIDTH, i*Game.CELL_SIZE);
		}
	}
	
	public void paintVirus(Graphics g) {
		int x, y;
		g.setColor(new Color(0, 0, 0, 150));
		for (int i = 0; i < this.COLS; i++) {
			for (int j = 0; j < this.ROWS; j++) {
				if(grid[i][j] == 1) {
					x = Game.CELL_SIZE*i;
					y = Game.CELL_SIZE*j;
					g.fillRect(x, y, Game.CELL_SIZE, Game.CELL_SIZE);
				} 
			}
		}
	}
	
	public void updateGrid() {
		LinkedList<int[]> cellsToChange = new LinkedList<>();
		for(int i=1; i<this.COLS-1; i++) {
    		for(int j=1; j<this.ROWS-1; j++) {
    			if((grid[i+1][j] == 1 || grid[i-1][j] == 1 || grid[i][j+1] == 1 || grid[i][j-1] == 1) && grid[i][j] != 1) {
    				int[] toAdd = {i,j}; 
    				cellsToChange.add(toAdd);
    			}
    		}
    	}
		
		for (int[] i : cellsToChange) {
			int x = i[0];
			int y = i[1];
			grid[x][y] = 1;
		}
	}
	

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int cont = 0; 
        
        while (true) {

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            
            try {
                Thread.sleep(sleep);
                cont++;
                if(cont%50 == 0) {
                	cont = 0;
                	this.updateGrid();
                }
                this.repaint();
            } catch (InterruptedException e) {
            
            }
            beforeTime = System.currentTimeMillis();
            
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX()/Game.CELL_SIZE;
		int y = e.getY()/Game.CELL_SIZE;
		if(grid[x][y] == 0) {
			grid[x][y] = 1;
		} else {
			grid[x][y] = 0;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
