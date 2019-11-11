import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

	public static final int WIDTH = 1300,
							HEIGHT = 600;
	
	public Window() {
		super("Virus");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
		
		InfoPanel ip = new InfoPanel();
		
		this.add(new Game(ip), BorderLayout.CENTER);
		this.add(ip, BorderLayout.EAST);
		this.add(new StructuresPanel(), BorderLayout.WEST);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Window w = new Window();
	}

}
