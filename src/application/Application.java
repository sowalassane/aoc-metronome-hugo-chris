package application;

import Model.*;
import Controller.*;
import View.*;

public class Application {
	
	public static void main(String[] args) {
		Ihm ihm=new IhmImplWBP();
		Moteur moteur=new MoteurImpl();	
		Controller controller=new ControllerImpl();
		controller.setMoteur(moteur);
		controller.setIhm(ihm);
		moteur.setHorloge(ihm.getHorloge());
		
		Command marquerTps=new CmdMarquerTemps(controller);
		Command marquerMesure=new CmdMarquerMesure(controller);
		moteur.setCmdMarquerTps(marquerTps);
		moteur.setCmdMarquerMesure(marquerMesure);
		
		moteur.attach(controller);
		ihm.attach(controller);
	}

}
