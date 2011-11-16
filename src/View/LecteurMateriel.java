package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Command;
import Model.ObserverMoteur;

public class LecteurMateriel implements Ihm{
	private int tempo;
	private int memoireTempo;
	private boolean memoireInc=false;
	private boolean memoireDec=false;
	private Command cmdFlasherLED1;
	private Command cmdFlasherLED2;
	private Command cmdStart;
	private Command cmdStop;
	private Command cmdInc;
	private Command cmdDec;
	private List<ObserverIhm> listObsIhm=new ArrayList<ObserverIhm>();

	public LecteurMateriel(){
		Materiel.getHorloge().activerPeriodiquement(new CmdLireMateriel(this), 0.05f);
		cmdFlasherLED1=new CmdFlasherLED(1);
		cmdFlasherLED2=new CmdFlasherLED(2);
	}

	public void setCmdStart(Command cmdStart) {
		this.cmdStart = cmdStart;
	}

	public void setCmdStop(Command cmdStop) {
		this.cmdStop = cmdStop;
	}

	public void setCmdInc(Command cmdInc) {
		this.cmdInc = cmdInc;
	}

	public void setCmdDec(Command cmdDec) {
		this.cmdDec = cmdDec;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
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
		if(num==1){
			cmdFlasherLED1.execute();
		}
		else{
			cmdFlasherLED2.execute();
		}

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
			cmdStart.execute();
		}
		else if(Materiel.getClavier().touchepressee(1)){
			cmdStop.execute();
		}

		//verif tempo
		float moletteMateriel=Materiel.getMolette().position();
		int tempoMateriel=(int) ((moletteMateriel*168)+40);
		
		//si il y a une difference entre le tempo actuel et celui du materiel..
		if(tempo!=tempoMateriel){
			//...si le dernier tempo vu est le meme que celui du materiel 
			//=> la valeur du tempo a ete la meme lors de deux appels consecutifs a la fonction liremateriel()
			//alors on change la valeur du tempo et on notify les observers ihm
			if(memoireTempo==tempoMateriel){
				memoireTempo=tempoMateriel;
				setTempo(tempoMateriel);
			}
			//....si non alors on change juste "memoireTempo". Cette approche permet de limiter
			//les changements au niveau du moteur lorsque le slider bouge rapidement (passage d'une valeur a une autre)
			else{
				memoireTempo=tempoMateriel;
			}
		}

		//verif touche inc (+garder en memoire etat touche afin de ne pas
		//envoyer d'evenements a la chaine si l'utilisateur laisse la touche enfoncer)
		if(Materiel.getClavier().touchepressee(2) && memoireInc==false){
			cmdInc.execute();
			memoireInc=true;
		}
		if(!Materiel.getClavier().touchepressee(2)){
			memoireInc=false;
		}

		//verif touche dec (+garder en memoire etat touche afin de ne pas
		//envoyer d'evenements a la chaine si l'utilisateur laisse la touche enfoncer)
		if(Materiel.getClavier().touchepressee(3) && memoireDec==false){
			cmdDec.execute();
			memoireDec=true;
		}
		if(!Materiel.getClavier().touchepressee(3)){
			memoireDec=false;
		}

	}

}
