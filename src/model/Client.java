package model;

public class Client {
	
	private String name;
	private String address;
	private int phoneNumber;
	
	public Client(String name, String address, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public void showClient() {
		System.out.println("Client: " + name);
		System.out.println("Address: " + address);
		System.out.println("Number: " + phoneNumber);
	}
}
