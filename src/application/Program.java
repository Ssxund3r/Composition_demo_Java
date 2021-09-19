package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Locale.setDefault(Locale.US);
		Scanner input =new Scanner (System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Email: ");
		String email = input.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(input.next());
		
		Client client = new Client (name, email, birthDate);
		
		System.out.println("Enter Order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(input.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = input.nextInt();
		for (int i=0; i<n; i++) {
			System.out.println("Enter" + (i+1) + "item DATA:");
			System.out.print("Product Name: ");
			input.nextLine();
			String productName = input.nextLine();
			System.out.print("Product Price: ");
		    double productPrice = input.nextDouble();
		    System.out.println("Quantity: ");
		    int quantity = input.nextInt();
		    
		    Product product = new Product (productName, productPrice);
		    
		    OrderItem it = new OrderItem(quantity, productPrice, product);
		    
		    order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		input.close();
	}
	
}
