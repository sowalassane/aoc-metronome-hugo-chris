package View;

public interface SimulMateriel {
	/**
	 * retourne la position du slider
	 * @return
	 */
	float getPositionSlider();
	void emettreClic();
	void setAfficheur(String string);
	boolean getEtatBouton(int b);
	void allumerLED(int num);
	void eteindreLED(int num);

}
