package Model;

public class CmdTraiterTic implements Command{
	private Moteur moteur;
	
	/**
	 * constructeur
	 * @param moteur Moteur, le moteur appele par la methdoe execute
	 */
	public CmdTraiterTic(Moteur moteur){
		this.moteur=moteur;
	}

	@Override
	public void execute() {
		moteur.traiterTic();
		
	}

}
