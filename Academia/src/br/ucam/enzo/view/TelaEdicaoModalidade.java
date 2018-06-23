package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ModalidadeDAO;
import br.ucam.enzo.model.DAO.ProfessorDAO;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Modalidade;

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
import javax.swing.DefaultComboBoxModel;

public class TelaEdicaoModalidade {

	private JFrame frmEdicaoDeModalidade;
	private JTextField valorTxt;
	private Modalidade modalidade;
	
	public JFrame getFrmEdicaoDeModalidade() {
		return frmEdicaoDeModalidade;
	}

	private JTextField nomeTxt;
	private JTextField dataNascTxt;
	
	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoModalidade window = new TelaEdicaoModalidade();
					window.frmEdicaoDeModalidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEdicaoModalidade() {
		initialize();
	}
	
	public TelaEdicaoModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEdicaoDeModalidade = new JFrame();
		frmEdicaoDeModalidade.setTitle("Edicao de modalidade");
		frmEdicaoDeModalidade.setResizable(false);
		frmEdicaoDeModalidade.setBounds(100, 100, 340, 265);
		frmEdicaoDeModalidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEdicaoDeModalidade.getContentPane().setLayout(null);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(10, 22, 315, 20);
		frmEdicaoDeModalidade.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 4, 46, 14);
		frmEdicaoDeModalidade.getContentPane().add(lblNome);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(10, 142, 126, 14);
		frmEdicaoDeModalidade.getContentPane().add(lblProfessor);
		
		JComboBox professorComboBox = new JComboBox();
		professorComboBox.setToolTipText("Escolha\r\n");
		professorComboBox.setBounds(10, 159, 126, 20);
		frmEdicaoDeModalidade.getContentPane().add(professorComboBox);
		
		//PREENCHENDO COMBOBOX
		ProfessorDAO pDao = new ProfessorDAO();
		ArrayList professores = pDao.fillComboProfessores();
		
		for(int i = 0; i<professores.size();i++) {
			professorComboBox.addItem(professores.get(i));
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEdicaoModalidade.class.getResource("/imagens/sport_icon.png")));
		lblNewLabel.setBounds(230, 55, 76, 76);
		frmEdicaoDeModalidade.getContentPane().add(lblNewLabel);
		
		JComboBox horarioComboBox = new JComboBox();
		horarioComboBox.setModel(new DefaultComboBoxModel(new String[] {"Manh\u00E3", "Tarde", "Noite"}));
		horarioComboBox.setBounds(10, 117, 126, 20);
		frmEdicaoDeModalidade.getContentPane().add(horarioComboBox);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(10, 100, 46, 14);
		frmEdicaoDeModalidade.getContentPane().add(lblHorrio);
		
		valorTxt = new JTextField();
		valorTxt.setBounds(10, 72, 86, 20);
		frmEdicaoDeModalidade.getContentPane().add(valorTxt);
		valorTxt.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 53, 46, 14);
		frmEdicaoDeModalidade.getContentPane().add(lblValor);
		
		nomeTxt.setText(modalidade.getNome());
		valorTxt.setText(String.valueOf(modalidade.getValor()));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ModalidadeDAO dao = new ModalidadeDAO();
				
				modalidade.setId(modalidade.getId());
				modalidade.setNome(nomeTxt.getText());
				modalidade.setValor(Double.parseDouble(valorTxt.getText()));
				modalidade.setHorario(horarioComboBox.getSelectedItem().toString());
				modalidade.setProfessor(professorComboBox.getSelectedItem().toString());
				dao.update(modalidade);
				
				//JOptionPane.showMessageDialog(null, "teste");
			}
		});
		btnSalvar.setBounds(10, 190, 315, 36);
		frmEdicaoDeModalidade.getContentPane().add(btnSalvar);
		
	}
}
