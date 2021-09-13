package kermis;

public class Spiegelpaleis extends Attractie{
	public Spiegelpaleis() {
		this.naam =  "Spiegelpaleis";
		this.prijs = 2.75;
	}
	double aantalKaartjes = 0;
	double getOmzet() {
		double omzet = this.aantalKaartjes * this.prijs;
		return omzet;
	}
}
