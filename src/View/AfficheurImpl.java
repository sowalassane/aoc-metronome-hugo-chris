package View;

public class AfficheurImpl implements Afficheur{
	private SimulMateriel simulMateriel;
	
	public AfficheurImpl(SimulMateriel simulMateriel){
		this.simulMateriel=simulMateriel;
	}

	@Override
	public void allumerLed(int numLED) {
		simulMateriel.allumerLED(numLED);
		
	}

	@Override
	public void eteindreLED(int numLED) {
		simulMateriel.eteindreLED(numLED);
		
	}

	@Override
	public void afficherTempo(int valTempo) {
		simulMateriel.setAfficheur(valTempo+"");
	}

}
