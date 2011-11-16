package Model;

import View.Horloge;

//test commentaire
public interface Moteur {
	/**
	 * retourne le tempo stocker par le moteur
	 * @return int, tempo
	 */
	public int getTempo();
	
	/**
	 * specifie le tempo et notifie l'observer moteur
	 * @param t int, tempo
	 */
	public void setTempo(int t);
	
	/**
	 * specifie le nb de temps apr mesure et notifie l'observer moteur
	 * @param t int, nombre de temps par mesure
	 */
	public void setNbTpsParMesure(int t);
	
	/**
	 * retourne le nombre de tempss dans unelmesure
	 * @return int, nombre de temps dans une mesure
	 */
	public int getNbTpsParMesure();	
	
	/**
	 * specifie l'etat du moteur et notifie l'observer moteur
	 * @return boolean, etat du moteur
	 */
	public boolean getEnMarche();
	
	/**
	 * specifie l'etat du moteur et notify les observers moteur dnas le cas d'un changements
	 * @param b boolean, etat du moteur
	 */
	public void setEnMarche(boolean b);
	/**
	 * specifie la command a utiliser pour le traitement d'un temps
	 * @param cmd Command, permettant de marquer un temps
	 */
	public void setCmdMarquerTps(Command cmd);
	/**
	 * specifie la command a utiliser pour le traitement d'une mesure
	 * @param cmd Command, permettant de marquer une mesure
	 */
	public void setCmdMarquerMesure(Command cmd);
	/**
	 * specifie la command a utiliser pour le traitement d'un clic
	 * @param cmd Command, permettant de traiter un clic
	 */
	public void setCmdTic(Command cmd);
	/**
	 * traite un tic, inclue le flash des 2 LED si necessaire.
	 */
	public void traiterTic();
	
	/**
	 * ajout d'un observer moteur
	 * @param o ObserverMoteur, l'observer a ajouter
	 */
	public void attach(ObserverMoteur o);
	
	/**
	 * retire un observer (si il est present) de la liste des observers moteur
	 * @param o ObserverMoteur, l'observer a retirer
	 */
	public void detach(ObserverMoteur o);
	
	/**
	 * appelle la methode updateMoteur des observers afin de les notifier d'un changements d'etat du moteur
	 */
	public void notifyObserversMoteur();
	
	/**
	 * specifie l'horloge a utiliser par le moteur pour les actions periodiques
	 * @param horloge Horloge, horloge
	 */
	public void setHorloge(Horloge horloge);
}
