package kermis;

public class Attractie {
	String naam;
	double prijs;
	int opp;
	int aantalGedraaid = 0;
	double omzet = 0;
	void draaien() {
		System.out.println("De attractie " + this.naam + " draait.");
		this.aantalGedraaid++;
	}
	void kansSpelBelastingBetalen() {
		
	}
}
