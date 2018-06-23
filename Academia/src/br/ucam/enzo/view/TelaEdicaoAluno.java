package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.bean.Aluno;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEdicaoAluno {

	private JFrame frmTelaEdicaoAluno;
	private JTextField nomeTxt;
	private JTextField dataNascTxt;
	private JTextField modalidadeTxt;
	private Aluno aluno;
	
	public JFrame getFrmTelaEdicaoAluno() {
		return frmTelaEdicaoAluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		//System.out.println(this.aluno.getNome());
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoAluno window = new TelaEdicaoAluno();
					window.frmTelaEdicaoAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public TelaEdicaoAluno() {
		initialize();
	}
	
	public TelaEdicaoAluno(Aluno aluno) {
		 
		this.aluno = aluno;
			
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		System.out.println(aluno.getNome());
		frmTelaEdicaoAluno = new JFrame();
		frmTelaEdicaoAluno.setTitle("Tela Edi\u00E7\u00E3o Aluno");
		frmTelaEdicaoAluno.setBounds(100, 100, 450, 263);
		frmTelaEdicaoAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaEdicaoAluno.getContentPane().setLayout(null);
		
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		frmTelaEdicaoAluno.getContentPane().add(lblNome);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 28, 257, 20);
		frmTelaEdicaoAluno.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data nasc.:");
		lblDataNasc.setBounds(10, 55, 90, 14);
		frmTelaEdicaoAluno.getContentPane().add(lblDataNasc);
		
		dataNascTxt = new JTextField();
		dataNascTxt.setBounds(10, 73, 133, 20);
		frmTelaEdicaoAluno.getContentPane().add(dataNascTxt);
		dataNascTxt.setColumns(10);
		
		JLabel lblModalidade = new JLabel("Modalidade: ");
		lblModalidade.setBounds(10, 101, 90, 14);
		frmTelaEdicaoAluno.getContentPane().add(lblModalidade);
		
		modalidadeTxt = new JTextField();
		modalidadeTxt.setBounds(10, 118, 149, 20);
		frmTelaEdicaoAluno.getContentPane().add(modalidadeTxt);
		modalidadeTxt.setColumns(10);
		
		
		
		nomeTxt.setText(aluno.getNome());
		dataNascTxt.setText(aluno.getDataNasc());
		modalidadeTxt.setText(aluno.getModalidade());
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoDAO dao = new AlunoDAO();
				
				aluno.setId(aluno.getId());
				aluno.setNome(nomeTxt.getText());
				aluno.setDataNasc(dataNascTxt.getText());
				aluno.setModalidade(modalidadeTxt.getText());
				
				dao.update(aluno);
				//JOptionPane.showMessageDialog(null, "teste");
			}
		});
		btnSalvar.setBounds(10, 171, 414, 39);
		frmTelaEdicaoAluno.getContentPane().add(btnSalvar);
	}

}
