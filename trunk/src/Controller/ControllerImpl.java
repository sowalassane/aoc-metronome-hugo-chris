package Controller;

import Model.Moteur;
import View.Ihm;

public class ControllerImpl implements Controller{
	private Moteur moteur;
	private Ihm ihm;

	@Override
	public void updateMoteur() {

		ihm.setAfficheur(moteur.getTempo());

	}

	@Override
	public void updateIhm() {
		if(ihm.getEtatMarche()!=moteur.getEnMarche()){		
			moteur.setEnMarche(ihm.getEtatMarche());
		}
		if(ihm.getPositionSlider()!=moteur.getTempo()){
			moteur.setTempo(ihm.getPositionSlider());
		}
		if(ihm.getTpsParMesure()!=moteur.getNbTpsParMesure()){
			moteur.setNbTpsParMesure(ihm.getTpsParMesure());
		}

	}

	@Override
	public void marquerTps() {
		ihm.emettreClic();
		ihm.flasherLED(1);
	}

	@Override
	public void marquerMesure() {
		ihm.flasherLED(2);

	}

	@Override
	public void setMoteur(Moteur moteur) {
		this.moteur=moteur;

	}

	@Override
	public void setIhm(Ihm ihm) {
		this.ihm=ihm;

	}


}
