import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

	public static final int WIDTH = 183,
							HEIGHT = 600;
	
	private JLabel money,
			       level;
	
	public InfoPanel() {
		super();
		this.setPreferredSize(new Dimension(InfoPanel.WIDTH, InfoPanel.HEIGHT));
		this.setLayout(new GridLayout(1, 2));
		
		this.money = new JLabel("0");
		this.level = new JLabel("1");
		
		this.money.setHorizontalAlignment(JLabel.CENTER);
		this.level.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(this.money);
		this.add(this.level);
	}
	
	public void updateMoney(int money) {
		this.money.setText(money+"");
	}
	
	public void updateLevel(int level) {
		this.level.setText(level+"");
	}

}
