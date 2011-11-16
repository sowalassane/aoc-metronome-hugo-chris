package View;

import Controller.Controller;
import Model.Command;

public class CmdDec implements Command {
	private Controller controller;
	
	public CmdDec(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.dec();

	}

}
