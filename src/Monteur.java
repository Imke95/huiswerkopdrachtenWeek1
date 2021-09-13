
public class Monteur {
	int priceToFix(Auto auto) {
		int price = 0;
		for (int i = 0; i < auto.getToFix().length; i++) {
			if (auto.getToFix()[i]) {
				price += 25;
				auto.setToFixIdx(false, i);
			}
		}
		return price;
	}
}
