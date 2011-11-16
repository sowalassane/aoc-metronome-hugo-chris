package Model;

import Controller.Controller;

public class CmdMarquerMesure implements Command{
	private Controller controller;
	
	/**
	 * constructeur
	 * @param controller Controller, le controlleur appele par la methode execute
	 */
	public CmdMarquerMesure(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.marquerMesure();
	}

}
