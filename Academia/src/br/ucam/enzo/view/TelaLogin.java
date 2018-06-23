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
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin {

	private JFrame frmLogin;
	private JTextField userTxt;
	private JPasswordField passwordTxt;

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
		frmLogin.setBounds(100, 100, 207, 237);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		userTxt = new JTextField();
		userTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(userTxt.getText().equals("Usuário")) {
					userTxt.setText(null);
					userTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
				}
				
			}
		});
		userTxt.setFont(new Font("Dialog", Font.ITALIC, 12));
		userTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				userTxt.setText(null);
				userTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
			}
		});
		userTxt.setText("Usu\u00E1rio");
		userTxt.setToolTipText("Usu\u00E1rio");
		userTxt.setBounds(12, 94, 175, 20);
		frmLogin.getContentPane().add(userTxt);
		userTxt.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginDAO dao = new LoginDAO();
				if(dao.validar(userTxt.getText(), passwordTxt.getText())) {
					
					TelaMenuPrincipal principal = new TelaMenuPrincipal();
					frmLogin.dispose();
					principal.getFrmTelaMenuPrincipal().setVisible(true);
				}
				
			}
		});
		btnLogar.setBounds(12, 158, 175, 38);
		frmLogin.getContentPane().add(btnLogar);
		
		passwordTxt = new JPasswordField();
		passwordTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(passwordTxt.getText().equals("Senha")) {
					passwordTxt.setText(null);
				}
			}
		});
		passwordTxt.setText("Senha");
		passwordTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordTxt.setText(null);
			}
		});
		passwordTxt.setToolTipText("Senha");
		passwordTxt.setBounds(12, 126, 175, 20);
		frmLogin.getContentPane().add(passwordTxt);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/user_passw_icon.png")));
		label.setBounds(62, 12, 70, 70);
		frmLogin.getContentPane().add(label);
		
		
	}
}
