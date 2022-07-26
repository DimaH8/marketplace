
public class Product {
	private int id;
	private String name;
	private int price;
	private static int idGenerator = 100;
	
	public Product(String name, int price) {
		this.id = idGenerator++;
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
	public String getProductName() {
		return name;
	}
}
