import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SizePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnSize;
	private JTextField txtX, txtY;
	private int x, y;
	
	public SizePanel()
	{
		btnSize = new JButton("Size");
		txtX = new JTextField("X");
		txtY = new JTextField("Y");
		txtX.setColumns(5);
		txtY.setColumns(5);
		this.add(txtX);
		this.add(txtY);
		this.add(btnSize);
	}
	public void addSizeAction(ActionListener e)
	{
		btnSize.addActionListener(e);
	}
	
	public void setTableX()
	{
		try{
		x = Integer.parseInt(txtX.getText());
		} catch(Exception e){}
	}
	
	public void setTableY()
	{
		try{
		y = Integer.parseInt(txtY.getText());
		} catch(Exception e){}
	}
	
	public int getTableX(){return x;}
	public int getTableY(){return y;}
}
