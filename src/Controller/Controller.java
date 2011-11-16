package Controller;

import Model.Moteur;
import Model.ObserverMoteur;
import View.Ihm;
import View.ObserverIhm;

public interface Controller extends ObserverIhm, ObserverMoteur{
	/**
	 * action appelee par le moteur lorsqu'il necessaire de marquer un temps
	 */
	public void marquerTps();
	
	/**
	 * action appelee par le moteur lorsqu'il necessaire de marquer une mesure
	 */
	public void marquerMesure();
	
	/**
	 * specifie le moteur
	 * @param moteur le modele du MVC
	 */
	public void setMoteur(Moteur moteur);
	
	/**
	 * specifie l_ihm
	 * @param ihm la vue du MVC
	 */
	public void setIhm(Ihm ihm);
	
	/**
	 * action appelee lorsque le lecteur materiel detecte un clic de l'utlisateur sur le bouton inc
	 */
	public void inc();
	
	/**
	 * action appelee lorsque le lecteur materiel detecte un clic de l'utlisateur sur le bouton dec
	 */
	public void dec();
	
	/**
	 * action appelee lorsque le lecteur materiel detecte un clic de l'utlisateur sur le bouton strat
	 */
	public void start();
	
	/**
	 * action appelee lorsque le lecteur materiel detecte un clic de l'utlisateur sur le bouton stop
	 */
	public void stop();
}
