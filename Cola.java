import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;

public class Cola extends JFrame implements Runnable {
	
	private final int DELAY = 25;
	
	private Queue<Constructor> queue;
	
	private LinkedList<QueueElement> endElements;
	private int maxSize;
	private int type;
	private Thread hilo;
	
	private LinkedList<QueueElement> elements;
	
	public Cola(Queue<Constructor> queue) {
		super("Queue of Constructor");
		this.setSize(390, 300);
		this.setResizable(false);
		this.queue = queue;
		this.elements = new LinkedList<>();
		this.endElements = new LinkedList<>();
		this.maxSize = this.queue.size();
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void paint(Graphics g) {
		try {
			super.paint(g);
			g.drawLine(150, 150, 250, 150);
			g.drawLine(150, 150, 150, 50);
			g.drawLine(250, 150, 250, 50);
			for(QueueElement e : this.elements) {
				e.paintElement(g);
			}
			for(QueueElement e : this.endElements) {
				e.paintElement(g);
			}
			g.setColor(Color.black);
			g.drawString("Added to collectors", 50, 250);
			g.drawString("Added to turrets", 250, 250);
		} catch (ConcurrentModificationException e) {
		}
		
	}
	
	public void update() {
		this.maxSize = Math.max(this.maxSize, this.queue.size());
		if(this.queue.size() < maxSize) {
			LinkedList<QueueElement> temp = new LinkedList<>();
			for(QueueElement e : this.elements) {
				if(!e.equals(this.elements.getFirst())) {
					int y = 150-(temp.size()+1)*30;
					temp.add(new QueueElement(150, y, e.getType()));
				} else {
					this.endElements.add(e);
				}
			}
			this.elements = temp;
			maxSize = this.queue.size();
		}
		if(this.queue.size() > this.elements.size()) {
			int y = 150-(this.elements.size()+1)*30;
			this.elements.add(new QueueElement(150, y, this.type));
		}
		
		try {
			for (QueueElement e: this.endElements) {
				if(e.getType() == 1) {
					if(e.getY() < 230) {
						e.setXY(e.getX()-1, e.getY()+1);
					} else {
						this.endElements.remove(e);
					}
				} else {
					if(e.getY() < 230) {
						e.setXY(e.getX()+1, e.getY()+1);
					} else {
						this.endElements.remove(e);
					}
				}
			}
		} catch(ConcurrentModificationException e) {
			
		}
		
	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
				Thread.sleep(sleep);
				this.update();
				this.repaint();
			} catch (InterruptedException e) {

			}
            beforeTime = System.currentTimeMillis();
		}
	}
	
	public void sendType(int type) {
		this.type = type;
	}
}
