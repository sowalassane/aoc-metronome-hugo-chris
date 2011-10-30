package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class IhmImplWBP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IhmImplWBP frame = new IhmImplWBP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IhmImplWBP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 60, 130, 36);
		contentPane.add(slider);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setForeground(Color.BLACK);
		panel.setBounds(161, 60, 139, 36);
		contentPane.add(panel);
		
		JLabel lblAfficheurl = new JLabel("New label");
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
	}
}
