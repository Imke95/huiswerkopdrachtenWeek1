package kermis;

public class Hawaii extends RisicoRijkeAttractie{
	Hawaii(){
		this.naam = "Hawaii";
		this.prijs = 2.90;
		this.draaiLimiet = 10;
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
	
}
