//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class List <E> extends JFrame implements Runnable {

	private final int DELAY = 50;
	private String name;
	private boolean right = true;
	
	private LinkedList<E> list;
	private int maxSize;
	private LinkedList<Node<E>> nodes;
	
	private int[] pos = {-60, 70};
	private int cont = 0;
	
	private Thread hilo;
	
	private E deadElement;
	
	public List(LinkedList<E> list, String name) {
		super("LikedList of: "+name);	
		this.setSize(390, 240);
		this.setResizable(false);
		
		this.name = name;
		this.list = list;
		this.maxSize = this.list.size();
		this.nodes = new LinkedList<>();
		this.deadElement = null;
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.white);
		for(Node<E> n: this.nodes) {
			n.paintNode(g);
		}
	}
	
	public void update() {
		this.maxSize = Math.max(this.maxSize, this.list.size());
		if(this.list.size() < this.maxSize) {
			//Eliminar nodo
			this.nodes = this.makeNodeList();
			this.maxSize = this.list.size();
		}
		//Agregar nodo
		int dir;
		for(int i = this.nodes.size(); i < this.list.size(); i++) {
			dir = calculateDir(this.nodes.size());
			if(this.nodes.size() != 0) {
				this.nodes.add(new Node<E>(this.pos[0], this.pos[1], name, this.nodes.getLast().getCont()+1, dir, this.list.getLast()));
			} else {
				this.nodes.add(new Node<E>(this.pos[0], this.pos[1], name, 0, dir, this.list.getLast()));
			}
			this.cont++;
		}
	}
	
	private LinkedList<Node<E>> makeNodeList() {
		LinkedList<Node<E>> temp = new LinkedList<>();
		int dir;
		this.cont = 0;
		this.right = true;
		this.pos[0] = -60;
		this.pos[1] = 70;
		for(Node<E> n : this.nodes) {
			if(!n.getId().equals(this.deadElement)) {
				dir = calculateDir(temp.size());
				temp.add(new Node<E>(this.pos[0], this.pos[1], this.name, n.getCont(), dir, n.getId()));
				this.cont++;
			}
		}
		return temp;
	}
	
	private int calculateDir(int listSize) {
		int dir = 0;
		if(listSize % 3 != 0 || listSize == 0) {
			if(this.right) {
				this.pos[0] += 110;
				if(this.cont == 2) {
					dir = 2;
				} else {
					dir = 0;
				}
			} else {
				this.pos[0] -= 110;
				if(this.cont == 2) {
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
		
		return dir;
	}
	
	public void run() {

		long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

		while(true) {
			timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = this.DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 10;
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
	
	public void sendDead(E e) {
		this.deadElement = e;
	}

}
