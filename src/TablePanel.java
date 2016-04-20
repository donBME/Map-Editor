import java.awt.GridLayout;
import javax.swing.JPanel;

public class TablePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private FieldMap map;
	private int x,y;
	private FvText fv;
	public TablePanel (FvText fv)
	{
		this.fv = fv;
		map = new FieldMap();
		this.reGrid(20, 20);
	
	}

	public void reGrid(int x,int y)
	{
		this.x = x; this.y = y;
		this.removeAll();
		this.setLayout(new GridLayout(y, x));
		map.init(x, y);
		for (int j = 0; j < x; j++)
			for (int i = 0; i < y; i++)
		{
			FieldText text = new FieldText(i, j, "wl", fv);
			text.addMouseListener(text);
			text.addKeyListener(text);
			text.setColor();
			map.add(i, j, text);
			this.add(text);
		}
	}
	
	public void Load(FieldMap fmap)
	{
		y = fmap.getRowSize();
		x = fmap.getColumnSize();
		this.removeAll();
		this.setLayout(new GridLayout(x, y));
		for(int i = 0; i < y; i++)
			for(int j = 0; j < x; j++)
			{		
				FieldText field = fmap.getObject(i, j);
				field.addFv(fv);
				field.addMouseListener(field);
				field.addKeyListener(field);
				field.setColor();
				this.add(field);
			}
	}
	
	public FieldMap getFieldMap()
	{
		return map;
	}
}
