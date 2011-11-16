package View;

import Model.Command;


public interface Ihm {
	/**
	 * renvoie la position du slider tempo de l'IHM, compris entre 40 et 208
	 * @return int, position du slider de tempo
	 */
	public int getPositionSlider();
	
	/**
	 * attache un observerIhm a l'ihm
	 * @param o ObserverIhm,l'observer a attacher
	 */
	public void attach(ObserverIhm o);
	
	/**
	 * supprime un observerIhm de la liste des observers
	 * @param o ObserverIhm,
	 */
	public void detach(ObserverIhm o);
	
	/**
	 * notifie tout les observerIHM d'un changement de l'ihm
	 */
	public void notifyObserversIhm();
	
	/**
	 * Flash la	LED dont le numero est passer en arguments
	 * @param num int, numero de la LED a flasher( 1: LED TIC, 2: LED temps)
	 */
	public void flasherLED(int num);	
	
	/**
	 * emet un clic
	 */
	public void emettreClic();
	
	/**
	 * Affiche un texte sur l'afficheur de l'ihm
	 * @param tempo int, tempo
	 */
	public void setAfficheur(int tempo);
	
	/**
	 * specifie la command a appeler lorsque le bouton start est presser
	 * @param cmd Command, la command start a utiliser
	 */
	public void setCmdStart(Command cmd);
	
	/**
	 * specifie la command a appeler lorsque le bouton stop est presser
	 * @param cmd Command, la command stop a utiliser
	 */
	public void setCmdStop(Command cmd);
	
	/**
	 * specifie la command a appeler lorsque le bouton inc est presser
	 * @param cmd Command, la command inc a utiliser
	 */
	public void setCmdInc(Command cmd);
	
	/**
	 * specifie la command a appeler lorsque le bouton dec est presser
	 * @param cmd Command, la command dec a utiliser
	 */
	public void setCmdDec(Command cmd);
	
	/**
	 * retourne l'horloge du materiel
	 * @return Horloge, horloge
	 */
	public Horloge getHorloge();
	
	/**
	 * methode appellee afin de verifier les changements au niveau de l'ihm materiel
	 */
	public void lireMateriel();
	
}
