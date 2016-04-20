import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private SizePanel sizep; 
	private TablePanel table;
	private ToolPanel tools;
	private FvText fv;
	
	public void Show()
	{
		this.setTitle("Don Game Designer");
		this.setSize(1280, 720);
		
		Font font = new Font("ComicSans", Font.BOLD, 30);
		fv = new FvText();
		fv.addKeyListener(fv);
		fv.setFont(font);
		tools = new ToolPanel(table);
		table = new TablePanel(fv);
		sizep = new SizePanel();
		sizep.addSizeAction(this);
		
		tools.addSaveAction(new SaveAction(table, this, tools));
		tools.addLoadAction(new LoadAction(table, this, tools));
		
		this.add(sizep, BorderLayout.NORTH);
		this.add(table, BorderLayout.CENTER);
		this.add(tools, BorderLayout.EAST);
		this.add(fv,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		sizep.setTableX();
		sizep.setTableY();
		this.remove(table);
		table.reGrid(sizep.getTableX(), sizep.getTableY());
		this.add(table);
		this.setVisible(true);
	}
}
