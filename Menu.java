import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Menu extends JFrame {

	private JButton btnStart;
	
	public Menu() {
		super("Virus");
		this.setPreferredSize(new Dimension(1010,710));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		this.btnStart = new JButton("Start");
		this.btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window w = new Window();
				dispose();
			}
			
		});
		
		this.add(this.btnStart);
		
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
	}

}
