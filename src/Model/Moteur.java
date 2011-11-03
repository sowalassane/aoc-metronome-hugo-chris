package Model;

//test commentaire
public interface Moteur {
	public float getTempo();
	public void setTempo(float t);
	public void setNbTpsParMesure(int t);
	public int getNbTpsParMesure();
	public boolean getEnMarche();
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
}
