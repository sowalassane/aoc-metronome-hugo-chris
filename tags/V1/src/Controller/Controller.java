package Controller;

import Model.Moteur;
import Model.ObserverMoteur;
import View.Ihm;
import View.ObserverIhm;

public interface Controller extends ObserverIhm, ObserverMoteur{
	public void marquerTps();
	public void marquerMesure();
	public void setMoteur(Moteur moteur);
	public void setIhm(Ihm ihm);
}
