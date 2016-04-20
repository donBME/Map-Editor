import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class FieldText extends JTextField implements MouseListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private int x, y;
	private FvText fv;
	
	public FieldText(int X, int Y)
	{
		x = X; y = Y;
	}
	public FieldText(int X, int Y, String s, FvText field)
	{
		fv = field;
		x = X; y = Y;
		this.setText(s);
	}
	public void addFv(FvText txt){fv = txt;}
	public int getX(){return x;}
	public int getY(){return y;}
	public void setColor()
	{
		String[] s = this.getText().split(",");
		if (s.length == 1)
		{
			this.setBackground(Color.WHITE);
			this.setForeground(Color.BLACK);
		}
		for (int i = 0; i < s.length; i++)
		{
			switch(s[i])
			{
				case "p": this.setBackground(Color.BLUE);
						  this.setForeground(Color.WHITE);break;
				case "j": this.setBackground(Color.BLUE);
						  this.setForeground(Color.WHITE);break;
				case "r": this.setBackground(Color.GRAY);
						  this.setForeground(Color.WHITE);break;
				case "a": this.setBackground(Color.BLACK);
						  this.setForeground(Color.WHITE);break;
				case "z": this.setBackground(Color.GREEN);
						  this.setForeground(Color.BLACK);break;
				case "wl": this.setBackground(Color.RED);
						   this.setForeground(Color.WHITE);break;
				case "sw": this.setBackground(Color.PINK);
						   this.setForeground(Color.BLACK);break;
				case "bx": this.setBackground(Color.ORANGE);
						   this.setForeground(Color.WHITE);break;
				case "wy": this.setBackground(Color.WHITE);
						   this.setForeground(Color.BLACK);break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		fv.setField(this);
		fv.setText(this.getText());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		fv.setText(""+this.getText()+""+e.getKeyChar());
		this.setColor();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
