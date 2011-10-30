package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoteurImpl implements Moteur{
	private List<ObserverMoteur> ListObsMoteur=new ArrayList<ObserverMoteur>();
	private Command traiterTic;
	private Command marquerTemps;
	private boolean etatMarche;
	private int nbTpsParMesure;
	private int tempo;
	private Horloge horloge;
	
	public MoteurImpl(){
		traiterTic=new CmdTraiterTic();
		marquerTemps=new CmdMarquerTemps();
		horloge=new TimerToHorloge();
		etatMarche=false;
	}
	
	@Override
	public int getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(int t) {
		tempo=t;
	}

	@Override
	public void setNbTpsParMesure(int t) {
		nbTpsParMesure=t;
	}

	@Override
	public int getNbTpsParMesure() {
		return nbTpsParMesure;
	}

	@Override
	public boolean getEnMarche() {
		return etatMarche;
	}

	@Override
	public void setEnMarche(boolean b) {
		etatMarche=b;
		
	}

	@Override
	public void setCmdMarquerTps(Command cmd) {
		marquerTemps=cmd;
	}

	@Override
	public void setCmdTic(Command cmd) {
		traiterTic=cmd;
	}
	
	public void setMarquerTemps(Command marquerTemps) {
		this.marquerTemps = marquerTemps;
	}

	@Override
	public void traiterTic() {
		//TODO marquer temps si necessaire
		traiterTic.execute();
	}

	@Override
	public void attach(ObserverMoteur o) {
		ListObsMoteur.add(o);
	}

	@Override
	public void detach(ObserverMoteur o) {
		ListObsMoteur.remove(o);
	}

	@Override
	public void notifyObserversMoteur() {
		Iterator<ObserverMoteur> it=ListObsMoteur.iterator();
		//pour chaque observer moteur, utiliser la methode update afin de signaler un changement
		//d'etat du moteur
		while(it.hasNext()){
			//it.next() => rend l'objet ObserverMoteur courant ET avance d'un cran dans la liste
			it.next().updateMoteur();
		}
		
	}
		
}
