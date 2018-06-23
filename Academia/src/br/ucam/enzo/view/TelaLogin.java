package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.ucam.enzo.model.DAO.LoginDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frmLogin;
	private JTextField userTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 199, 173);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		userTxt = new JTextField();
		userTxt.setBounds(10, 30, 175, 20);
		frmLogin.getContentPane().add(userTxt);
		userTxt.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(10, 11, 46, 14);
		frmLogin.getContentPane().add(lblUsurio);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(10, 79, 175, 20);
		frmLogin.getContentPane().add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setBounds(10, 61, 46, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDAO dao = new LoginDAO();
				if(dao.validar(userTxt.getText(), passwordTxt.getText())) {
					TelaMenuPrincipal principal = new TelaMenuPrincipal();
					frmLogin.dispose();
					principal.getFrmTelaMenuPrincipal().setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(10, 109, 175, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
