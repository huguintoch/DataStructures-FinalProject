import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class InfoPanel extends JPanel {

	public static final int WIDTH = 183,
							HEIGHT = 600;
	
	private JLabel money,
			       level;
	
	private JButton btn1;
	
	private List<Collector> list;
	
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
		
		this.btn1 = new JButton("Lista");
		this.btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list.setVisible(true);
			}
			
		} );
		this.add(this.btn1);
	}
	
	public void updateMoney(int money) {
		this.money.setText(money+"");
	}
	
	public void updateLevel(int level) {
		this.level.setText(level+"");
	}
	
	public void sendList(LinkedList<Collector> collector) {
		this.list = new List<>(collector, "Collector");
	}

}
