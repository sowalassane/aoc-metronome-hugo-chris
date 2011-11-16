package View;

import Controller.Controller;
import Model.Command;

public class CmdDec implements Command {
	private Controller controller;
	
	/**
	 * constructeur 
	 * @param controller Controlleur, le controlleur appele par la methode execute
	 */
	public CmdDec(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.dec();

	}

}
