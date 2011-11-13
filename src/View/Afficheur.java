package View;

public interface Afficheur {
	/**
	 * 
	 * @param numLED numero de la LED a allumer (1= led tic, 2=led temps)
	 */
	public void allumerLed(int numLED);
	/**
	 * 
	 * @param numLED @param numLED numero de la LED a eteindre (1= led tic, 2=led temps)
	 */
	public void eteindreLED(int numLED);
	public void afficherTempo(int valTempo);
}
