import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class FvText extends JTextField implements KeyListener{

	private static final long serialVersionUID = 1L;
	private FieldText field;
	
	public void setField(FieldText field)
	{
		this.field = field;
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		field.setText(""+this.getText()+""+arg0.getKeyChar());
		field.setColor();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
