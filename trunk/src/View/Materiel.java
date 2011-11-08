package View;

import Model.Horloge;
import Model.TimerToHorloge;

public class Materiel {
	private static Horloge horloge;
	private static Clavier clavier;
	private static Molette molette;
	private static EmetteurSonore emetteur;
	private static Afficheur afficheur;
	
	public Materiel(){
		horloge=new TimerToHorloge();
		
	}
	
	public static Horloge getHorloge(){
		return horloge;
	}

	public static Clavier getClavier(){
		return clavier;
	}

	public static Molette getMolette(){
		return molette;

	}

	public static EmetteurSonore getEmetteurSonore(){
		return emetteur;
	}

	public static Afficheur getAfficheur(){
		return afficheur;
	}
}
