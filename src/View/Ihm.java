package View;

public interface Ihm {
	/**
	 * renvoie la position du slider tempo de l'IHM
	 * @return float, position du slider de tempo
	 */
	public float getPositionSlider();
	
	/**
	 * attache un observerIhm a l'ihm
	 * @param o l'observer a attacher
	 */
	public void attach(ObserverIhm o);
	
	/**
	 * supprime un observerIhm de la liste des observers
	 * @param o
	 */
	public void detach(ObserverIhm o);
	
	/**
	 * notifie tout les observerIHM d'un changement de l'ihm
	 */
	public void notifyObserversIhm();
	
	/**
	 * Flash la	LED dont le numero est passer en arguments
	 * @param num numero de la LED a flasher( 1: LED TIC, 2: LED temps)
	 */
	public void flasherLED(int num);
}
