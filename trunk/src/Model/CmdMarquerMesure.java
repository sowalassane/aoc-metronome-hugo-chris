package Model;

import Controller.Controller;

public class CmdMarquerMesure implements Command{
	private Controller controller;
	
	public CmdMarquerMesure(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.marquerMesure();
	}

}
