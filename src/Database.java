

import java.util.HashMap;


public class Database {
	HashMap<Integer, Item> db;
	
	Database(){
		db = new HashMap<Integer, Item>();
		populateDummyData();
	}
	
	private void populateDummyData() {
		Supplier s1 = new Supplier(1, "Supplier 1");
		Supplier s2 = new Supplier(1, "Supplier 2");
		
		Item item = new Item(1, "item A", s1);
		db.put(1, item);
		
		item = new Item(2, "item B", s2);
		db.put(2, item);
		
		item = new Item(3, "item C", s2);
		db.put(3, item);
		
		item = new Item(4, "item D", s1);
		db.put(4, item);
		
	}

	
	public Item search(int id) {
		Item item = null;
		if ( db.get(id)!= null) {
			item = db.get(id);
		}
		
		return item;
	}
	


}
