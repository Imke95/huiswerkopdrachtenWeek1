package blackjack;

public class Speler {
	int score = 0;
	Kaart[] kaartenSpeler = new Kaart[0];
	boolean inactive = false;
	String input = "";
	
	int calcScore() {
		int score = 0;
		for(int i = 0; i < this.kaartenSpeler.length; i++) {
			score += this.kaartenSpeler[i].waarde;
		}
		if(score > 21) {
			int countAces = 0;
			for(int i = 0; i < this.kaartenSpeler.length; i++) {
				if (this.kaartenSpeler[i].waarde == 11){
					countAces++;
				}
			for(int c = 0; c <= countAces; c++) {
				if(score - 10 * c < 21) {
					score -= 10 * c;
					return score;
				}
			}
			}
			if (countAces > 0) {
				score -= 10 * countAces;
			}
		}
		return score;
	}
	int checkAceScore() {
		int score = this.score;
		if(score > 21) {
			int countAces = 0;
			for(int i = 0; i < this.kaartenSpeler.length; i++) {
				if (this.kaartenSpeler[i].waarde == 11){
					countAces++;
				}
			for(int c = 0; c <= countAces; c++) {
				if(score - 10 * c < 21) {
					score -= 10 * c;
					return score;
				}
			}
			}
		}
		return score;
	}
}
