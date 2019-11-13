import java.awt.Color;
import java.awt.Graphics;

public class Constructor implements Runnable {
	
	private final int DELAY = 50;
	
	private int x,
				y,
				type;
	
	private Game game;
	
	private Thread hilo;
	
	private boolean done = false;
	
	public Constructor(int x, int y, int type, Game game) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.game = game;
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void paintConstructor(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(this.x, this.y, Game.CELL_SIZE, Game.CELL_SIZE);
	}
	
	public boolean isDead() {
		return this.done;
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        int cont = 0;

		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
				Thread.sleep(sleep);
				cont++;
				if(cont%30 == 0) {
					this.done = true;
				}
			} catch (InterruptedException e) {

			}
            beforeTime = System.currentTimeMillis();
		}
	}
	
}
