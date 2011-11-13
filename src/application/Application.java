package application;

import Model.*;
import Controller.*;
import View.*;

public class Application {
	
	public static void main(String[] args) {
		Ihm ihm=new LecteurMateriel();
		Moteur moteur=new MoteurImpl();	
		//creation de l'horloge une couche materiel independante de l'ihm et du moteur, mais utilise par les deux
		//TODO virer cr�ation horloge ici
		Horloge horloge=new TimerToHorloge();
		Controller controller=new ControllerImpl();
		controller.setMoteur(moteur);
		controller.setIhm(ihm);
		
		//injection de l'horloge pour le moteur et l'ihm
		moteur.setHorloge(horloge);
		ihm.setHorloge(horloge);
		
		Command marquerTps=new CmdMarquerTemps(controller);
		Command marquerMesure=new CmdMarquerMesure(controller);
		moteur.setCmdMarquerTps(marquerTps);
		moteur.setCmdMarquerMesure(marquerMesure);
		
		moteur.attach(controller);
		ihm.attach(controller);
	}

}
