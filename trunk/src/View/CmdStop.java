package View;

import Controller.Controller;
import Model.Command;

public class CmdStop implements Command {
	private Controller controller;
	
	/**
	 * constructeur 
	 * @param controller Controlleur, le controlleur appele par la methode execute
	 */
	public CmdStop(Controller controlleur){
		this.controller=controlleur;
	}

	@Override
	public void execute() {
		controller.stop();

	}

}
