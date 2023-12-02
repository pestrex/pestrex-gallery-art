package model;

import java.util.ArrayList;

public class Gallery {
	
	private static Gallery gallery;
	
	private ArrayList<Art> galleryArts;
	
	private Gallery() {
		this.galleryArts = new ArrayList<>();
	}
	
	public static Gallery getInstance() {
		if(gallery == null){
			gallery = new Gallery();
		}
		return gallery;
	}
	
	public void addArt(Art art) {
		this.galleryArts.add(art);
	}
	
	public Art removeArt(String title) {
		Art art = galleryArts.get(searchWork(title));
		if (art != null) {
			this.galleryArts.remove(art);
			return art;
		} else {
			System.out.println("\nThis work doesn't exists");
			return null;
		}
	}
	
	public void showGallery() {
		System.out.println("\n------ Gallery Art ------");
		for(Art art: this.galleryArts) {
			System.out.println(this.galleryArts.indexOf(art)+1 + ". ---------------------------");
			art.showArt();
			System.out.println("Price: $" + art.getPurchasePrice());
			System.out.println("------------------------------");
		}
	}
	
	public int searchWork(String title) {
		for(Art art: galleryArts) {
			if(art.getTitle().equals(title)) {
				return galleryArts.indexOf(art);
			}
		}
		System.out.println("\nWork doesn't found");
		return -1;
	}
	
	public ArrayList<Art> getGalleryArts() {
		return this.galleryArts;
	}
}
