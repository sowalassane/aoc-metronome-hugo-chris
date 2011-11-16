package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Timer;

import Model.Command;

/**
 * adapte la classe Timer de Swing vers l'interface Horloge
 *
 */
public class TimerToHorloge implements Horloge{
	HashMap<Command, Timer> repeatedCommands = new HashMap<Command, Timer>();

	@Override
	public void activerPeriodiquement(Command cmd, float periodEnSec) {
		final Command finalCmd=cmd;
		Timer timerCmd=new Timer((int) (periodEnSec*1000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalCmd.execute();
			}
		});
		timerCmd.setRepeats(true);	
		timerCmd.start();
		
		//enregistrer la command et son timer comme des action se repetant
		repeatedCommands.put(cmd, timerCmd);
	}

	@Override
	public void activerApresDelais(Command cmd, float delaiEnSec) {
		final Command finalCmd=cmd;
		Timer timerCmd=new Timer((int) (delaiEnSec*1000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalCmd.execute();
			}
		});
		timerCmd.setRepeats(false);	
		timerCmd.start();
	}

	@Override
	public void desactiver(Command cmd) {
		if(repeatedCommands.get(cmd)!=null){
			//arret de la repetition du timer correspondant a l'action
			repeatedCommands.get(cmd).stop();
			//suppression du timer de la liste des actions a repeter
			repeatedCommands.remove(cmd);
		}
	}

}
