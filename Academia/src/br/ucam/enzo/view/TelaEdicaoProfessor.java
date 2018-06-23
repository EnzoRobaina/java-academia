package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ProfessorDAO;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Professor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;

public class TelaEdicaoProfessor {

	private JFrame frmTelaEdicaoProfessor;
	private JTextField nomeTxt;
	private Professor prof;
	private JTextField salarioTxt;
	
	public JFrame getFrmTelaEdicaoProfessor() {
		return frmTelaEdicaoProfessor;
	}

	
	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoProfessor window = new TelaEdicaoProfessor();
					window.frmTelaEdicaoProfessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public TelaEdicaoProfessor() {
		initialize();
	}
	
	public TelaEdicaoProfessor(Professor prof) {
		 
		this.prof = prof;
			
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		System.out.println(prof.getSalario());
		frmTelaEdicaoProfessor = new JFrame();
		frmTelaEdicaoProfessor.setResizable(false);
		frmTelaEdicaoProfessor.setTitle("Tela Edi\u00E7\u00E3o Professor");
		frmTelaEdicaoProfessor.setBounds(100, 100, 330, 214);
		frmTelaEdicaoProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaEdicaoProfessor.getContentPane().setLayout(null);
		
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 8, 46, 14);
		frmTelaEdicaoProfessor.getContentPane().add(lblNome);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(6, 23, 315, 20);
		frmTelaEdicaoProfessor.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data nasc.:");
		lblDataNasc.setBounds(10, 46, 90, 14);
		frmTelaEdicaoProfessor.getContentPane().add(lblDataNasc);
		
		//FORMATA A DATA
		
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
		JFormattedTextField dataNascTxt = new JFormattedTextField(format);
		dataNascTxt.setBounds(7, 61, 133, 20);
		frmTelaEdicaoProfessor.getContentPane().add(dataNascTxt);
		dataNascTxt.setColumns(10);
		
		try {
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
	        dateMask.install(dataNascTxt);
	    } catch (ParseException ex) {
	    	JOptionPane.showMessageDialog(null, "Data Inválida");
	      }
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(10, 85, 90, 14);
		frmTelaEdicaoProfessor.getContentPane().add(lblSalario);
		
		salarioTxt = new JTextField();
		salarioTxt.setBounds(7, 101, 86, 20);
		frmTelaEdicaoProfessor.getContentPane().add(salarioTxt);
		salarioTxt.setColumns(10);
		
		nomeTxt.setText(prof.getNome());
		dataNascTxt.setText(prof.getDataNasc());
		salarioTxt.setText(String.valueOf(prof.getSalario()));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorDAO dao = new ProfessorDAO();
				
				prof.setId(prof.getId());
				prof.setNome(nomeTxt.getText());
				prof.setDataNasc(dataNascTxt.getText());
				prof.setSalario(Double.parseDouble(salarioTxt.getText()));
				
				dao.update(prof);
				//JOptionPane.showMessageDialog(null, "teste");
			}
		});
		btnSalvar.setBounds(6, 139, 313, 39);
		frmTelaEdicaoProfessor.getContentPane().add(btnSalvar);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEdicaoProfessor.class.getResource("/imagens/user_icon.png")));
		lblNewLabel.setBounds(236, 50, 76, 76);
		frmTelaEdicaoProfessor.getContentPane().add(lblNewLabel);
		
		
	}
}
