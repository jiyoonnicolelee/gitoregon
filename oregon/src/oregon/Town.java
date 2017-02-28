package oregon;

import oregon.Store;

public class Town extends Location {
	public Store store;
	
	public Town (String name, Store store){
		super(name);
		this.store = store;
	}
}
