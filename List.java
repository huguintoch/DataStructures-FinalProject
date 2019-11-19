import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class List <E> extends JFrame implements Runnable {

	private final int DELAY = 50;
	private String name;
	private boolean right = true;
	private LinkedList<E> list;
	private LinkedList<Node> nodes;
	private int[] pos = {-60, 70};
	private int cont = 0;
	private Thread hilo;
	
	public List(LinkedList<E> list, String name) {
		super("LikedList of: "+name);	
		this.setSize(500, 500);
		
		this.name = name;
		this.list = list;
		this.nodes = new LinkedList<>();
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.white);
		for(Node n: this.nodes) {
			n.paintNode(g);
		}
	}
	
	public void update() {
		int dir;
		for(int i = this.nodes.size(); i < this.list.size(); i++) {
			if(this.nodes.size() % 4 != 0 || this.nodes.size() == 0) {
				if(this.right) {
					this.pos[0] += 110;
					if(this.cont == 3) {
						dir = 2;
					} else {
						dir = 0;
					}
				} else {
					this.pos[0] -= 110;
					if(this.cont == 3) {
						dir = 2;
					} else {
						dir = 1;
					}
				}
			} else {
				this.cont = 0;
				this.pos[1] += 50;
				this.right = !this.right;
				if(this.right) {
					dir = 0;
				} else {
					dir = 1;
				}
			}
			this.nodes.add(new Node(this.pos[0], this.pos[1], name+" "+this.nodes.size(), dir));
			cont++;
		}
	}
	
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

}
