package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ucam.enzo.model.DAO.ModalidadeDAO;
import br.ucam.enzo.model.bean.Modalidade;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroModalidade {

	private JFrame frmCadastroDeModalidade;
	private JTextField nomeTxt;
	private JTextField horarioTxt;
	private JTextField valorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroModalidade window = new TelaCadastroModalidade();
					window.frmCadastroDeModalidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroModalidade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeModalidade = new JFrame();
		frmCadastroDeModalidade.setTitle("Cadastro de modalidade");
		frmCadastroDeModalidade.setBounds(100, 100, 450, 300);
		frmCadastroDeModalidade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeModalidade.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 84, 14);
		frmCadastroDeModalidade.getContentPane().add(lblNome);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(8, 29, 254, 20);
		frmCadastroDeModalidade.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 60, 28, 20);
		frmCadastroDeModalidade.getContentPane().add(comboBox);
		
		JLabel lblProfessor = new JLabel("Professor: ");
		lblProfessor.setBounds(10, 63, 63, 14);
		frmCadastroDeModalidade.getContentPane().add(lblProfessor);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio: ");
		lblHorrio.setBounds(10, 88, 46, 14);
		frmCadastroDeModalidade.getContentPane().add(lblHorrio);
		
		horarioTxt = new JTextField();
		horarioTxt.setBounds(10, 106, 117, 20);
		frmCadastroDeModalidade.getContentPane().add(horarioTxt);
		horarioTxt.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setBounds(10, 137, 46, 14);
		frmCadastroDeModalidade.getContentPane().add(lblValor);
		
		valorTxt = new JTextField();
		valorTxt.setBounds(8, 158, 86, 20);
		frmCadastroDeModalidade.getContentPane().add(valorTxt);
		valorTxt.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modalidade modalidade = new Modalidade();
				ModalidadeDAO dao = new ModalidadeDAO();
				
				modalidade.setNome(nomeTxt.getText());
				modalidade.setHorario(horarioTxt.getText());
				modalidade.setProfessor(null);
				modalidade.setValor(Double.parseDouble(valorTxt.getText()));
				
				dao.create(modalidade);
				
				
			}
		});
		btnCadastrar.setBounds(10, 204, 414, 23);
		frmCadastroDeModalidade.getContentPane().add(btnCadastrar);
	}

}
