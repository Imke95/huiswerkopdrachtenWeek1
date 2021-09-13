package blackjack;

public class Kaart {
	
	int id; // id voor elke unieke kaart
	String naam;// = computeName(id);
	int waarde;// = computeWaarde(id);
	
	Kaart(int id){
		this.id = id;
		this.naam = computeName(id);
		this.waarde = computeWaarde(id);
	}
	
	int computeWaarde(int id) {
		waarde = -1;
		if(id < 36) {
			waarde = (int) (Math.floor(id / 4) + 2);
		} else {
			if(id < 48) {
				waarde = 10;
			} else {
				waarde = 11;
			}
		}
		return waarde;
	}
	
	String computeName(int id) {
		String name0 = "";
		String[] typen = {"Harten", "Klaver", "Ruiten", "Schoppen"}; 
		if(id < 36) {
			name0 = typen[id % 4] + " " + String.valueOf((int) (Math.floor(id / 4) + 2));
		} else {
			if(id < 40) {
				name0 = typen[id-36] +  " Boer";
			} else {
				if(id < 44) {
					name0 = typen[id-40] +  " Vrouw";
				} else {
					if(id < 48) {
						name0 = typen[id-44] +  " Heer";
					} else {
						name0 = typen[id-48] +  " Aas";
					}
				}
			}
		}
		
		return name0;
	}
}
