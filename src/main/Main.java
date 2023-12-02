package main;

import impl.Menu;
import model.Gallery;

public class Main {
	
	public static void main(String[] args) {
		Gallery gallery = Gallery.getInstance();
		
		Menu menu = new Menu(gallery);
		menu.showMenu();
	}
}
