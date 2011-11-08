package Model;

//test commentaire
public interface Moteur {
	public int getTempo();
	/**
	 * specifie le tempo et notifie l'observer moteur
	 * @param t
	 */
	public void setTempo(int t);
	
	/**
	 * specifie le nb de temps apr mesure et notifie l'observer moteur
	 * @param t
	 */
	public void setNbTpsParMesure(int t);
	public int getNbTpsParMesure();	
	public boolean getEnMarche();
	
	/**
	 * specifie l'etat du moteur et notifie l'observer moteur
	 * @return
	 */
	public void setEnMarche(boolean b);
	/**
	 * specifie la command a utiliser pour le traitement d'un temps
	 * @param cmd Command permettant de marquer un temps
	 */
	public void setCmdMarquerTps(Command cmd);
	/**
	 * specifie la command a utiliser pour le traitement d'une mesure
	 * @param cmd Command permettant de marquer une mesure
	 */
	public void setCmdMarquerMesure(Command cmd);
	/**
	 * specifie la command a utiliser pour le traitement d'un clic
	 * @param cmd Command permettant de traiter un clic
	 */
	public void setCmdTic(Command cmd);
	/**
	 * traite un tic, inclue le flash des 2 LED si necessaire.
	 */
	public void traiterTic();
	public void attach(ObserverMoteur o);
	public void detach(ObserverMoteur o);
	public void notifyObserversMoteur();
	public void setHorloge(Horloge horloge);
}
