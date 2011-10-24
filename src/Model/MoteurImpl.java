package Model;

import java.util.List;

public class MoteurImpl implements Moteur{
	private List<ObserverMoteur> ListObsMoteur;
	private Command traiterTic;
	private Command marquerTemps;
	private boolean etatMarche;
	private int nbTpsParMesure;
	private int tempo;

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

	@Override
	public void traiterTic() {
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
	
}
