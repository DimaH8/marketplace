import java.util.ArrayList;
import java.util.Scanner;

public class Marketplace {
		
	public static void menuText() {
		System.out.println("Please, choose one of the options number:");
		System.out.println("0. Exit");
		System.out.println("1. Display list all of users");
		System.out.println("2. Display list all of products");
		System.out.println("3. Buy product");
		System.out.println("4. Display list of user products");
		System.out.println("5. Display user that bought product");
	}
	
	private static void displayUsers(ArrayList<User> users) {
		System.out.println("List of all users:");
		System.out.println("ID\t\tFirst Name\tLast Name\tAmount of money");
		for (User u : users) {
			System.out.println(u);
		}
	}

	private static void displayProducts(ArrayList<Product> products) {
		System.out.println("List of all products:");
		System.out.println("ID\t\tName\t\tPrice");
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	public static void userBuyProduct(ArrayList<User> users, ArrayList<Product> products, int userId, int productId) {
	
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == userId) {
				user = users.get(i);
				break;
			}
		}
		if (user == null) {
			throw new RuntimeException("Invalid user ID " + userId);
		}
		
		Product product = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == productId) {
				product = products.get(i);
				break;
			}
		}
		if (product == null) {
			throw new RuntimeException("Invalid product ID " + productId);
		}
		
		user.buy(product);
		System.out.println("User " + user.getId() + " successufully made purchase");
	}
	
	private static void displayUserProducts(ArrayList<User> users, int userId) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == userId) {
				user = users.get(i);
				break;
			}
		}
		if (user == null) {
			throw new RuntimeException("Invalid user ID " + userId);
		}
		System.out.println("User has the following products: " + user.getUserProducts());
	}
	
	private static void displayUsersByProducts(ArrayList<User> users, ArrayList<Product> products, int productId) {
		Product product = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == productId) {
				product = products.get(i);
				break;
			}
		}
		if (product == null) {
			throw new RuntimeException("Invalid product ID " + productId);
		}
		System.out.println("Users that bought product " + productId + ":");
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).hasProduct(product) == true) {
				System.out.println(users.get(i).getId());
			}
		}
	}
	
	public static void main(String[] args) {
		
		User peter = new User(10, "Peter", "Smith", 500);
		User sam = new User(11, "Sam", "Adams", 50);
		User maria = new User(12, "Maria", "Melnyk", 100);
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(peter);
		users.add(sam);
		users.add(maria);
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(100, "Potato", 45));
		products.add(new Product(101, "Tomato", 70));
		products.add(new Product(102, "Eggs", 20));
			
		boolean isWorking = true;
		Scanner in = new Scanner(System.in);
		int userId = -1;
		int productId = -1;
		
		System.out.println("Hello! Welcome to Marketplace!");
		while (isWorking) {
			menuText();
			
			int option = in.nextInt();
			
			try {
				switch (option) {
					case 0:
						isWorking = false;
						break;
					case 1: 
						displayUsers(users);
						break;
					case 2: 
						displayProducts(products);
						break;
					case 3: 
						System.out.println("Please, enter ID of user");
						userId = in.nextInt();
						System.out.println("Please, enter ID of product");
						productId = in.nextInt();
						userBuyProduct(users, products, userId, productId);
						
						break;		
					case 4: 
						System.out.println("Please, enter ID of user");
						userId = in.nextInt();
						displayUserProducts(users, userId);
						break;	
					case 5: 
						System.out.println("Please, enter ID of product");
						productId = in.nextInt();
						displayUsersByProducts(users, products, productId);
						break;		
					default:
						System.out.println("Something wrong! Please, choose one number of the option from the menu");
						menuText();
						break;
				}
			}
			catch(RuntimeException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		in.close();
		System.out.println("Thank you for using our Marketplace! Have a nice day!");
	}

}
