package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoteurImpl implements Moteur{
	private List<ObserverMoteur> ListObsMoteur=new ArrayList<ObserverMoteur>();
	private Command traiterTic;
	private Command marquerTemps;
	private Command marquerMesure;
	private boolean etatMarche;
	private int nbTpsParMesure;
	private int nbTpsDansMesureActuelle;
	private int tempo;
	private Horloge horloge;
	
	public MoteurImpl(){
		traiterTic=new CmdTraiterTic(this);
		nbTpsParMesure=1;
		nbTpsDansMesureActuelle=0;
		tempo=40;
		etatMarche=false;
	}
	
	@Override
	public int getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(int t) {
		tempo=t;
		horloge.desactiver(traiterTic);
		float delai=(float) 60/t;
		horloge.activerPeriodiquement(traiterTic, delai);
		notifyObserversMoteur();
	}

	@Override
	public void setNbTpsParMesure(int t) {
		nbTpsParMesure=t;
		nbTpsDansMesureActuelle=0;
		notifyObserversMoteur();
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
		//si on met en marche le moteur, alors on passe la commande traiter tic a l'ohrloge
		//avec le tempo desire
		if(etatMarche){
			float delai=(float) 60/tempo;
			horloge.activerPeriodiquement(traiterTic, delai);
		}
		//sinon on arrete l'appel periodique a la commande de traitemlent des tics
		else{
			horloge.desactiver(traiterTic);
		}
		notifyObserversMoteur();
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
		marquerTemps.execute();
		nbTpsDansMesureActuelle++;
		if(nbTpsDansMesureActuelle==nbTpsParMesure){
			nbTpsDansMesureActuelle=0;
			marquerMesure.execute();
		}
		
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

	@Override
	public void setCmdMarquerMesure(Command cmd) {
		marquerMesure=cmd;	
	}

	@Override
	public void setHorloge(Horloge horloge) {
		this.horloge=horloge;
		
	}
		
}
