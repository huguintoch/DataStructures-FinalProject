import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.*;

public class Menu extends JFrame {

	private JButton btnStart;
	
	private JPanel panel;
	
	private Sound audio;
	
	public Menu() {
		super("Moon Defender");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		this.add(new MenuPanel(this), BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		this.audio = new Sound("MenuSound.wav");
	}
	
	public Sound getAudio() {
		return this.audio;
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
	}

}

class MenuPanel extends JPanel {
	 private MyButton start;
	 private Image background = new ImageIcon("Menu.png").getImage();
	 private Image btnImage = new ImageIcon("btn_start.png").getImage();
	 private Image btnImageIn = new ImageIcon("btn_start_0.png").getImage();
	 private int width = 130,
			 	 height = 60;
	 
	 public MenuPanel(Menu menu) {
		 super();
		 this.setPreferredSize(new Dimension(1000,680));
		 this.setLayout(null);
		 
		 this.start = new MyButton(this.btnImage, this.width, this.height);
		 this.start.setBounds(220, 420, this.width, this.height);
		 
		 this.start.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 menu.getAudio().endSound();
				 Window w = new Window();
				 w.setLocation(menu.getLocationOnScreen().x, menu.getLocationOnScreen().y);
				 menu.dispose();
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