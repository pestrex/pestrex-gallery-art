package impl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
	
	private Scanner scan;
	
	public Scan() {
		scan = new Scanner(System.in);
	}
	
	public int getOptionInRange(int lowerLimit, int upperLimit) {
		int opt = -1;
		boolean valid = false;
		
		do {
			opt = getInt();
			if (opt >= lowerLimit && opt <= upperLimit) {
				valid = true;
			} else {
				System.out.println("Invalid option! Try again.");
			}
		} while(!valid);
		
		return opt;
	}
	
	public int getInt() {
		int num = -1;
		boolean valid = false;

		do {
			try {
				System.out.print("Enter the option: ");
				String value = scan.nextLine();
				num = Integer.parseInt(value);
				valid = true;
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Invalid option! Try again.");
			}
		} while (!valid);

		return num;
	}
}
