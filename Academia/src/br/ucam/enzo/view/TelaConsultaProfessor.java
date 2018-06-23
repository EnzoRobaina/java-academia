package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ProfessorDAO;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Professor;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaConsultaProfessor {

	private JFrame frmConsultaProfessores;
	private JTable table;
	private JTextField nomeTxt;

	public JFrame getFrmConsultaProfessores() {
		return frmConsultaProfessores;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaProfessor window = new TelaConsultaProfessor();
					window.frmConsultaProfessores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaProfessores = new JFrame();
		frmConsultaProfessores.setResizable(false);
		frmConsultaProfessores.setTitle("Consulta Professores");
		frmConsultaProfessores.setBounds(100, 100, 455, 405);
		frmConsultaProfessores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaProfessores.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 429, 274);
		frmConsultaProfessores.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Modelo da table
		DefaultTableModel defaultModel  = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Data nasc.", "Salario"
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
				ProfessorDAO dao = new ProfessorDAO();
				for(Professor prof: dao.listar()) {
					defaultModel.addRow(new Object [] {
							prof.getId(),
							prof.getNome(),
							prof.getDataNasc(),
							prof.getSalario()
					});
				}
				table.setModel(defaultModel);
				
				//dao.listar();
			}
		});
		btnListar.setBounds(10, 11, 108, 23);
		frmConsultaProfessores.getContentPane().add(btnListar);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(82, 59, 185, 20);
		frmConsultaProfessores.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JButton btnBuscaPorNome = new JButton("Buscar");
		btnBuscaPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				defaultModel.setNumRows(0);
				ProfessorDAO dao = new ProfessorDAO();
				for(Professor prof: dao.buscaNome(nomeTxt.getText())) {
					defaultModel.addRow(new Object [] {
							prof.getId(),
							prof.getNome(),
							prof.getDataNasc(),
							prof.getSalario()
					});
				}
				table.setModel(defaultModel);
				
			}
		});
		btnBuscaPorNome.setBounds(277, 58, 116, 23);
		frmConsultaProfessores.getContentPane().add(btnBuscaPorNome);
		
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
					ProfessorDAO dao = new ProfessorDAO();
					
					Professor prof = new Professor();
					prof.setId((int)table.getValueAt(table.getSelectedRow(), 0));
					prof.setNome(table.getValueAt(table.getSelectedRow(), 1).toString());
					prof.setDataNasc(table.getValueAt(table.getSelectedRow(), 2).toString());
					String salario = table.getValueAt(table.getSelectedRow(), 3).toString();
					prof.setSalario(Double.parseDouble(salario));
					
					//System.out.println("SALARIO"+salario);
					
					System.out.println(prof.getId());
					System.out.println(prof.getNome());
					System.out.println(prof.getDataNasc());
					System.out.println(prof.getSalario());
					
					TelaEdicaoProfessor editaProfessor = new TelaEdicaoProfessor(prof);
					
					/*System.out.println("get from telaconsultaaluno");
					System.out.println(editaAluno.getAluno().getNome());*/
					editaProfessor.getFrmTelaEdicaoProfessor().setVisible(true);
					
					//dao.update(a);
				}
			}
		});
		btnEditar.setBounds(168, 11, 108, 23);
		frmConsultaProfessores.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfessorDAO dao = new ProfessorDAO();
				
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
				}
				else {
					dao.delete((int)table.getValueAt(table.getSelectedRow(), 0));
				}
				
				
				
			}
		});
		btnExcluir.setBounds(331, 11, 108, 23);
		frmConsultaProfessores.getContentPane().add(btnExcluir);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 62, 40, 14);
		frmConsultaProfessores.getContentPane().add(lblNome);
	}
}
