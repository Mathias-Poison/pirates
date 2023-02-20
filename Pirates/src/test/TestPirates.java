package test;

import java.util.Scanner;

public class TestPirates {
	
	public static String saisieString(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
	}

	public static int saisieInt(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		int var = monScanner.nextInt();
		return var;
	}

	public static double saisieDouble(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		double var = monScanner.nextDouble();
		return var;
	}

	public static boolean saisieBoolean(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		boolean var = monScanner.nextBoolean();
		return var;
	}

	public static void main(String[] args) {

		
		
	}

}
