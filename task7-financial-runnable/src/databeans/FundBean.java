package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class FundBean {
	private int    id;
	private String name;
	private String symbol;
	
	public int    getId()                { return id;           }
	public String getName()              { return name;         }
  	public String getSymbol()            { return symbol;    }
    
  	public void   setId(int i)           { id = i;              }
	public void   setName(String s)      { name = s;            }
	public void   setSymbol(String s)    { symbol = s;       }

}
