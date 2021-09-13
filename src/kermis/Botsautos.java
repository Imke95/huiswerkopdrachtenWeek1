package kermis;

public class Botsautos extends Attractie{
	Botsautos(){
		this.naam = "Botsauto's";
		this.prijs = 2.5;
	}
	double aantalKaartjes = 0;
	double getOmzet() {
		double omzet = this.aantalKaartjes * this.prijs;
		return omzet;
	}
}
