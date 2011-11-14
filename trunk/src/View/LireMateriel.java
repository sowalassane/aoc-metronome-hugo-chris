package View;

import Model.Command;

public class LireMateriel implements Command{
	private Ihm ihm;
	
	public LireMateriel(Ihm ihm){
		this.ihm=ihm;
	}

	@Override
	public void execute() {
		ihm.lireMateriel();
		
	}

}
