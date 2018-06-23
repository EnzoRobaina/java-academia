package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.ucam.enzo.model.DAO.ProfessorDAO;
import br.ucam.enzo.model.bean.Professor;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OLDTelaCadastroProfessor {

	private JFrame frmCadastroDeProfessor;
	private JTextField nomeTxt;
	private JTextField dataNascTxt;
	private JTextField salarioTxt;

	public JFrame getFrmCadastroDeProfessor() {
		return frmCadastroDeProfessor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OLDTelaCadastroProfessor window = new OLDTelaCadastroProfessor();
					window.frmCadastroDeProfessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OLDTelaCadastroProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeProfessor = new JFrame();
		frmCadastroDeProfessor.setResizable(false);
		frmCadastroDeProfessor.setTitle("Cadastro de professor");
		frmCadastroDeProfessor.setBounds(100, 100, 450, 241);
		frmCadastroDeProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeProfessor.getContentPane().setLayout(null);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 26, 424, 20);
		frmCadastroDeProfessor.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 8, 46, 14);
		frmCadastroDeProfessor.getContentPane().add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento: ");
		lblDataDeNascimento.setBounds(10, 56, 159, 14);
		frmCadastroDeProfessor.getContentPane().add(lblDataDeNascimento);
		
		dataNascTxt = new JTextField();
		dataNascTxt.setBounds(9, 72, 124, 20);
		frmCadastroDeProfessor.getContentPane().add(dataNascTxt);
		dataNascTxt.setColumns(10);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio: ");
		lblSalrio.setBounds(13, 98, 46, 14);
		frmCadastroDeProfessor.getContentPane().add(lblSalrio);
		
		salarioTxt = new JTextField();
		salarioTxt.setBounds(10, 118, 97, 20);
		frmCadastroDeProfessor.getContentPane().add(salarioTxt);
		salarioTxt.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Professor prof = new Professor();
				ProfessorDAO dao = new ProfessorDAO();
				
				prof.setNome(nomeTxt.getText());
				prof.setDataNasc(dataNascTxt.getText());
				prof.setSalario(Double.parseDouble(salarioTxt.getText()));
				
				dao.create(prof);
				
				
			}
		});
		btnCadastrar.setBounds(10, 173, 424, 33);
		frmCadastroDeProfessor.getContentPane().add(btnCadastrar);
	}

}
