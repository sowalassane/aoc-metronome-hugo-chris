package View;

import Model.Command;

public class CmdLireMateriel implements Command{
	private Ihm ihm;
	
	public CmdLireMateriel(Ihm ihm){
		this.ihm=ihm;
	}

	@Override
	public void execute() {
		ihm.lireMateriel();
		
	}

}
