package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ModalidadeDAO;
import br.ucam.enzo.model.bean.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaCadastroAluno {

	private JFrame frmCadastroDeAluno;
	public JFrame getFrmCadastroDeAluno() {
		return frmCadastroDeAluno;
	}

	private JTextField nomeTxt;
	private JTextField dataNascTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno window = new TelaCadastroAluno();
					window.frmCadastroDeAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeAluno = new JFrame();
		frmCadastroDeAluno.setTitle("Cadastro de aluno");
		frmCadastroDeAluno.setResizable(false);
		frmCadastroDeAluno.setBounds(100, 100, 340, 220);
		frmCadastroDeAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeAluno.getContentPane().setLayout(null);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 22, 315, 20);
		frmCadastroDeAluno.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 4, 46, 14);
		frmCadastroDeAluno.getContentPane().add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento: ");
		lblDataDeNascimento.setBounds(10, 49, 185, 14);
		frmCadastroDeAluno.getContentPane().add(lblDataDeNascimento);
		
		//FORMATO DE DATA
		
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		JFormattedTextField dataNascTxt = new JFormattedTextField(format);
		dataNascTxt.setBounds(10, 69, 126, 20);
		frmCadastroDeAluno.getContentPane().add(dataNascTxt);
		dataNascTxt.setColumns(10);
		
		try {
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
	        dateMask.install(dataNascTxt);
	    } catch (ParseException ex) {
	    	JOptionPane.showMessageDialog(null, "Data Inválida");
	      }
		
		JLabel lblModalidade = new JLabel("Modalidade:");
		lblModalidade.setBounds(10, 100, 126, 14);
		frmCadastroDeAluno.getContentPane().add(lblModalidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escolha\r\n");
		comboBox.setBounds(11, 116, 126, 20);
		frmCadastroDeAluno.getContentPane().add(comboBox);
		
		//PREENCHENDO COMBOBOX
		ModalidadeDAO mDao = new ModalidadeDAO();
		ArrayList modalidades = mDao.fillComboModalidades();
		
		for(int i = 0; i<modalidades.size();i++) {
			comboBox.addItem(modalidades.get(i));
		}
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno a = new Aluno();
				AlunoDAO dao = new AlunoDAO();
				
				a.setNome(nomeTxt.getText());
				a.setDataNasc(dataNascTxt.getText());
				a.setModalidade(comboBox.getSelectedItem().toString());
				dao.create(a);
				
				//JOptionPane.showMessageDialog(null, "teste");
			}
		});
		btnCadastrar.setBounds(10, 144, 315, 36);
		frmCadastroDeAluno.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroAluno.class.getResource("/imagens/user_icon.png")));
		lblNewLabel.setBounds(230, 55, 76, 76);
		frmCadastroDeAluno.getContentPane().add(lblNewLabel);
	}
}
