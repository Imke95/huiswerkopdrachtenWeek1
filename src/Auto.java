
public class Auto {
	private boolean[] toFix;

	Auto(boolean[] toFix){
		this.toFix = toFix;
	}
	
	boolean[] getToFix() {
		return this.toFix;
	}

	void setToFix(boolean[] toFix) {
		this.toFix = toFix;
	}
	
	void setToFixIdx(boolean toFix, int idx) {
		this.toFix[idx] = toFix;
	}
}
