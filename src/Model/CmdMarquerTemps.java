package Model;

import Controller.Controller;

public class CmdMarquerTemps implements Command{
private Controller controller;
	
	public CmdMarquerTemps(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.marquerTps();
		
	}

}
