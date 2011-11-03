package application;

import Model.*;
import Controller.*;
import View.*;

public class Application {
	
	public static void main(String[] args) {
		Moteur moteur=new MoteurImpl();	
		Ihm ihm=new IhmImplWBP();
		Controller controller=new ControllerImpl();
		controller.setMoteur(moteur);
		controller.setIhm(ihm);
		
		
		Command marquerTps=new CmdMarquerTemps(controller);
		Command marquerMesure=new CmdMarquerMesure(controller);
		moteur.setCmdMarquerTps(marquerTps);
		moteur.setCmdMarquerMesure(marquerMesure);
		
		moteur.attach(controller);
		ihm.attach(controller);
	}

}
