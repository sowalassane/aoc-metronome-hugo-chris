package View;

public interface Ihm {
	/**
	 * renvoie la position du slider tempo de l'IHM
	 * @return float, position du slider de tempo
	 */
	public float getPositionSlider();
	public void attach(ObserverIhm o);
	public void detach(ObserverIhm o);
	/**
	 * Flash la	LED dont le numero est passer en arguments
	 * @param num numero de la LED a flasher( 1: LED TIC, 2: LED temps)
	 */
	public void flasherLED(int num);
}
