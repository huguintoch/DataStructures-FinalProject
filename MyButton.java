import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JButton;

class MyButton extends JButton {

	private Image img;
	private int w, h;

	public MyButton(Image img, int w, int h) {
		super();
		this.setBorder(BorderFactory.createEmptyBorder());
		this.img = img;
		this.w = w;
		this.h = h;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.w, this.h, this);
	}

	public void setImage(Image img) {
		this.img = img;
	}
}
