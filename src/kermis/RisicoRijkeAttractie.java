package kermis;

public abstract class RisicoRijkeAttractie {
	int draaiLimiet;
	String naam;
	double prijs;
	int opp;
	int aantalGedraaid;
	
	void draaien() {
		System.out.println("De attractie " + this.naam + " draait.");
		aantalGedraaid++;
	}
	public void keuring() {
		this.aantalGedraaid = 0;
	}
}
