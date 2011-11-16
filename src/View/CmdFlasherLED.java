package View;

import Model.Command;

public class CmdFlasherLED implements Command{
	private int numLED;
	
	/**
	 * constructeur
	 * @param num le numero de la LED flasher (1=LED tic, 2= LED mesure)
	 */
	public CmdFlasherLED(int num){
		numLED=num;
	}

	@Override
	public void execute() {
		Horloge horloge=Materiel.getHorloge();
		
		horloge.activerApresDelais(new Command() {
			
			@Override
			public void execute() {
				Materiel.getAfficheur().allumerLed(numLED);
				
			}
		}, 0);
		
		horloge.activerApresDelais(new Command() {
			
			@Override
			public void execute() {
				Materiel.getAfficheur().eteindreLED(numLED);
				
			}
		}, 0.1f);
		
	}

}
