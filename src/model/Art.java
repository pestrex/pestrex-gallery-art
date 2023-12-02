package model;

public class Art {
	
	private Artist artist;
	private String title;
	private double width;
	private double height;
	private String technique;
	private String theme;
	private double purchasePrice;
	
	public Art(Artist artist, String title, double width, double height, String technique, String theme) {
		this.artist = artist;
		this.title = title;
		this.width = width;
		this.height = height;
		this.technique = technique;
		this.theme = theme;
		setPurchasePrice();
	}
	
	public void showArt() {
		System.out.println("\nTitle: " + title);
		System.out.println("Artist: " + artist.getFirstName() + " " + artist.getLastName());
		System.out.println("Size: " + width + "width, " + height + "height.");
		System.out.println("Technique: " + technique);
		System.out.println("Theme: " + theme);
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice() {
		this.purchasePrice = 0;
		while(purchasePrice < 1000) {
			this.purchasePrice = Math.random()*100000;
		}
	}

	public String getTitle() {
		return title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
