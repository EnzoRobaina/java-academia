package br.ucam.enzo.view;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ProfessorDAO;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

public class TelaCadastroProfessor {

	private JFrame frmCadastroDeProfessor;
	
	public JFrame getFrmCadastroDeProfessor() {
		return frmCadastroDeProfessor;
	}

	private JTextField nomeTxt;
	private JTextField salarioTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfessor window = new TelaCadastroProfessor();
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
	public TelaCadastroProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeProfessor = new JFrame();
		frmCadastroDeProfessor.setTitle("Cadastro de professor");
		frmCadastroDeProfessor.setResizable(false);
		frmCadastroDeProfessor.setBounds(100, 100, 340, 220);
		frmCadastroDeProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeProfessor.getContentPane().setLayout(null);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 22, 315, 20);
		frmCadastroDeProfessor.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 4, 46, 14);
		frmCadastroDeProfessor.getContentPane().add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento: ");
		lblDataDeNascimento.setBounds(10, 49, 185, 14);
		frmCadastroDeProfessor.getContentPane().add(lblDataDeNascimento);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroProfessor.class.getResource("/imagens/user_icon.png")));
		lblNewLabel.setBounds(230, 55, 76, 76);
		frmCadastroDeProfessor.getContentPane().add(lblNewLabel);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio: ");
		lblSalrio.setBounds(11, 97, 46, 14);
		frmCadastroDeProfessor.getContentPane().add(lblSalrio);
		
		salarioTxt = new JTextField();
		salarioTxt.setBounds(11, 114, 100, 20);
		frmCadastroDeProfessor.getContentPane().add(salarioTxt);
		salarioTxt.setColumns(10);
		
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		JFormattedTextField dataTxt = new JFormattedTextField(format);
		dataTxt.setColumns(10);
		dataTxt.setBounds(12, 69, 97, 20);
		
		try {
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
	        dateMask.install(dataTxt);
	    } catch (ParseException ex) {
	    	JOptionPane.showMessageDialog(null, "Data Inválida");
	      }
		frmCadastroDeProfessor.getContentPane().add(dataTxt);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(dataTxt.getText());
				Professor prof = new Professor();
				ProfessorDAO dao = new ProfessorDAO();
				
				prof.setNome(nomeTxt.getText());
				prof.setDataNasc(dataTxt.getText());
				prof.setSalario(Double.parseDouble(salarioTxt.getText()));
				dao.create(prof);
				
				//JOptionPane.showMessageDialog(null, "teste");
			}
		});
		
		btnCadastrar.setBounds(10, 144, 315, 36);
		frmCadastroDeProfessor.getContentPane().add(btnCadastrar);
		
	}
}
