package Model;

public class CmdTraiterTic implements Command{
	private Moteur moteur;
	
	public CmdTraiterTic(Moteur moteur){
		this.moteur=moteur;
	}

	@Override
	public void execute() {
		moteur.traiterTic();
		
	}

}
