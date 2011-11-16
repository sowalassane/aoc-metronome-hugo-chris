package View;

import Model.Command;

public class CmdLireMateriel implements Command{
	private Ihm ihm;
	
	/**
	 * constructeur
	 * @param ihm Ihm, l'ihm appelee par la methode execute
	 */
	public CmdLireMateriel(Ihm ihm){
		this.ihm=ihm;
	}

	@Override
	public void execute() {
		ihm.lireMateriel();
		
	}

}
