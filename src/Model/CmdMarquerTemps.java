package Model;

import Controller.Controller;

public class CmdMarquerTemps implements Command{
	private Controller controller;

	/**
	 * constructeur
	 * @param controller Controller, le controlleur appele par la methode execute
	 */
	public CmdMarquerTemps(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.marquerTps();

	}

}
