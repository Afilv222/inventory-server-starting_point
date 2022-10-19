

	// needs to be implement Serializable 
public class Item{
	private int id;
	private String name;
	private Supplier supplier;
	
	Item(int id, String name, Supplier supplier){
		this.id = id;
		this.name = name;
		this.supplier = supplier;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {

		return "Item_id: " + this.id + ", Item_name: " + this.name + ", " + this.supplier;
	}
	
	
	

}
