package Controller;

public interface Controller {
	/**
	 * action a effectuer dans le cas d'un changement d'etat du moteur
	 */
	public void updateMoteur();
	/**
	 * action a effectuer dans le cas d'un changement d'etat de l'IHM
	 */
	public void updateIHM();
}
