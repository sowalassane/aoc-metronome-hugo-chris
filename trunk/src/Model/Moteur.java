package Model;

//test commentaire
public interface Moteur {
	public int getTempo();
	public void setTempo(int t);
	public void setNbTpsParMesure(int t);
	public int getNbTpsParMesure();
	public boolean getEnMarche();
	public void setEnMarche(boolean b);
	/**
	 * specifie la command a utiliser pour le traitement d'un temps
	 * @param cmd COmmand permettant de marquer un temps
	 */
	public void setCmdMarquerTps(Command cmd);
	/**
	 * spécifie la command a utiliser pour le traitement d'un clic
	 * @param cmd Command permettant de traiter un clic
	 */
	public void setCmdTic(Command cmd);
	/**
	 * traite un tic, inclue le flash des 2 LED si necessaire.
	 */
	public void traiterTic();
	public void attach(ObserverMoteur o);
	public void detach(ObserverMoteur o);
}
