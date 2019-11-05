import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Game extends JPanel implements Runnable, MouseListener, KeyListener{

	public static final int CELL_SIZE = 10,
							COLS = (Window.WIDTH-10)/Game.CELL_SIZE, 
							ROWS = (Window.HEIGHT-10)/Game.CELL_SIZE-3;
	
	private final int DELAY;
					  
	private int state;
	private int[][] grid;
	
	private int money;

	private Hashtable<Integer, Wall> walls;
	private Resource[] resources;
	private LinkedList<Collector> collectors;
	
	private JButton keyInput;

	private Thread animator;
	
	public Game() {
		super();

		this.DELAY = 50;
		
		this.state = 3;
		this.grid = new int[COLS][ROWS];
		this.grid[105][67] = -1;
		
		this.walls = new Hashtable<>();
		
		this.resources = new Resource[1];
	    Random rand = new Random();
	    int x, y;
	    for (int i = 0; i < this.resources.length; i++) {
			x = rand.nextInt(COLS);
			y = rand.nextInt(ROWS);
			this.resources[i] = new Resource();
			this.resources[i].generateResource(this, x, y, 0);
		}
	    
	    this.collectors = new LinkedList<>();
	    
	    this.money = 0;

		this.addMouseListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);

		this.animator = new Thread(this);
	    this.animator.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		this.paintGrid(g);
		this.paintResources(g);
		this.paintCollectors(g);
		this.paintVirus(g);
		this.paintWalls(g);
	}

	private void paintGrid(Graphics g) {
		g.setColor(new Color(230, 230, 230));
		for (int i = 0; i < COLS; i++) {
			g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, Window.HEIGHT);
		}
		for (int i = 0; i < ROWS; i++) {
			g.drawLine(0, i*CELL_SIZE, Window.WIDTH, i*CELL_SIZE);
		}
	}

	public void paintVirus(Graphics g) {
		int x, y;
		g.setColor(new Color(0, 0, 0, 100));
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				if(grid[i][j] == -1) {
					x = Game.CELL_SIZE*i+1;
					y = Game.CELL_SIZE*j+1;
					g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
				}
			}
		}
	}

	public void paintWalls(Graphics g) {
		g.setColor(new Color(0, 0, 255, 150));
		int x, y;
		int[][] cells;
		Set<Integer> keys = walls.keySet();
		for(Integer key : keys) {
			cells = walls.get(key).getGridCells();
			for(int[] cell : cells) {
				x = CELL_SIZE*cell[0]+1;
				y = CELL_SIZE*cell[1]+1;
				g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
			}
		}
	}
	
	public void paintResources(Graphics g) {
		g.setColor(new Color(255, 255, 0, 170));
		int cell[][];
		int x, y;
		for (int i = 0; i < this.resources.length; i++) {
			cell = this.resources[i].getGridCells();
			for (int j = 0; j < cell.length; j++) {
				x = CELL_SIZE*cell[j][0];
				y = CELL_SIZE*cell[j][1];
				g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
			}
		}	
	}
	
	public void paintCollectors(Graphics g) {	
		int x, y;
		int[][] cells;
		
		for(Collector c : this.collectors) {
			c.paintCollectorArea(g);
			cells = c.getGridCells();
			for(int[] cell : cells) {
				g.setColor(new Color(255, 0, 255, 150));
				x = CELL_SIZE*cell[0];
				y = CELL_SIZE*cell[1];
				g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
			}
		}
	}

	public void updateGrid() {
		LinkedList<int[]> cellsToChange = new LinkedList<>();
		for(int i=0; i<COLS; i++) {
    		for(int j=0; j<ROWS; j++) {
    			if(i == 0 && j == 0) {
    				if((grid[i+1][j] == -1 || grid[i][j+1] == -1) && grid[i][j] != -1) {
        				this.update(i, j, cellsToChange);
        			}
    			} else if(i == 0 && j == ROWS-1) {
    				if((grid[i+1][j] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
        				this.update(i, j, cellsToChange);
        			}
    			} else if (i == COLS-1 && j == 0) {
    				if((grid[i-1][j] == -1 || grid[i][j+1] == -1) && grid[i][j] != -1) {
        				this.update(i, j, cellsToChange);
        			}
    			} else if (i == COLS-1 && j == ROWS-1) {
    				if((grid[i-1][j] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			} else if (i == 0) {
    				if((grid[i+1][j] == -1 || grid[i][j+1] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			} else if (j == 0) {
    				if((grid[i+1][j] == -1 || grid[i-1][j] == -1 || grid[i][j+1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			} else if (i == COLS-1) {
    				if((grid[i-1][j] == -1 || grid[i][j+1] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			} else if (j == ROWS-1) {
    				if((grid[i+1][j] == -1 || grid[i-1][j] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			} else {
    				if((grid[i+1][j] == -1 || grid[i-1][j] == -1 || grid[i][j+1] == -1 || grid[i][j-1] == -1) && grid[i][j] != -1) {
    					this.update(i, j, cellsToChange);
        			}
    			}
    		}
    	}

		for (int[] i : cellsToChange) {
			int x = i[0];
			int y = i[1];
			grid[x][y] = -1;
		}
	}
	
	public void update(int i, int j, LinkedList<int[]> cellsToChange) {
		if(grid[i][j]<1) {
			int[] toAdd = {i,j};
			cellsToChange.add(toAdd);
		} else {
			this.walls.get(grid[i][j]).setLife(-1);
			if(this.walls.get(grid[i][j]).getLife() == 0) {
				int tmp = grid[i][j];
				this.walls.get(grid[i][j]).updateGrid(this,0);
				this.walls.remove(tmp);
			}
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
                	for (Collector c : this.collectors) {
						this.money += c.collect(this);
					}
                	//System.out.println(this.money);
                	this.updateGrid();
                }
                this.repaint();
            } catch (InterruptedException e) {

            }
            beforeTime = System.currentTimeMillis();

        }
    }

    //MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX()/CELL_SIZE;
		int y = e.getY()/CELL_SIZE;

		switch (this.state) {
		case 1:
			if(grid[x][y] == 0) {
				grid[x][y] = -1;
			}else {
				grid[x][y] = 0;
			}
			break;
		case 2:
			if(x+1 < COLS && y+1 < ROWS) {
				if(grid[x][y] == 0 && grid[x+1][y] == 0 && grid[x][y+1] == 0 && grid[x+1][y+1] == 0) {
					this.walls.put(Integer.valueOf(this.walls.size()+1), new Wall(this.walls.size()+1, x, y, this));
				}
			}
			break;
		case 3:
			if(x+1 < COLS && y+1 < ROWS) {
				if(grid[x][y] == 0 && grid[x+1][y] == 0 && grid[x][y+1] == 0 && grid[x+1][y+1] == 0) {
					this.collectors.add(new Collector(x, y, this));
				}
			}	
			break;
		default:
			break;
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

	//KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_1) {
			this.state = 1;
		} else if(key == KeyEvent.VK_2) {
			this.state = 2;
		} else if(key == KeyEvent.VK_3) {
			this.state = 3;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}
	
	//Setters and Getters
	public void setGrid(int[] cell, int val) {
		grid[cell[0]][cell[1]] = val;
	}

	public int getGrid(int[] cell) {
		return grid[cell[0]][cell[1]];
	}

}
