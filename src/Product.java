
public class Product {
	private int id;
	private String name;
	private int price;
	
	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%d\t\t%s\t\t%d", id, name, price);
	}

	public int getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
	
}
