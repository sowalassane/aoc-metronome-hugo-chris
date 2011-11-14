package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Horloge;
import Model.ObserverMoteur;

public class LecteurMateriel implements Ihm{
	private int tempo;
	private int nbTpsParMesure;
	private boolean memoireInc=false;
	private boolean memoireDec=false;
	private boolean etatMarche;
	private List<ObserverIhm> listObsIhm=new ArrayList<ObserverIhm>();

	public LecteurMateriel(){
		Materiel.getHorloge().activerPeriodiquement(new LireMateriel(this), 0.1f);
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
		notifyObserversIhm();
	}

	public int getNbTpsParMesure() {
		return nbTpsParMesure;
	}

	public void setNbTpsParMesure(int nbTpsParMesure) {
		this.nbTpsParMesure = nbTpsParMesure;
		notifyObserversIhm();
	}

	public void setEtatMarche(boolean etatMarche) {
		this.etatMarche = etatMarche;
		notifyObserversIhm();
	}

	@Override
	public int getPositionSlider() {
		int position=(int) (Materiel.getMolette().position() * 168);
		return (position + 40);
	}

	@Override
	public void attach(ObserverIhm o) {
		listObsIhm.add(o);
	}

	@Override
	public void detach(ObserverIhm o) {
		listObsIhm.remove(o);

	}

	@Override
	public void notifyObserversIhm() {
		Iterator<ObserverIhm> it=listObsIhm.iterator();
		//pour chaque observer moteur, utiliser la methode update afin de signaler un changement
		//d'etat du moteur
		while(it.hasNext()){
			//it.next() => rend l'objet ObserverMoteur courant ET avance d'un cran dans la liste
			it.next().updateIhm();
		}

	}

	@Override
	public void flasherLED(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getEtatMarche() {
		return etatMarche;
	}

	@Override
	public int getTpsParMesure() {
		return nbTpsParMesure;
	}

	@Override
	public void setTpsParMesure(int tpsParMesure) {
		this.nbTpsParMesure=tpsParMesure;
		notifyObserversIhm();
	}

	@Override
	public void emettreClic() {
		Materiel.getEmetteurSonore().emettreClic();

	}

	@Override
	public void setAfficheur(int tempo) {
		Materiel.getAfficheur().afficherTempo(tempo);

	}

	@Override
	public Horloge getHorloge() {
		return Materiel.getHorloge();
	}

	@Override
	public void lireMateriel() {
		
		//verif etatMarche
		if(Materiel.getClavier().touchepressee(0)){
			setEtatMarche(true);
		}
		else{
			setEtatMarche(false);
		}

		//verif tempo
		float moletteMateriel=Materiel.getMolette().position();
		int tempoMateriel=(int) ((moletteMateriel*168)+40);
		if(tempo!=tempoMateriel){
			setTempo(tempoMateriel);
		}

		//verif touche inc
		if(Materiel.getClavier().touchepressee(2) && memoireInc==false){
			if(nbTpsParMesure<7){
				setNbTpsParMesure(nbTpsParMesure+1);
				memoireInc=true;
			}
		}
		if(!Materiel.getClavier().touchepressee(2)){
			memoireInc=false;
		}

		//verif touche dec
		if(Materiel.getClavier().touchepressee(3) && memoireDec==false){
			if(nbTpsParMesure>2){
				setNbTpsParMesure(nbTpsParMesure-1);
				memoireDec=true;
			}
		}
		if(!Materiel.getClavier().touchepressee(3)){
			memoireDec=false;
		}

	}

}
