package View;

import Model.Horloge;
import Model.TimerToHorloge;

public class Materiel {
	private static Horloge horloge;
	private static Clavier clavier;
	private static Molette molette;
	private static EmetteurSonore emetteur;
	private static Afficheur afficheur;
	private static SimulMateriel simulMateriel;
	
	public Materiel(SimulMateriel simulMateriel){
		this.simulMateriel=simulMateriel;
		horloge=new TimerToHorloge();
		clavier=new ClavierImpl(simulMateriel);
		molette=new MoletteImpl(simulMateriel);
		emetteur=new EmetteurSonoreImpl(simulMateriel);
		afficheur=new AfficheurImpl(simulMateriel);
		
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
