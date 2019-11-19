import java.awt.*;

public class Node {
	
	private int x, y, width, height, dir;
	private String name;
	
	public Node(int x, int y, String name, int dir) {
		this.x = x;
		this.y = y;
		this.width = 65;
		this.height = 20;
		this.name = name;
		this.dir = dir;
	}
	
	public void paintNode(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, this.width, this.height);
		g.drawString(this.name, this.x+3, this.y+15);
		g.setColor(Color.RED);
		int x_, y_;
		int xSpace = 40;
		int ySpace = 23;
		int arrow = 5;
		if(this.dir == 0) {
			x_ = this.x+this.width+1;
			y_ = this.y+this.height/2;
			g.drawLine(x_, y_, x_+xSpace, y_);
			g.drawLine(x_+xSpace, y_, x_+xSpace-arrow, y_-arrow);
			g.drawLine(x_+xSpace, y_, x_+xSpace-arrow, y_+arrow);
		} else if(this.dir == 1) {
			x_ = this.x;
			y_ = this.y+this.height/2;
			g.drawLine(x_, y_, x_-xSpace, y_);
			g.drawLine(x_-xSpace, y_, x_-xSpace+arrow, y_-arrow);
			g.drawLine(x_-xSpace, y_, x_-xSpace+arrow, y_+arrow);
		} else if(this.dir == 2) {
			x_ = this.x+this.width/2;
			y_ = this.y+this.height+1;
			g.drawLine(x_, y_, x_, y_+ySpace);
			g.drawLine(x_, y_+ySpace, x_-arrow, y_+ySpace-arrow);
			g.drawLine(x_, y_+ySpace, x_+arrow, y_+ySpace-arrow);
		}
	}
}
