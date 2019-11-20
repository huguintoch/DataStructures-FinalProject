import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
	
	public Window() {
		super("Virus");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
		
		InfoPanel ip = new InfoPanel();
		
		this.add(new Game(ip), BorderLayout.CENTER);
		this.add(ip, BorderLayout.EAST);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

}
