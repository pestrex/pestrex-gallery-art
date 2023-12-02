package model;

public class Sale {
	
	private Client client;
	private Art art;
	private double price;
	
	public Sale(Client client, Art art){
		this.client = client;
		this.art = art;
		this.price = art.getPurchasePrice()*1.585;
	}
	
	public void showSale() {
		this.client.showClient();
		this.art.showArt();
		System.out.println("Price: $" + price);
	}

	public double getPrice() {
		return price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Art getArt() {
		return art;
	}

	public void setArt(Art art) {
		this.art = art;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
