import java.util.Random;
import java.util.Scanner;

public class Miniopdrachten {

	public static void main(String args[]) {
		// miniopdracht 1
		System.out.println("po" + "ging" + "en");

		// miniopdracht 2
		String myString = "regenen";
		int count = 0;
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) == 'e') {
				count++;
			}
		}
		System.out.println("Het woord " + myString + " heeft " + count + " e's.");

		// miniopdracht 3
		int sum = 0;
		int[] arr = { 1, 2, 3, 4 };
		System.out.print("The sum of [");
		for (int i = 0; i < arr.length - 1; i++) {
			sum += arr[i];
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
		System.out.println("] = " + sum + ".");

		// miniopdracht 4
		Random rd = new Random();
		int[] arr0 = new int[10];
		System.out.print("Original random array = [");
		for (int i = 0; i < arr0.length - 1; i++) {
			arr0[i] = rd.nextInt(100);
			System.out.print(arr0[i] + ", ");
		}
		System.out.println(arr0[arr0.length - 1] + "].");
		int[] arrSorted = mySort(arr0);
		System.out.print("The sorted array = [");
		for (int i = 0; i < arrSorted.length - 1; i++) {
			System.out.print(arrSorted[i] + ", ");
		}
		System.out.println(arrSorted[arrSorted.length - 1] + "].");

		// miniopdracht 5
		Monteur monteur = new Monteur();
		boolean[] toFix = { true, false, true, false };
		Auto auto = new Auto(toFix);
		int price = monteur.priceToFix(auto);
		System.out.println("Het kostte " + price + " euro om de auto te maken.");
		int check = toFix.length;
		for (int i = 0; i < toFix.length; i++) {
			if (auto.getToFix()[i]) {
				check--;
			}
		}
		if (check == toFix.length) {
			System.out.println("All parts are fixed!");
		}

		// miniopdracht 6
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Voer hier een woord in: ");
		String input = myScanner.nextLine();

		System.out.println("Uw gekozen woord is: " + input);
		String sortedWord = mySortString(input);
		System.out.println("Uw woord op alfabetische volgorde is: " + sortedWord);
		// myScanner.close();

		// miniopdracht 7
		char[] woord = { 'f', 'i', 'e', 't', 's' };
		System.out.println("Het woord is: _ _ _ _ _");
		System.out.println("Vul uw guess in: ");
		String guess = myScanner.nextLine();
		char[] guessArr = guess.toCharArray();

		int[] result = getResultNoDuplicates(woord, guessArr);
		System.out.print("result = ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println(".");

		// miniopdracht 8
		Boot gewoneBoot = new Boot();
		SpeedBoot mySpeedBoot = new SpeedBoot();
		Kapitein myKapitein = new Kapitein();
		myKapitein.varen(gewoneBoot);
		myKapitein.varen(mySpeedBoot);

		// miniopdracht 9
		Vliegtuig boing373 = new Vliegtuig();
		Leeuw simba = new Leeuw();
		Spreeuw victor = new Spreeuw();

		boing373.kanIkVliegen();
		simba.kanIkVliegen();
		victor.kanIkVliegen();

		// miniopdracht 10
		System.out.println("Ik ga op vakantie en ik neem mee...");
		String input1 = myScanner.nextLine();
		System.out.println("Ik ga op vakantie en ik neem mee: " + input1);
		String input2 = myScanner.nextLine();
		String[] oldStrings = { input1, input2 };
		
		while (input1.charAt(input1.length() - 1) == input2.charAt(0)) {
			System.out.print("Ik ga op vakantie en ik neem mee: ");
			for (int i = 0; i < oldStrings.length - 1; i++) {
				System.out.print(oldStrings[i] + ", ");
			}
			System.out.print(oldStrings[oldStrings.length - 1]);
			input1 = input2;
			input2 = myScanner.nextLine();

			String[] newStrings = new String[oldStrings.length + 1];
			for (int i = 0; i < oldStrings.length; i++) {
				newStrings[i] = oldStrings[i];
			}
			newStrings[newStrings.length - 1] = input2;
			oldStrings = newStrings; // Mag je dit zo doen? Je overschrijft een array van lengte i met een array van
										// lengte i + 1. Het werkt wel, maar klinkt niet heel consequent voor mij met
										// het feit dat java een strenge taal is.
		}
		System.out.println("Woord begint niet met laatste letter van vorig woord.");

		// myScanner.close();
	}

	static int[] mySort(int[] arr) {
		int swaps = 10;
		while (swaps != 0) {
			swaps = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int a = arr[i];
					int b = arr[i + 1];
					arr[i] = b;
					arr[i + 1] = a;
					swaps++;
				}
			}
		}
		return arr;
	}

	static String mySortString(String myString) {
		int swaps = 10;
		char[] charArr = myString.toCharArray();
		while (swaps != 0) {
			swaps = 0;
			for (int i = 0; i < charArr.length - 1; i++) {
				if (charArr[i] > charArr[i + 1]) {
					char a = charArr[i];
					char b = charArr[i + 1];
					charArr[i] = b;
					charArr[i + 1] = a;
					swaps++;
				}
			}
		}
		String mySortedString = String.valueOf(charArr);
		return mySortedString;
	}

	static int[] getResult(char[] woord, char[] guessArr) {
		int[] result = new int[woord.length];
		if (guessArr.length != woord.length) {
			System.out.println("Error: guess must be a word equal to five letters. Result not reliable.");
		} else {
			for (int i = 0; i < result.length; i++) {
				if (guessArr[i] == woord[i]) {
					result[i] = 2;
				} else {
					boolean contains = false;
					for (int j = 0; j < woord.length; j++) {
						if (woord[j] == guessArr[i]) {
							contains = true;
							break;
						}
					}
					if (contains) {
						result[i] = 1;
					}
				}
			}
		}
		return result;
	}

	static int[] getResultNoDuplicates(char[] woord, char[] guessArr) {
		int[] result = new int[woord.length];
		if (guessArr.length != woord.length) {
			System.out.println("Error: guess must be a word equal to five letters. Result not reliable.");
		} else {
			for (int i = 0; i < result.length; i++) {
				if (guessArr[i] == woord[i]) {
					result[i] = 2;
				}
			}
			for (int i = 0; i < result.length; i++) {
				if (guessArr[i] != woord[i]) {
					boolean contains = false;
					for (int j = 0; j < woord.length; j++) {
						if (woord[j] == guessArr[i]) {
							if (result[j] != 2) {
								contains = true;
								break;
							}
						}
					}
					if (contains) {
						result[i] = 1;
					}
				}
			}
		}
		return result;
	}

}
