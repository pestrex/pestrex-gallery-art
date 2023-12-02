package impl;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Menu {
	
	private Scan scan;
	private Scanner scan1 = new Scanner(System.in);
	
	private Gallery gallery;
	private ArrayList<Sale> sales;
	private ArrayList<Art> purchases;
	
	private enum MenuType {
		BUY, SALE, REPORT, EXIT
	};

	private enum MenuType2 {
		GALLERY, SALES, PROFIT, RETURN
	};
	
	public Menu(Gallery gallery) {
		this.gallery = gallery;
		this.sales = new ArrayList<>();
		this.purchases = new ArrayList<>();
		this.scan = new Scan();
	}
	
	public void showMenu() {
		System.out.println("===================");
		System.out.println("=== Gallery Art ===");
		System.out.println("===================");
		MenuType opt;
		
		while(true) {
			opt = mainMenu();
			switch(opt) {
			case BUY:
				purchaseArt();
				break;
			case SALE:
				saleArt();
				break;
			case REPORT:
				reportOption();
				break;
			case EXIT:
				return;
			}
		}
	}
	
	public void reportOption() {
		MenuType2 opt;
		while(true) {
			opt = reportMenu();
			switch(opt) {
			case GALLERY:
				gallery.showGallery();
				break;
			case SALES:
				System.out.println("\n--- Sales ---");
				for(Sale sale: sales) {
					System.out.println(this.sales.indexOf(sale)+1 + ". ---------------------------");
					sale.showSale();
					System.out.println("------------------------------");
				}
				break;
			case PROFIT:
				System.out.println("\n--- Profit Report ---");
				for(Sale sale: sales) {
					System.out.println(this.sales.indexOf(sale)+1 + ". ---------------------------");
					Art art = sale.getArt();
					System.out.println("Artwork author: " + art.getArtist().getFirstName() + " " + art.getArtist().getLastName());
					System.out.println("Title: " + art.getTitle());
					System.out.println("Purchase price: " + art.getPurchasePrice());
					System.out.println("Selling price: " + sale.getPrice());
					System.out.println("Profit: " + profit(sale, art));
					System.out.println("------------------------------");
				}
				break;
			case RETURN:
				System.out.println("\nReturning to main menu...");
				return;
			}
		}
	}
	
	public static double profit(Sale sale, Art art) {
		return sale.getPrice()-art.getPurchasePrice();
	}
	
	public void purchaseArt() {
		String fname, lname, title, technique, theme;
		double width, height;
		System.out.print("\nAuthor first name: ");
		fname = scan1.nextLine();
		System.out.print("Author last name: ");
		lname = scan1.nextLine();
		System.out.print("Title of the work to purchase: ");
		title = scan1.nextLine();
		System.out.print("Technique of the work to purchase: ");
		technique = scan1.nextLine();
		System.out.print("Theme of the work to purchase: ");
		theme = scan1.nextLine();
		System.out.print("Width of the work to purchase: ");
		width = scan1.nextDouble();
		System.out.print("Height of the work to purchase: ");
		height = scan1.nextDouble();
		
		Artist artist = new Artist(fname, lname);
		Art art = new Art(artist, title, width, height, technique, theme);
		this.purchases.add(art);
		this.gallery.addArt(art);
		
		this.gallery.showGallery();
	}
	
	public void saleArt() {
		String name, address, title;
		int phone;
		System.out.print("\nClient's name: ");
		name = scan1.nextLine();
		System.out.print("Client's address: ");
		address = scan1.nextLine();
		System.out.print("Client's phone number: ");
		phone = scan1.nextInt();
		System.out.print("Work's title: ");
		title = scan1.nextLine();
		title = scan1.nextLine();
		
		if(gallery.searchWork(title) != -1) {
			Client client = new Client(name, address, phone);
			Art art = this.gallery.getGalleryArts().get(gallery.searchWork(title));
			
			Sale sale = new Sale(client, art);
			sale.showSale();
			
			sales.add(sale);
			gallery.removeArt(title);
		}
	}
	
	public MenuType mainMenu() {
		int opt;
		
		System.out.println("\n--- Main Menu ---");
		System.out.println("1. Generate purchases");
		System.out.println("2. Generate sales");
		System.out.println("3. Generate reports");
		System.out.println("4. Exit.");
		
		opt = scan.getOptionInRange(1, 4);
		
		MenuType[] menu = MenuType.values();
		return menu[opt - 1];
	}
	
	public MenuType2 reportMenu() {
		int opt;
		
		System.out.println("\n--- Report Menu ---");
		System.out.println("1. Report of available artworks.");
		System.out.println("2. Sales report.");
		System.out.println("3. Profit report.");
		System.out.println("4. Return.");
		
		opt = scan.getOptionInRange(1, 4);
		
		MenuType2[] menu = MenuType2.values();
		return menu[opt - 1];
	}
}
