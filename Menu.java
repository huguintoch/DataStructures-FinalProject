//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

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
		
		this.audio = new Sound("MenuSound.wav");

		this.add(new MenuPanel(this), BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public Sound getAudio() {
		return this.audio;
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
	}

}

class MenuPanel extends JPanel {
	 private JButton start;
	 private Image background = new ImageIcon("Menu.png").getImage();
	 private Image btnImage = new ImageIcon("btn_start.png").getImage();
	 private Image btnImageIn = new ImageIcon("btn_start_0.png").getImage();
	 private int width = 130,
			 	 height = 60;
	 
	 public MenuPanel(Menu menu) {
		 super();
		 this.setPreferredSize(new Dimension(1000,680));
		 this.setLayout(null);
		 
		 this.start = new JButton(new ImageIcon("btn_start.png"));
		 this.start.setBounds(220, 420, this.width, this.height);
		 this.start.setBackground(new Color(6,13,14));
		 this.start.setBorderPainted(false);
		 this.start.setRolloverIcon(new ImageIcon("btn_start_0.png"));
		 this.start.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 menu.getAudio().endSound();
				 Window w = new Window();
				 w.setLocation(menu.getLocationOnScreen().x, menu.getLocationOnScreen().y);
				 menu.dispose();
			 }
		 });
		 
		 this.start.setVisible(true);
		 this.add(this.start);
	 }
	 
	 public void paint(Graphics g) {
		 g.drawImage(this.background, 0, 0, 1000, 680, this);
		 
	 }
}