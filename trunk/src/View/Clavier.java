package View;

public interface Clavier {
	/**
	 * retourne l'etat d'une touche
	 * @param i int, la touche a interrogee 1: start, 2: stop, 3:inc, 4:dec
	 * @return boolean, l'etat de la touche interogee, true si enfoncee, false sinon.
	 */
	public boolean touchepressee(int i);
}
