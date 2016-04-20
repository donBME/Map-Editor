import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoadAction implements ActionListener{
	private TablePanel table;
	private GameFrame game;
	private ToolPanel fileName;
	
	public LoadAction(TablePanel table,GameFrame game, ToolPanel fileName)
	{
		this.game = game;
		this.table = table;
		this.fileName = fileName; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		FieldMap map = new FieldMap();
		String s;
		String[] objs;
		FieldText  text;
		int x,  y;
		game.setVisible(false);
		game.remove(table);
		try{
			BufferedReader read = new BufferedReader(new FileReader(fileName.getFileName()+".txt"));
			map.init(Integer.parseInt(read.readLine()),Integer.parseInt(read.readLine()));
			while((s = read.readLine())!= null)
			{
				objs = s.split(";");
				x = Integer.parseInt(objs[1]);
				y = Integer.parseInt(objs[2]);
				text = new FieldText(x, y);
				if(map.isThere(x, y))
					text.setText(map.getString(y, x)+","+objs[0]);
				else
					text.setText(objs[0]);
				map.add(x, y, text);
			}
			read.close();
		}catch(Exception e1){}
		
		table.Load(map);
		game.add(table);
		game.setVisible(true);
	}
}
