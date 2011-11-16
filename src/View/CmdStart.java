package View;

import Controller.Controller;
import Model.Command;

public class CmdStart implements Command{
	private Controller controller;
	
	public CmdStart(Controller controller){
		this.controller=controller;
	}

	@Override
	public void execute() {
		controller.start();
		
	}

}
