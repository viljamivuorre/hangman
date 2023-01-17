package T6;

//
//
//

import java.util.Scanner;
public class Main6 {
	

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Sanalista sanalista = new Sanalista("sanoja.txt");
		String input;
		int  x = 0;
		do {
			System.out.println("syötä arvauskertojen määrä: ");
			input = sc.nextLine();
			try 
			{ 
				x = Integer.parseInt(input); 
			}  
			catch (NumberFormatException e)  
			{ 
				x = 0;
			} 
		} while (x <= 0);
		Hirsipuu hirsipuu = new Hirsipuu(sanalista.annaSanat(), x);
		while (hirsipuu.arvauksiaOnJaljella() > 0) {
			System.out.println("anna kirjain: ");
			Character c = sc.next().toUpperCase().charAt(0);
			hirsipuu.arvaus(c);
			System.out.println("");
			System.out.println("arvaukset:" + hirsipuu.arvaukset());
			System.out.println("tilanne: " + hirsipuu.tilanne());
			System.out.println("arvauksia jäljellä: " + hirsipuu.arvauksiaOnJaljella());
			System.out.println("");
			if (hirsipuu.onLoppu() == true) {
				System.out.println("Voitit pelin!");
				break;
			}
		}
		if (hirsipuu.arvauksiaOnJaljella() == 0) {
			System.out.println("Hävisit pelin");
			System.out.println("Oikea sana: " + hirsipuu.sana());
		}
	}
}
