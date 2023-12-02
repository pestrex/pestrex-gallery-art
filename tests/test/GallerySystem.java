package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.runners.MethodSorters;

import impl.Menu;

import org.junit.FixMethodOrder;
import org.junit.Test;

import model.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GallerySystem {
	
	private ArrayList<Sale> sales = new ArrayList<>();
	
	@Test
	public void t2_SearchArtWork() {
		Gallery gallery = Gallery.getInstance();
		
		assertTrue(gallery.searchWork("La Mona") == 0);
	}

	@Test
	public void t1_Purchase() {
		Artist artist = new Artist("Leonardo", "da Vinci");
		Art art = new Art(artist, "La Mona", 50, 70, "Oleo", "Retrato");
		Gallery gallery = Gallery.getInstance();
		
		gallery.addArt(art);
		
		assertTrue(!gallery.getGalleryArts().isEmpty());
	}
	
	@Test
	public void t3_SaleArtWork() {
		Gallery gallery = Gallery.getInstance();
		Client client = new Client("Pedro Villarreal", "Santa clara 110", 10001);
		Art art = gallery.getGalleryArts().get(gallery.searchWork("La Mona"));
		Sale sale = new Sale(client, art);
		sales.add(sale);
		
		assertTrue(!sales.isEmpty());
	}
	
	@Test
	public void t5_Profit() {
		Gallery gallery = Gallery.getInstance();
		Art art = gallery.getGalleryArts().get(gallery.searchWork("La Mona"));
		Client client = new Client("Pedro Villarreal", "Santa clara 110", 10001);
		Sale sale = new Sale(client, art);
		sales.add(sale);
		
		assertTrue(Menu.profit(sale, art) == sale.getPrice()-art.getPurchasePrice());
	}
	
	@Test
	public void t4_RandomPrice() {
		Gallery gallery = Gallery.getInstance();
		Art art = gallery.getGalleryArts().get(gallery.searchWork("La Mona"));
		for(int i=0; i<1000; i++) {
			art.setPurchasePrice();
			assertTrue(art.getPurchasePrice() > 1000);
		}
	}

}
