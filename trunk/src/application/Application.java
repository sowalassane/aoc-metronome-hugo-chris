package application;

import Model.*;
import Controller.*;
import View.*;

public class Application {
	
	public static void main(String[] args) {
		Moteur moteur=new MoteurImpl();
		Controller controller=new ControllerImpl();
		Ihm ihm=new IhmImplWBP();
		
		moteur.attach(controller);
	}

}
