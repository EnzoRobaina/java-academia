package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.ucam.connection.ConnectionFactory;
import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.bean.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
		frmCadastroDeAluno.setBounds(100, 100, 450, 220);
		frmCadastroDeAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAluno.getContentPane().setLayout(null);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 22, 424, 20);
		frmCadastroDeAluno.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 4, 46, 14);
		frmCadastroDeAluno.getContentPane().add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento: ");
		lblDataDeNascimento.setBounds(10, 49, 185, 14);
		frmCadastroDeAluno.getContentPane().add(lblDataDeNascimento);
		
		dataNascTxt = new JTextField();
		dataNascTxt.setBounds(10, 69, 126, 20);
		frmCadastroDeAluno.getContentPane().add(dataNascTxt);
		dataNascTxt.setColumns(10);
		
		JLabel lblModalidade = new JLabel("Modalidade:");
		lblModalidade.setBounds(10, 100, 126, 14);
		frmCadastroDeAluno.getContentPane().add(lblModalidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escolha\r\n");
		comboBox.setBounds(11, 116, 126, 20);
		frmCadastroDeAluno.getContentPane().add(comboBox);
		
		try {
			PreparedStatement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			List<Aluno> alunos = new ArrayList<>();
			
			ConnectionFactory.conectar();
			stmt = ConnectionFactory.con.prepareStatement("select nome from modalidade");
			rs = stmt.executeQuery();
				
			while(rs.next()) {
					
				comboBox.addItem(rs.getString("nome"));
					
				}
					
				
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			ConnectionFactory.desconectar();
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
		btnCadastrar.setBounds(10, 144, 424, 36);
		frmCadastroDeAluno.getContentPane().add(btnCadastrar);
	}
}
