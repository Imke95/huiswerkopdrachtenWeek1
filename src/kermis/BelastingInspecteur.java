package kermis;

public class BelastingInspecteur {
	public void belastingOphalen(Attractie[] attrs, Kassa kassa) {
		kassa.aantalBelastingVisites++;
		for(int i = 0; i < attrs.length; i++) {
			if(attrs[i] instanceof GokAttractie){
				attrs[i].kansSpelBelastingBetalen();
			}
				
		}
		
	}
}
