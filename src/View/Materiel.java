package View;


public class Materiel {
	private static Horloge horloge;
	private static Clavier clavier;
	private static Molette molette;
	private static EmetteurSonore emetteur;
	private static Afficheur afficheur;
	
	public Materiel(SimulMateriel simulMateriel){
		horloge=new TimerToHorloge();
		clavier=new ClavierImpl(simulMateriel);
		molette=new MoletteImpl(simulMateriel);
		emetteur=new EmetteurSonoreImpl(simulMateriel);
		afficheur=new AfficheurImpl(simulMateriel);
		
	}
	
	/**
	 * retourne l'horloge materiel
	 * @return Horloge, horloge
	 */
	public static Horloge getHorloge(){
		return horloge;
	}

	/**
	 * retourne le Clavier
	 * @return Clavier, clavier
	 */
	public static Clavier getClavier(){
		return clavier;
	}

	/**
	 * retourne la molette
	 * @return Molette, molette
	 */
	public static Molette getMolette(){
		return molette;

	}

	/**
	 * retourne l'emetteur sonore
	 * @return EmetteurSonore, emetteur
	 */
	public static EmetteurSonore getEmetteurSonore(){
		return emetteur;
	}

	/**
	 * retourne l'afficheur
	 * @return Afficheur, afficheur
	 */
	public static Afficheur getAfficheur(){
		return afficheur;
	}
}
