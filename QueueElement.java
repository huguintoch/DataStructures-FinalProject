import java.awt.*;

public class QueueElement {
	private int x, y, width, height, type;
	
	public QueueElement(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 30;
		this.type = type;
	}
	
	public void paintElement(Graphics g) {
		if(this.type == 1) {
			g.setColor(new Color(255, 0, 255, 100));
			g.fillRect(this.x, this.y, this.width, this.height);
			g.setColor(Color.black);
			g.drawString("Constructor", this.x+17, this.y+20);
		} else {
			g.setColor(new Color(255, 160, 0, 100));
			g.fillRect(this.x, this.y, this.width, this.height);
			g.setColor(Color.black);
			g.drawString("Turret", this.x+25, this.y+20);
		}
		
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getType() {
		return this.type;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
