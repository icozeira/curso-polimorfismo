package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> lists = new ArrayList<>();
		Product product;
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char choice = sc.nextLine().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();
									
			switch (choice) {
				case 'i':
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					product = new ImportedProduct(name, price, customsFee);
					lists.add(product);
					sc.nextLine();
					break;
				case 'u':
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufactureDate = sdf.parse(sc.nextLine());
					product = new UsedProduct(name, price, manufactureDate);
					lists.add(product);
					break;
				default:
					product = new Product(name, price);
					lists.add(product);					
			}
						
			}
			
		
		System.out.println("PRICE TAGS");
		for (Product item : lists) {
			System.out.println(item.priceTag());
		}
		
		
		sc.close();
	}
}
