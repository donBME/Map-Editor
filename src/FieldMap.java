import java.io.Serializable;

public class FieldMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private int sizeX=0,sizeY=0;
	private FieldText[][] obj;

	public void init(int y, int x)
	{
		obj = new FieldText[x][y];
		sizeX = x; sizeY = y;
	}
	public void add(int x, int y, FieldText s)
	{
		obj[x][y] = s;
	}
	
	public int getColumnSize(){return sizeY;}
	public int getRowSize(){return sizeX;}
	
	public FieldText getObject(int x, int y){return obj[x][y];}
	public String getString(int Y, int X){return obj[X][Y].getText();}
	public boolean isThere(int x, int y) 
	{
		if (obj[x][y] == null)
			return false;
		else return true;
	}
	public String GetPair(String n)
	{
		String s[], bts[];
		for(int j = 0; j < this.getRowSize(); j++)
			for(int i = 0; i < this.getColumnSize(); i++)
			{
				s = this.getString(i, j).split(",");
				for(int k=0; k < s.length; k++)
				{
					bts = s[k].split(":");
					if(bts.length > 1)
						if((bts[1].equals(n)) && (bts[0].equals("d")))
						{
							return bts[0]+";"+i+";"+j;
						}
				}
			}
		return null;
	}
}
