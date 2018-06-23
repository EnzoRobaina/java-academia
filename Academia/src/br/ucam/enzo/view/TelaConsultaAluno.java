package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.bean.Aluno;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaConsultaAluno {

	private JFrame frmConsultaAlunos;
	private JTable table;
	private JTextField nomeTxt;

	public JFrame getFrmConsultaAlunos() {
		return frmConsultaAlunos;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaAluno window = new TelaConsultaAluno();
					window.frmConsultaAlunos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaAlunos = new JFrame();
		frmConsultaAlunos.setResizable(false);
		frmConsultaAlunos.setTitle("Consulta Alunos");
		frmConsultaAlunos.setBounds(100, 100, 455, 405);
		frmConsultaAlunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaAlunos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 429, 274);
		frmConsultaAlunos.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Modelo da table
		DefaultTableModel defaultModel  = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Data nasc.", "Modalidade"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
			
		
		
		scrollPane.setViewportView(table);
		
		JButton btnListar = new JButton("Listar todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				defaultModel.setNumRows(0);
				AlunoDAO dao = new AlunoDAO();
				for(Aluno a: dao.listar()) {
					defaultModel.addRow(new Object [] {
							a.getId(),
							a.getNome(),
							a.getDataNasc(),
							a.getModalidade()
					});
				}
				table.setModel(defaultModel);
				
				//dao.listar();
			}
		});
		btnListar.setBounds(10, 11, 108, 23);
		frmConsultaAlunos.getContentPane().add(btnListar);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(82, 59, 185, 20);
		frmConsultaAlunos.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JButton btnBuscaPorNome = new JButton("Buscar");
		btnBuscaPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				defaultModel.setNumRows(0);
				AlunoDAO dao = new AlunoDAO();
				for(Aluno a: dao.buscaNome(nomeTxt.getText())) {
					defaultModel.addRow(new Object [] {
							a.getId(),
							a.getNome(),
							a.getDataNasc(),
							a.getModalidade()
					});
				}
				table.setModel(defaultModel);
				
			}
		});
		btnBuscaPorNome.setBounds(277, 58, 116, 23);
		frmConsultaAlunos.getContentPane().add(btnBuscaPorNome);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
				}
				else {
					//table.removeRowSelectionInterval(table.getSelectedRow(), table.getSelectedRow());
					System.out.println(table.getValueAt(table.getSelectedRow(), 0));
					/*System.out.println((int)table.getValueAt(table.getSelectedRow(), 0));
					System.out.println(table.getValueAt(table.getSelectedRow(), 1).toString());
					System.out.println(table.getValueAt(table.getSelectedRow(), 2).toString());
					System.out.println(table.getValueAt(table.getSelectedRow(), 3).toString()); */
					AlunoDAO dao = new AlunoDAO();
					
					Aluno a = new Aluno();
					a.setId((int)table.getValueAt(table.getSelectedRow(), 0));
					a.setNome(table.getValueAt(table.getSelectedRow(), 1).toString());
					a.setDataNasc(table.getValueAt(table.getSelectedRow(), 2).toString());
					a.setModalidade(table.getValueAt(table.getSelectedRow(), 3).toString());
					
					System.out.println(a.getId());
					System.out.println(a.getNome());
					System.out.println(a.getDataNasc());
					System.out.println(a.getModalidade());
					
					TelaEdicaoAluno editaAluno = new TelaEdicaoAluno(a);
					
					/*System.out.println("get from telaconsultaaluno");
					System.out.println(editaAluno.getAluno().getNome());*/
					editaAluno.getFrmTelaEdicaoAluno().setVisible(true);
					
					//dao.update(a);
				}
			}
		});
		btnEditar.setBounds(168, 11, 108, 23);
		frmConsultaAlunos.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoDAO dao = new AlunoDAO();
				
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
				}
				else {
					dao.delete((int)table.getValueAt(table.getSelectedRow(), 0));
				}
				
				
				
			}
		});
		btnExcluir.setBounds(331, 11, 108, 23);
		frmConsultaAlunos.getContentPane().add(btnExcluir);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 62, 40, 14);
		frmConsultaAlunos.getContentPane().add(lblNome);
	}
}
