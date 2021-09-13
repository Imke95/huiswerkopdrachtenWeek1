package kermis;

public class Ladderklimmen extends Attractie implements GokAttractie{
	Ladderklimmen(){
		this.naam = "Ladderklimmen";
		this.prijs = 5.00;
	}
	double aantalKaartjes = 0;
	double getOmzet() {
		double omzet = this.aantalKaartjes * this.prijs;
		return omzet;
	}
	double omzet = 0;
	@Override
	public void kansSpelBelastingBetalen() {
		System.out.println("De belastingdienst komt langs om belasting op te halen voor de attractie " + this.naam + ".");
		this.omzet *= 0.7;
	}
}
