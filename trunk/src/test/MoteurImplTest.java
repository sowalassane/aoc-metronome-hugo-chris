package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Command;
import Model.Moteur;
import Model.MoteurImpl;
import View.TimerToHorloge;

public class MoteurImplTest {
	private int tic=0;

	@Test
	public void testInitMoteur() {
		Moteur moteur=new MoteurImpl();
		assertEquals(2, moteur.getNbTpsParMesure());
		assertEquals(40, moteur.getTempo());
		assertFalse(moteur.getEnMarche());
	}
	
	@Test
	public void testTempo() {
		Moteur moteur=new MoteurImpl();
		moteur.setTempo(100);
		assertEquals(100,moteur.getTempo());
	}
	
	@Test
	public void testMesure() {
		Moteur moteur=new MoteurImpl();
		moteur.setNbTpsParMesure(5);
		assertEquals(5,moteur.getNbTpsParMesure());
	}
	
	@Test
	public void testMarquerTemps() {
		Moteur moteur=new MoteurImpl();
		moteur.setHorloge(new TimerToHorloge());
		moteur.setCmdMarquerTps(new Command() {
			
			@Override
			public void execute() {
				tic++;
			}
		});
		moteur.setCmdMarquerMesure(new Command() {
			
			@Override
			public void execute() {

			}
		});
		moteur.traiterTic();
		assertEquals(1,tic);
		moteur.traiterTic();
		assertEquals(2,tic);
	}

}
