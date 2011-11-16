package View;

import Controller.Controller;
import Model.Command;

public class CmdInc implements Command {
	private Controller controller;
	
	public CmdInc(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.inc();

	}

}
