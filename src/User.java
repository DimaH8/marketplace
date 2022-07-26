import java.util.ArrayList;

public class User {
	private int id = 0; 
	private String firstName;
	private String lastName;
	private int amountOfMoney;
	private static int idGenerator = 10;
	private ArrayList<Product> userProducts;
	
	public User(String firstName, String lastName, int money) {
		this.id = idGenerator++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amountOfMoney = money;
		userProducts = new ArrayList<Product>();
	}

	public int getId() {
		return id;
	}
	
	public int getAmountMoney() {
		return amountOfMoney;
	}
	
	@Override
	public String toString() {
		return String.format("%d\t\t%s\t\t%s\t\t%d", id, firstName, lastName, amountOfMoney);
	}

	public void buy(Product product) {
		if (amountOfMoney < product.getPrice()) {
			throw new RuntimeException(String.format("User %d doesn't have enough money to buy product %d", id, product.getId()));
		}
		amountOfMoney -= product.getPrice();
		userProducts.add(product);
	}
	
	public String getUserProducts() {
		String res = "";
		for (int i = 0; i < userProducts.size(); i++) {
			res += userProducts.get(i).getId();
			res += ", ";
		}
		return res;
	}
	
	public boolean hasProduct(Product product) {
		boolean exist = false;
		for (int i = 0; i < userProducts.size(); i++) {
			if (userProducts.get(i).getId() == product.getId()) {
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
