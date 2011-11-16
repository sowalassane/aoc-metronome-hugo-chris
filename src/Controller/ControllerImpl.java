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
		if(ihm.getPositionSlider()!=moteur.getTempo()){
			moteur.setTempo(ihm.getPositionSlider());
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

	@Override
	public void inc() {
		if(moteur.getNbTpsParMesure()<7){
			moteur.setNbTpsParMesure(moteur.getNbTpsParMesure()+1);
		}
		
	}

	@Override
	public void dec() {
		if(moteur.getNbTpsParMesure()>2){
			moteur.setNbTpsParMesure(moteur.getNbTpsParMesure()-1);
		}
		
	}

	@Override
	public void start() {
		if(!moteur.getEnMarche()){
			moteur.setEnMarche(true);
		}
		
	}

	@Override
	public void stop() {
		if(moteur.getEnMarche()){
			moteur.setEnMarche(false);
		}
		
	}


}
