package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;

	public JFrame getFrmMenuPrincipal() {
		return frmMenuPrincipal;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 450, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem cadastrarAluno = new JMenuItem("Cadastrar Aluno");
		mnArquivo.add(cadastrarAluno);
		
		JMenuItem cadastrarProfessor = new JMenuItem("Cadastrar Professor");
		mnArquivo.add(cadastrarProfessor);
		
		JMenuItem cadastrarModalidade = new JMenuItem("Cadastrar Modalidade");
		mnArquivo.add(cadastrarModalidade);
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(sair);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Enzo\\Documents\\\u00EDndice.jpg"));
		lblNewLabel.setBounds(69, 22, 276, 183);
		frmMenuPrincipal.getContentPane().add(lblNewLabel);
	}
}
