package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Horloge;
import Model.ObserverMoteur;

public class LecteurMateriel implements Ihm{
	private Materiel materiel;
	private List<ObserverIhm> listObsIhm=new ArrayList<ObserverIhm>();
	
	public LecteurMateriel(){
		materiel=new Materiel(new IhmImplWBP());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEtatMarche(boolean etat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTpsParMesure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTpsParMesure(int tpsParMesure) {
		// TODO Auto-generated method stub
		
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
	public void setEtatIhm(boolean etat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Horloge getHorloge() {
		return Materiel.getHorloge();
	}

}
