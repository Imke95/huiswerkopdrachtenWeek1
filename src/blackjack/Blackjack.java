package blackjack;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Blackjack {
	 
	public static void main(String args[]) {
		// We maken eerst een array met kaarten gesorteerd aan.
		Kaart[] kaarten = new Kaart[52];
		for(int i = 0; i < 52; i++) {
			kaarten[i] = new Kaart(i);
		}
		// We schudden de kaarten door elkaar en printen ze uit. 
		kaarten = shuffle(kaarten);
		System.out.println("De kaarten zijn: [");
		for(int i = 0; i < kaarten.length -1; i++) {
			System.out.print(kaarten[i].naam + ", ");
		}
		System.out.println(kaarten[kaarten.length - 1].naam + "].");
		System.out.println("De 52 kaarten zijn geschud.");
		
		// Start spel met interactie gebruiker.
		Kaart[] kaartenSpeler = new Kaart[0];
		Speler speler = new Speler();
		kaarten = startGame(kaarten, speler);
		String str = "";
		
		while(speler.score < 21) {
			Timer t = new Timer();
			 TimerTask task = new TimerTask()
			    {
			        public void run()
			        {
			            if( str.equals("") )
			            {
			                System.out.println( "Je hebt niks ingevuld. Automatische pass..." );
			                pass(speler);
			                t.cancel();
			                System.exit(0);
			            }
			        }    
			    };
			t.schedule( task, 10*1000 );
			System.out.println("Wilt u een kaart? Zo ja, typ 'k'. Als u wilt passen typt u 'p'");
			boolean correctInput = false;
			String input = "";
			long timenow = new Date().getTime();
			Scanner mySc = new Scanner(System.in);
			input = mySc.nextLine();
			while(input.equals("")) {
				if(new Date().getTime() - timenow > 1) {
				pass(speler);
				}
			}
			correctInput = (input.equals("k") | input.equals("p") | input.equals("q"));
			while(!correctInput) {
				input = "";
				timenow = new Date().getTime();
				System.out.println("Voer alstublieft een geldig antwoord in. U kunt 'k' typen voor een kaart, 'p' om te passen en 'q' om het spel af te sluiten.");
				input = mySc.nextLine();
				while(input.equals("")) {
					if(new Date().getTime() - timenow > 1) {
					pass(speler);
					}
				}
				correctInput = (input.equals("k") | input.equals("p") | input.equals("q"));
				
			}
			//Cancelling timer task
			t.cancel();
			
			if (input.equals("q")) {
				System.out.println("Spel is over door aangeven van gebruiker.");
				break;
			}
			if(input.equals("k")) {
				
				kaarten = geefKaart(kaarten, speler);
				
				System.out.println("Uw score is: " + speler.score);
				System.out.println("Uw kaarten tot nu toe zijn: ");
				for(int i = 0; i < speler.kaartenSpeler.length - 1; i++) {
					System.out.print(speler.kaartenSpeler[i].naam + ", ");
				}
				System.out.println(speler.kaartenSpeler[speler.kaartenSpeler.length - 1].naam + ".");
				
				if (speler.score > 21) {
					System.out.println("Helaas, u heeft verloren.");
				}
			}
			if (input.equals("p")) {
				pass(speler);
				//t.cancel();
				System.exit(0);
			}
			//t.cancel();
		}
		
	
	
	}
	
	static Kaart[] shuffle(Kaart[] kaarten) {
		Kaart[] shuffledKaarten = new Kaart[kaarten.length];
		for(int i = 0; i< kaarten.length; i++) {
			shuffledKaarten[i] = kaarten[i];
		}
		Random rnd = new Random();
        for (int i = shuffledKaarten.length - 1; i > 0; i--){
            int idx = rnd.nextInt(i + 1);
     
            Kaart a = shuffledKaarten[idx];
            shuffledKaarten[idx] = shuffledKaarten[i];
            shuffledKaarten[i] = a;
        }
		return shuffledKaarten;
	}
	
	static Kaart[] startGame(Kaart[] kaarten, Speler speler) {
		System.out.println("We beginnen het spel. U krijgt eerst twee kaarten.");
		kaarten = geefKaart(kaarten, speler);
		kaarten = geefKaart(kaarten, speler);
		System.out.println("Uw begin score is: " + speler.score);
		System.out.println("Uw kaarten tot nu toe zijn: ");
		for(int i = 0; i < speler.kaartenSpeler.length - 1; i++) {
			System.out.print(speler.kaartenSpeler[i].naam + ", ");
		}
		System.out.println(speler.kaartenSpeler[speler.kaartenSpeler.length - 1].naam + ".");
		
		return kaarten;
	}
	static Kaart[] geefKaart(Kaart[] kaarten, Speler speler) {
		Kaart kaart = kaarten[0];
		
		Kaart[] nieuweKaarten = new Kaart[kaarten.length - 1];
		for(int i=1; i < kaarten.length; i++) {
			nieuweKaarten[i - 1] = kaarten[i];
		}
		kaarten = nieuweKaarten;
		
		Kaart[] nieuweKaartenSpeler = new Kaart[speler.kaartenSpeler.length + 1];
		for(int i=0; i < speler.kaartenSpeler.length; i++) {
			nieuweKaartenSpeler[i] = speler.kaartenSpeler[i];
		}
		nieuweKaartenSpeler[nieuweKaartenSpeler.length - 1] = kaart;
		speler.kaartenSpeler = nieuweKaartenSpeler; 
		
		//speler.score += kaart.waarde;
		//speler.score = speler.checkAceScore();
		speler.score = speler.calcScore();
		if(speler.score == 21) {
			System.out.println("U heeft gewonnen!");
		}
		return kaarten;
		
	}
	
	static void pass(Speler speler) {		
		System.out.println("U heeft gepast. Uw uiteindelijke score is: " + speler.score);
		if(speler.kaartenSpeler.length > 0) {
			System.out.println("Uw kaarten zijn: ");
			for(int i = 0; i < speler.kaartenSpeler.length - 1; i++) {
				System.out.print(speler.kaartenSpeler[i].naam + ", ");
			}
			System.out.println(speler.kaartenSpeler[speler.kaartenSpeler.length - 1].naam + ".");
		} else {
			System.out.println("U had nog geen kaarten verzameld.");
		}
		
		
	}
	
	static void speelRonde(Kaart[] kaarten) {
		
	}

}


