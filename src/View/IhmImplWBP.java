package View;

import java.awt.EventQueue;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;

import Model.*;

public class IhmImplWBP extends JFrame implements Ihm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSlider slider;
	private List<ObserverIhm> observers=new ArrayList<ObserverIhm>();
	private Command cmdStart;
	private Command cmdStop;
	private Command cmdInc;
	private Command cmdDec;
	private Command cmdChangeTempo;
	private boolean etat;
	private int tpsParMesure;

	/**
	 * Create the frame.
	 */
	public IhmImplWBP() {
		etat=false;
		tpsParMesure=1;
		
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
		slider.setBounds(10, 60, 130, 36);
		contentPane.add(slider);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setForeground(Color.BLACK);
		panel.setBounds(161, 60, 139, 36);
		contentPane.add(panel);
		
		JLabel lblAfficheurl = new JLabel();
		lblAfficheurl.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblAfficheurl);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(24, 194, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBounds(123, 194, 89, 23);
		contentPane.add(btnStop);
		
		JButton btnInc = new JButton("INC");
		btnInc.setBounds(222, 194, 89, 23);
		contentPane.add(btnInc);
		
		JButton btnDec = new JButton("DEC");
		btnDec.setBounds(321, 194, 89, 23);
		contentPane.add(btnDec);
		
		JLabel lblLed1 = new JLabel("LED 1");
		lblLed1.setBounds(321, 60, 46, 14);
		contentPane.add(lblLed1);
		
		JLabel lblLed2 = new JLabel("LED 2");
		lblLed2.setBounds(321, 85, 46, 14);
		contentPane.add(lblLed2);
		
		JPanel panel_Led1 = new JPanel();
		panel_Led1.setBackground(Color.LIGHT_GRAY);
		panel_Led1.setBounds(377, 60, 10, 10);
		contentPane.add(panel_Led1);
		
		JPanel panel_Led2 = new JPanel();
		panel_Led2.setBackground(Color.LIGHT_GRAY);
		panel_Led2.setBounds(377, 85, 10, 10);
		contentPane.add(panel_Led2);
		
		JLabel lblMetronome = new JLabel("Metronome");
		lblMetronome.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetronome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMetronome.setBounds(135, 11, 174, 38);
		contentPane.add(lblMetronome);
		
		//*************ajout des listener sur les boutons de l'interface
		//listener bouton start
		MouseListener listenerStart=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!etat){
					setEtatMarche(true);
				}
			}
		};
		btnStart.addMouseListener(listenerStart);
		
		//listener bouton stop
		MouseListener listenerStop=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(etat){
					setEtatMarche(false);
				}
			}
		};
		btnStop.addMouseListener(listenerStop);
		
		//listener bouton Inc
		MouseListener listenerInc=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tpsParMesure<7){
					setTpsParMesure(tpsParMesure++);
				}
			}
		};
		btnInc.addMouseListener(listenerInc);
		
		//listener bouton Dec
		MouseListener listenerDec=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tpsParMesure>1){
					setTpsParMesure(tpsParMesure--);
				}
			}
		};
		btnDec.addMouseListener(listenerDec);
		
		//change listener sur le slider
		//TODO ne pas envoyer d'evenement des que le slider change
		//stocker valeur et n'envoyer que si la val ne change pas ?
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				notifyObserversIhm();
			}
		});
		//************Fin d'ajouts de listener
		
		this.setVisible(true);
	}

	@Override
	public float getPositionSlider() {
		return slider.getValue();
	}

	@Override
	public void attach(ObserverIhm o) {
		observers.add(o);
		
	}

	@Override
	public void detach(ObserverIhm o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObserversIhm() {
		Iterator<ObserverIhm> it=observers.iterator();
		//pour chaque observer de l'ihm, utiliser la methode update afin de signaler un changement
		//d'etat de lihm
		while(it.hasNext()){
			//it.next() => rend l'objet ObserverIhm courant ET avance d'un cran dans la liste
			it.next().updateIhm();
		}
	}

	@Override
	public void flasherLED(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEtatMarche() {
		return etat;
	}

	@Override
	public void setEtatMarche(boolean etat) {
		this.etat=etat;
		notifyObserversIhm();
	}

	@Override
	public int getTpsParMesure() {
		return tpsParMesure;
	}

	@Override
	public void setTpsParMesure(int tpsParMesure) {
		this.tpsParMesure=tpsParMesure;
		notifyObserversIhm();
		
	}
}
