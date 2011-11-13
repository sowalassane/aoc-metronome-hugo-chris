package View;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;

import Model.Command;
import Model.Horloge;
import Model.TimerToHorloge;


public class IhmImplWBP extends JFrame implements SimulMateriel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSlider slider;
	private int tpsParMesure;
	private Clip bip;
	private JLabel lblAfficheur;
	private JButton btnInc;
	private JButton btnDec;
	private Horloge horloge;
	private JPanel panel_Led1;
	private JPanel panel_Led2;
	private boolean[] etatBoutons;

	public Horloge getHorloge() {
		return horloge;
	}

	/**
	 * Create the frame.
	 */
	public IhmImplWBP() {
		etatBoutons=new boolean[4];
		etatBoutons[0]=false;
		etatBoutons[1]=false;
		etatBoutons[2]=false;
		etatBoutons[3]=false;
		tpsParMesure=2;
		
		
		//init bip
		try {
			bip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/song/beep.wav"));
			bip.open(ais);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(2);
		slider.setMaximum(208);
		slider.setMinimum(40);
		slider.setValue(40);
		slider.setBounds(10, 60, 130, 36);
		contentPane.add(slider);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setForeground(Color.BLACK);
		panel.setBounds(161, 60, 139, 36);
		contentPane.add(panel);
		
		lblAfficheur = new JLabel("40");
		lblAfficheur.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblAfficheur);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(24, 194, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBounds(123, 194, 89, 23);
		contentPane.add(btnStop);
		
		btnInc = new JButton("INC");
		btnInc.setBounds(222, 194, 89, 23);
		contentPane.add(btnInc);
		
		btnDec = new JButton("DEC");
		btnDec.setBounds(321, 194, 89, 23);
		contentPane.add(btnDec);
		
		JLabel lblLed1 = new JLabel("LED 1");
		lblLed1.setBounds(321, 60, 46, 14);
		contentPane.add(lblLed1);
		
		JLabel lblLed2 = new JLabel("LED 2");
		lblLed2.setBounds(321, 85, 46, 14);
		contentPane.add(lblLed2);
		
		panel_Led1 = new JPanel();
		panel_Led1.setBackground(Color.LIGHT_GRAY);
		panel_Led1.setBounds(377, 60, 10, 10);
		contentPane.add(panel_Led1);
		
		panel_Led2 = new JPanel();
		panel_Led2.setBackground(Color.LIGHT_GRAY);
		panel_Led2.setBounds(377, 85, 10, 10);
		contentPane.add(panel_Led2);
		
		JLabel lblMetronome = new JLabel("Metronome");
		lblMetronome.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetronome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMetronome.setBounds(135, 11, 174, 38);
		contentPane.add(lblMetronome);
		
		setEtatIhm(false);
		this.setVisible(true);
	}

	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}

	public float getPositionSlider() {
		return slider.getValue();
	}

	public void flasherLED(int num) {
		final JPanel led;
		if(num==1){
			led=panel_Led1;
		}
		else{
			led=panel_Led2;
		}
		//allumer led
		horloge.activerApresDelais(new Command() {
			
			@Override
			public void execute() {
				led.setBackground(Color.GREEN);
				
			}
		}, 0);
		
		//eteindre apres 0.2 sec
		horloge.activerApresDelais(new Command() {
			
			@Override
			public void execute() {
				led.setBackground(Color.LIGHT_GRAY);
				
			}
		}, 0.1f);
		
		
	}

	public JSlider getSlider() {
		return slider;
	}

	public int getTpsParMesure() {
		return tpsParMesure;
	}

	public void setTpsParMesure(int tpsParMesure) {
		this.tpsParMesure=tpsParMesure;
		
	}

	public void emettreClic() {
		//bip.start();
		System.out.println("\007");
		System.out.println("Click!");
		
	}

	public void setAfficheur(String string) {
		lblAfficheur.setText(string);
	}

	public void setEtatIhm(boolean etat) {
		if(etat){
			btnInc.setEnabled(true);
			btnDec.setEnabled(true);
			slider.setEnabled(true);
		}
		else{
			btnInc.setEnabled(false);
			btnDec.setEnabled(false);
			slider.setEnabled(false);
			panel_Led1.setBackground(Color.LIGHT_GRAY);
			panel_Led2.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public boolean getEtatBouton(int b) {
		return etatBoutons[b];
	}

}
