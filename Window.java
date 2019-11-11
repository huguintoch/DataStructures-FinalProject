import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

	public static final int WIDTH = 1300,
							HEIGHT = 720;
	
	public Window() {
		super("Virus");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
		this.pack();
		
		this.add(new Game(), BorderLayout.CENTER);
		this.add(new InfoPanel(), BorderLayout.EAST);
		this.add(new StructuresPanel(), BorderLayout.WEST);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Window w = new Window();
	}

}
