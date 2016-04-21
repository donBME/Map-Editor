import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SaveAction implements ActionListener {
	private TablePanel table;
	private GameFrame game;
	private ToolPanel tools;
	private String fileName;
	
	public SaveAction(TablePanel table,GameFrame game, ToolPanel file)
	{
		this.table = table;
		this.game = game;
		tools = file;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		fileName = tools.getFileName();
		game.setVisible(false);
		game.remove(table);
		FieldMap f = new FieldMap();
		f = table.getFieldMap();
		String[] s;
		String[] bts;
		String[] save = new String[(f.getColumnSize())*(f.getRowSize())*3+2];
		save[0] = String.valueOf(f.getColumnSize());
		save[1] = String.valueOf(f.getRowSize());
		int iter = 2;
		for(int j = 0; j < f.getRowSize(); j++)
			for(int i = 0; i < f.getColumnSize(); i++)
			{
				s = f.getString(i, j).split(",");
				for(int k=0; k < s.length; k++)
				{
					bts = s[k].split(":");
					if(bts[0].equals("bt"))
					{
						save[iter++] = f.GetPair(bts[1]);
						if(bts.length == 3)
							save[iter++] = (bts[0]+";"+i+";"+j+";"+bts[2]);
						else
							save[iter++] = (bts[0]+";"+i+";"+j+";10");
						continue;
					}
					if (bts[0].equals(""))
						bts[0] = "wy";
					if(!bts[0].equals("d"))
						save[iter++] = (bts[0]+";"+i+";"+j);
				}
			}
		try{
			PrintWriter fwriter = new PrintWriter(new FileWriter(new File(fileName+".txt")));
			int i = 0;
			while(save[i]!=null)
			{
				fwriter.println(save[i]);
				i++;
			}
			fwriter.close();
		} catch(Exception e){}
		game.add(table);
		game.setVisible(true);
	}

}
