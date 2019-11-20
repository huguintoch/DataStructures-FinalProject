import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinalScreen extends JFrame {
private JButton btnStart;
	
	private JPanel panel;
	
	public FinalScreen() {
		super("Moon Defender");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(new FinalScreenPanel(this), BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
	}

}

class FinalScreenPanel extends JPanel {
	 private MyButton start;
	 private Image background = new ImageIcon("WIN.png").getImage();
	 private Image btnImage = new ImageIcon("btn_retry.png").getImage();
	 private Image btnImageIn = new ImageIcon("btn_retry_0.png").getImage();
	 private int width = 130,
			 	 height = 60;
	 
	 public FinalScreenPanel(FinalScreen finalScreen) {
		 super();
		 this.setPreferredSize(new Dimension(1000,680));
		 this.setLayout(null);
		 
		 this.start = new MyButton(this.btnImage, this.width, this.height);
		 this.start.setBounds(220, 420, this.width, this.height);
		 
		 this.start.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 Window w = new Window();
				 w.setLocation(finalScreen.getLocationOnScreen().x, finalScreen.getLocationOnScreen().y);
				 finalScreen.dispose();
			 }

			 @Override
			 public void mouseEntered(MouseEvent e) {
				 start.setImage(btnImageIn);
			 }

			 @Override
			 public void mouseExited(MouseEvent e) {
				 start.setImage(btnImage);
			 }
		 });
		 
		 this.start.setVisible(true);
		 this.add(this.start);
	 }
	 
	 public void paint(Graphics g) {
		 g.drawImage(this.background, 0, 0, 1000, 680, this);
		 
	 }
}
