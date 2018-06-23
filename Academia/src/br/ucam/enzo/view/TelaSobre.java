package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaSobre {

	private JFrame frmSobre;

	public JFrame getFrmSobre() {
		return frmSobre;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre window = new TelaSobre();
					window.frmSobre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaSobre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSobre = new JFrame();
		frmSobre.setResizable(false);
		frmSobre.setTitle("Sobre");
		frmSobre.setBounds(100, 100, 262, 143);
		frmSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSobre.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSobre.class.getResource("/imagens/info.png")));
		lblNewLabel.setBounds(10, 0, 71, 117);
		frmSobre.getContentPane().add(lblNewLabel);
		
		JLabel lblFeitoPorEnzo = new JLabel("Feito por Enzo, 2018");
		lblFeitoPorEnzo.setBounds(103, 23, 124, 29);
		frmSobre.getContentPane().add(lblFeitoPorEnzo);
		
		JLabel lblNewLabel_1 = new JLabel("github.com/EnzoRobaina");
		lblNewLabel_1.setBounds(91, 51, 160, 14);
		frmSobre.getContentPane().add(lblNewLabel_1);
	}
}
