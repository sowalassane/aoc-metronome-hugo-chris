package View;

/**
 * classe permettant de simuler le materiel conformement 
 * a l'interface fournis par le constructeur
 * @author Derive
 *
 */
public interface SimulMateriel {
	/**
	 * retourne la position du slider
	 * @return
	 */
	float getPositionSlider();
	
	/**
	 * emet un clic
	 */
	void emettreClic();
	
	/**
	 * affiche le texte donne en parametre sur l'afficheur
	 * du metronome
	 * @param string texte a afficher
	 */
	void setAfficheur(String string);
	
	/**
	 * retourne l'etat d'un bouton
	 * @param b numero du bouton a tester 1 start, 2 stop, 3 in, 4 dec
	 * @return true si le bouton est enfonce, false sinon
	 */
	boolean getEtatBouton(int b);
	
	/**
	 * allume la led dont le numero est passe en parametre
	 * @param num 1: led temps, 2: led mesures
	 */
	void allumerLED(int num);
	
	/**
	 * eteint la led dont le numero est passe en parametre
	 * @param num 1: led temps, 2: led mesures
	 */
	void eteindreLED(int num);

}
