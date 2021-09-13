package kermis;

public class Spin extends RisicoRijkeAttractie implements GokAttractie{
	Spin(){
		this.naam = "Spin";
		this.prijs = 2.25;
		this.draaiLimiet = 5;
		opstellingsKeuring();
	}
	double aantalKaartjes = 0;
	double getOmzet() {
		double omzet = this.aantalKaartjes * this.prijs;
		return omzet;
	}
	public void opstellingsKeuring() {
		System.out.println("Attractie is veilig opgesteld.");
		this.aantalGedraaid = 0;
	}

	double omzet = 0;
	public void kansSpelBelastingBetalen() {
		this.omzet *= 0.7;
		
	}
	
}
