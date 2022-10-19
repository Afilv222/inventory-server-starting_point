
// needs to be implement Serializable 
public class Supplier{

	private int id;
	private String name;
	
	Supplier(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {

		return "Supplier_name: " + this.name;
	}
}
