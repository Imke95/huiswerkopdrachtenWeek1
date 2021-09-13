package kermis;

import java.util.Scanner;

public class Kermis {
	
	public static void main(String args[]) throws Exception {
		Botsautos bots = new Botsautos();
		Spin spin = new Spin();
		Spiegelpaleis spiegels = new Spiegelpaleis();
		Spookhuis spookhuis = new Spookhuis();
		Hawaii hawaii = new Hawaii();
		Ladderklimmen ladders = new Ladderklimmen();
		//Attractie[] attrs = {bots, spin, spiegels, spookhuis, hawaii, ladders};
		Kassa kassa = new Kassa();
		boolean nogEen = true;
		System.out.println("Welkom op de kermis!");
		while(nogEen) {
			System.out.println("Welke actie wilt u doen? Wilt u een attractie laten draaien? Kies: \r\n" + "1 voor botsauto's,\r\n"
					+ "2 voor spin,\r\n"
					+ "3 voor spiegelpaleis,\r\n"
					+ "4 voor spookhuis,\r\n"
					+ "5 voor hawaii,\r\n"
					+ "6 voor ladderklimmen. Kies 'o' om de totale omzet te zien, en 'k' voor het aantal verkochte kaartjes. Kies 'm' om een monteur in te huren.");
			Scanner mySc = new Scanner(System.in);
			String keuze = mySc.nextLine();
			
			if(keuze.equals("1")){
				bots.draaien();
			}
			if(keuze.equals("2")){
				spin.draaien();
				if(spin.aantalGedraaid > spin.draaiLimiet) {
					mySc.close();
					throw new Exception("Error: we hadden eerst een onderhoudsbeurt moeten doen.");
				}
			}
			if(keuze.equals("3")){
				spiegels.draaien();
			}
			if(keuze.equals("4")){
				spookhuis.draaien();
			}
			if(keuze.equals("5")){
				hawaii.draaien();
			}
			if(keuze.equals("6")){
				ladders.draaien();
			}
			if(keuze.equals("o")){
				double omzet = kassa.omzet;
				System.out.println(omzet);
			}
			if(keuze.equals("k")){
				int kaartjes = (int) kassa.aantalKaartjes;
				System.out.println(kaartjes);
			}
			if(keuze.equals("m")){
				System.out.println("Voor welke attractie wilt u een monteur langssturen? Kies 1 voor Spin en 2 voor Hawaii");
				String attr = mySc.nextLine();
				if(attr.equals("1")) {
					spin.keuring();
				}
				if(attr.equals("2")) {
					hawaii.keuring();
				}
			}
			System.out.println("Wilt u nog een actie doen? Typ 'j' voor ja en 'n' voor nee.");
			String antw = mySc.nextLine();
			if(antw.equals("n")) {
				nogEen = false;
			}
		}
		
		
	}
}
