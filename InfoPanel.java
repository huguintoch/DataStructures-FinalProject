import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

	public static final int WIDTH = 183,
							HEIGHT = 600;
	
	private JLabel money;
	
	public InfoPanel() {
		super();
		this.setPreferredSize(new Dimension(InfoPanel.WIDTH, InfoPanel.HEIGHT));

		this.money = new JLabel("0");
		this.add(this.money);
	}
	
	public void updateMoney(int money) {
		this.money.setText(money+"");
	}

}
