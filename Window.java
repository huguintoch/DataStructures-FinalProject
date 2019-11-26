//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
	
	public Window() {
		super("Moon Defender");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
		
		InfoPanel ip = new InfoPanel();
		
		this.add(new Game(ip, this), BorderLayout.CENTER);
		this.add(ip, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

}
