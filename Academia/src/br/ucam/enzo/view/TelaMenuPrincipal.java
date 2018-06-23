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

public class TelaMenuPrincipal {

	private JFrame frmTelaMenuPrincipal;

	public JFrame getFrmTelaMenuPrincipal() {
		return frmTelaMenuPrincipal;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal window = new TelaMenuPrincipal();
					window.frmTelaMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaMenuPrincipal = new JFrame();
		frmTelaMenuPrincipal.setTitle("Menu Principal");
		frmTelaMenuPrincipal.setBounds(100, 100, 450, 300);
		frmTelaMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTelaMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem cadastrarAluno = new JMenuItem("Cadastrar Aluno");
		cadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno cadastroAluno = new TelaCadastroAluno();
				cadastroAluno.getFrmCadastroDeAluno().setVisible(true);
				
			}
		});
		mnArquivo.add(cadastrarAluno);
		
		JMenuItem cadastrarProfessor = new JMenuItem("Cadastrar Professor");
		cadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroProfessor cadastroProfessor = new TelaCadastroProfessor();
				cadastroProfessor.getFrmCadastroDeProfessor().setVisible(true);
				
			}
		});
		mnArquivo.add(cadastrarProfessor);
		
		JMenuItem cadastrarModalidade = new JMenuItem("Cadastrar Modalidade");
		cadastrarModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroModalidade cadastroModalidade = new TelaCadastroModalidade();
				cadastroModalidade.getFrmCadastroDeModalidade().setVisible(true);
			}
		});
		mnArquivo.add(cadastrarModalidade);
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(sair);
		
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		JMenuItem mntmAlunos = new JMenuItem("Alunos");
		mntmAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaConsultaAluno consultaAluno = new TelaConsultaAluno();
				consultaAluno.getFrmConsultaAlunos().setVisible(true);
			}
		});
		mnConsultar.add(mntmAlunos);
		
		JMenuItem mntmProfessores = new JMenuItem("Professores");
		mntmProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaProfessor consultaProfessor = new TelaConsultaProfessor();
				consultaProfessor.getFrmConsultaProfessores().setVisible(true);
			}
		});
		mnConsultar.add(mntmProfessores);
		
		JMenuItem mntmModalidades = new JMenuItem("Modalidades");
		mntmModalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaModalidade consultaModalidade = new TelaConsultaModalidade();
				consultaModalidade.getFrmConsultaModalidades().setVisible(true);
			}
		});
		mnConsultar.add(mntmModalidades);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaSobre sobre = new TelaSobre();
				sobre.getFrmSobre().setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
		frmTelaMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/imagens/sport_icon_set2.png")));
		label.setBounds(0, 11, 430, 230);
		frmTelaMenuPrincipal.getContentPane().add(label);
	}
}
