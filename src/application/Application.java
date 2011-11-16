package application;

import Model.*;
import Controller.*;
import View.*;

public class Application {
	
	public static void main(String[] args) {
		Materiel materiel=new Materiel(new IhmImplWBP());
		Ihm ihm=new LecteurMateriel();
		Moteur moteur=new MoteurImpl();	
		Controller controller=new ControllerImpl();
		controller.setMoteur(moteur);
		controller.setIhm(ihm);
		
		//injection de l'horloge pour le moteur et l'ihm
		moteur.setHorloge(ihm.getHorloge());
		
		Command marquerTps=new CmdMarquerTemps(controller);
		Command marquerMesure=new CmdMarquerMesure(controller);
		moteur.setCmdMarquerTps(marquerTps);
		moteur.setCmdMarquerMesure(marquerMesure);
		
		ihm.setCmdStart(new CmdStart(controller));
		ihm.setCmdStop(new CmdStop(controller));
		ihm.setCmdInc(new CmdInc(controller));
		ihm.setCmdDec(new CmdDec(controller));
		
		moteur.attach(controller);
		ihm.attach(controller);
	}

}
