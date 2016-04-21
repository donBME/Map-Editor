import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToolPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnSave, btnLoad;
	private JTextField SavefileName;
	private JLabel Way, Wall, Box, Abyss, Player, Button, Door, ZPM, Jaffa, Replicator,special, where;
	public ToolPanel(TablePanel table)
	{
		SavefileName = new JTextField("file name");
		SavefileName.setColumns(10);
		
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		this.add(SavefileName, BorderLayout.CENTER);
		this.add(btnSave, BorderLayout.CENTER);
		this.add(btnLoad,BorderLayout.CENTER);
		this.setLayout(new GridLayout(0, 1));
		Player = new JLabel("PLAYER: p - blue");
		Jaffa = new JLabel("JAFFA: j - blue");	
		Replicator = new JLabel("REPLICATOR: r - gray");	
		Abyss = new JLabel("ABYSS: a - black");
		ZPM = new JLabel("ZPM: z - green");
		Way = new JLabel("WAY: wy - white");
		Wall = new JLabel("WALL: wl - red");
		Box = new JLabel("BOX: bx - orange");
		Button = new JLabel("BUTTON: bt:N:K - white");
		Door = new JLabel("DOOR: d:N - white");
		special = new JLabel("SPECIAL: sw - pink");
		where = new JLabel("N - association, K - weight");
		
		this.add(Player);
		this.add(Jaffa);
		this.add(Replicator);
		this.add(Abyss);
		this.add(ZPM);
		this.add(Way);
		this.add(Wall);
		this.add(Box);
		this.add(Button);
		this.add(Door);
		this.add(special);
		this.add(where);
	}
	
	public String getFileName(){return SavefileName.getText();}
	
	public void addSaveAction(ActionListener e)
	{
		btnSave.addActionListener(e);
	}
	
	public void addLoadAction(ActionListener e)
	{
		btnLoad.addActionListener(e);
	}
}
