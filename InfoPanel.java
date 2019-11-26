//Autores: Guillermo Tanamachi A01631327 & Hugo Valdez A01631301
//Fecha: 25/11/2019

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class InfoPanel extends JPanel {

	public static final int WIDTH = 200,
							HEIGHT = 680;
	
	private JLabel money,
			       level,
			       wallLabel,
			       collectorLabel,
			       turretLabel,
			       baseLabel,
			       cureLabel;
	
	private JButton btnCollector;
	private JButton btnTurrets;
	private JButton btnConstructors;
	private JButton btnDebug;
	
	private List<Collector> listCollectors;
	private List<Turret> listTurrets;
	
	private Cola queueConstructors;
	
	private SpriteManager spriteManager;
	
	private Game game;
	
	public InfoPanel() {
		super();
		this.setPreferredSize(new Dimension(InfoPanel.WIDTH, InfoPanel.HEIGHT));
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new GridLayout(7, 1));
		
		this.spriteManager = new SpriteManager();

		// Import Font
		try {
			Font newFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("m5x7.TTF").openStream());
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(newFont);
			UIManager.put("Label.font", newFont.deriveFont(45f));
		} catch (FontFormatException e) {
			System.out.println("Error de formato");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error mayor");
			e.printStackTrace();
		}
	
		//Info
		JPanel info = new JPanel();
		info.setSize(new Dimension(180,80));
		info.setBackground(Color.DARK_GRAY);
		info.setLayout(new GridLayout(2,2));
		
		this.money = new JLabel("0");
		this.level = new JLabel("1");
		this.money.setForeground(Color.WHITE);
		this.level.setForeground(Color.WHITE);
		this.money.setHorizontalAlignment(JLabel.CENTER);
		this.level.setHorizontalAlignment(JLabel.CENTER);
		
		info.add(new JLabel(new ImageIcon("bigResource.png")));
		info.add(new JLabel(new ImageIcon(this.spriteManager.getBaseSprite())));
		info.add(this.money);
		info.add(this.level);
		this.add(info);
		
		//Item labels
		this.wallLabel = new JLabel(new ImageIcon(this.spriteManager.getWallPanel()[1]));
		this.collectorLabel = new JLabel(new ImageIcon(this.spriteManager.getCollectorPanel()[0]));
		this.turretLabel = new JLabel(new ImageIcon(this.spriteManager.getTurretPanel()[1]));
		this.baseLabel = new JLabel(new ImageIcon(this.spriteManager.getBasePanel()[1]));
		this.cureLabel = new JLabel(new ImageIcon(this.spriteManager.getCurePanel()[0]));
		
		this.add(wallLabel);
		this.add(collectorLabel);
		this.add(turretLabel);
		this.add(baseLabel);
		this.add(cureLabel);

		//Structures Labels
		
		JPanel structures = new JPanel();
		structures.setSize(new Dimension(180,80));
		structures.setBackground(Color.DARK_GRAY);
		structures.setLayout(new GridLayout(2,2));
		
		this.btnCollector = new JButton(new ImageIcon("btnCollector.png"));
		this.btnCollector.setBackground(Color.DARK_GRAY);
		this.btnCollector.setBorderPainted(false);
		this.btnCollector.setRolloverIcon(new ImageIcon("btnCollectorS.png"));
		this.btnCollector.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listCollectors.setVisible(true);
			}
			
		} );
		
		this.btnTurrets = new JButton(new ImageIcon("btnTurrets.png"));
		this.btnTurrets.setBackground(Color.DARK_GRAY);
		this.btnTurrets.setBorderPainted(false);
		this.btnTurrets.setRolloverIcon(new ImageIcon("btnTurretsS.png"));
		this.btnTurrets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listTurrets.setVisible(true);
			}
			
		} );
		
		this.btnConstructors = new JButton(new ImageIcon("btnConstructor.png"));
		this.btnConstructors.setBackground(Color.DARK_GRAY);
		this.btnConstructors.setBorderPainted(false);
		this.btnConstructors.setRolloverIcon(new ImageIcon("btnConstructorS.png"));
		this.btnConstructors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				queueConstructors.setVisible(true);
			}
			
		} );
		
		this.btnDebug = new JButton(new ImageIcon("btnDebug.png"));
		this.btnDebug.setBackground(Color.DARK_GRAY);
		this.btnDebug.setBorderPainted(false);
		this.btnDebug.setRolloverIcon(new ImageIcon("btnDebugS.png"));
		this.btnDebug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.setDebugPaint(!game.getDebugPaint());
			}
			
		} );

		structures.add(this.btnCollector);
		structures.add(this.btnTurrets);
		structures.add(this.btnConstructors);
		structures.add(this.btnDebug);
		
		this.add(structures);
		
	}
	
	public void update(int level, int state) {
		if(level == 1){
			switch (state) {
			case 1:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[1]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[0]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[0]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[0]));
				break;
			case 2:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[1]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[0]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[0]));
				break;
			case 3:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[0]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[1]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[0]));
				break;
			case 4:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[0]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[0]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[1]));
				break;
			default:
				break;
			}
		}else if(level == 2) {
			switch (state) {
			case 1:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[1]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[2]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[2]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[2]));
				break;
			case 2:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[3]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[2]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[2]));
				break;
			case 3:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[2]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[3]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[2]));
				break;
			case 4:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[2]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[2]));
				this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[3]));
				break;
			default:
				break;
			}
		}else {
			this.cureLabel.setIcon(new ImageIcon(spriteManager.getCurePanel()[1]));
			this.baseLabel.setIcon(new ImageIcon(spriteManager.getBasePanel()[4]));
			switch (state) {
			case 1:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[1]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[4]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[4]));
				break;
			case 2:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[5]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[4]));
				break;
			case 3:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[4]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[5]));
				break;
			case 4:
				this.wallLabel.setIcon(new ImageIcon(spriteManager.getWallPanel()[0]));
				this.collectorLabel.setIcon(new ImageIcon(spriteManager.getCollectorPanel()[4]));
				this.turretLabel.setIcon(new ImageIcon(spriteManager.getTurretPanel()[4]));
				break;
			default:
				break;
			}
		}
	}
	
	public void updateMoney(int money) {
		this.money.setText(money+"");
	}
	
	public void updateLevel(int level) {
		this.level.setText(level+"");
	}
	
	public void sendCollectors(LinkedList<Collector> collectors) {
		this.listCollectors = new List<>(collectors, "Collector");
	}
	
	public void sendDeadCollector(Collector e) {
		this.listCollectors.sendDead(e);
	}
	
	public void sendTurrets(LinkedList<Turret> turrets) {
		this.listTurrets = new List<>(turrets, "Turret");
	}
	
	public void sendDeadTurret(Turret e) {
		this.listTurrets.sendDead(e);
	}
	
	public void sendConstructors(Queue<Constructor> constructors) {
		this.queueConstructors = new Cola(constructors);
	}
	
	public void sendType(int type) {
		this.queueConstructors.sendType(type);
	}
	
	public List<Collector> getCollectorList() {
		return this.listCollectors;
	}  
	
	public List<Turret> getTurretList() {
		return this.listTurrets;
	}  
	
	public Cola getQueue() {
		return this.queueConstructors;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

}
