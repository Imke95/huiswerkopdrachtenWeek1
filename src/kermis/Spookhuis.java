package kermis;

public class Spookhuis extends Attractie{
	Spookhuis(){
		this.naam = "Spookhuis";
		this.prijs = 3.20;
	}
	double aantalKaartjes = 0;
	double getOmzet() {
		double omzet = this.aantalKaartjes * this.prijs;
		return omzet;
	}
}
