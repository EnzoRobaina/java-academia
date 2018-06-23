package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ucam.enzo.model.DAO.AlunoDAO;
import br.ucam.enzo.model.DAO.ModalidadeDAO;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Modalidade;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaConsultaModalidade {

	private JFrame frmConsultaModalidades;
	private JTable table;
	private JTextField nomeTxt;

	public JFrame getFrmConsultaModalidades() {
		return frmConsultaModalidades;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaModalidade window = new TelaConsultaModalidade();
					window.frmConsultaModalidades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaModalidade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaModalidades = new JFrame();
		frmConsultaModalidades.setResizable(false);
		frmConsultaModalidades.setTitle("Consulta Modalidades");
		frmConsultaModalidades.setBounds(100, 100, 455, 405);
		frmConsultaModalidades.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaModalidades.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 429, 274);
		frmConsultaModalidades.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Modelo da table
		DefaultTableModel defaultModel  = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Horário", "Valor", "Professor"
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
				ModalidadeDAO dao = new ModalidadeDAO();
				for(Modalidade m: dao.listar()) {
					defaultModel.addRow(new Object [] {
							m.getId(),
							m.getNome(),
							m.getHorario(),
							m.getValor(),
							m.getProfessor()
					});
				}
				table.setModel(defaultModel);
				
				//dao.listar();
			}
		});
		btnListar.setBounds(10, 11, 108, 23);
		frmConsultaModalidades.getContentPane().add(btnListar);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(82, 59, 185, 20);
		frmConsultaModalidades.getContentPane().add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JButton btnBuscaPorNome = new JButton("Buscar");
		btnBuscaPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				defaultModel.setNumRows(0);
				ModalidadeDAO dao = new ModalidadeDAO();
				for(Modalidade m: dao.buscaNome(nomeTxt.getText())) {
					defaultModel.addRow(new Object [] {
							m.getId(),
							m.getNome(),
							m.getHorario(),
							m.getValor(),
							m.getProfessor()
					});
				}
				table.setModel(defaultModel);
				
			}
		});
		btnBuscaPorNome.setBounds(277, 58, 116, 23);
		frmConsultaModalidades.getContentPane().add(btnBuscaPorNome);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
				}
				else {
					System.out.println(table.getValueAt(table.getSelectedRow(), 0));
					ModalidadeDAO dao = new ModalidadeDAO();
					
					Modalidade m = new Modalidade();
					m.setId((int)table.getValueAt(table.getSelectedRow(), 0));
					m.setNome(table.getValueAt(table.getSelectedRow(), 1).toString());
					m.setHorario(table.getValueAt(table.getSelectedRow(), 2).toString());
					String valor = table.getValueAt(table.getSelectedRow(), 3).toString();
					m.setValor(Double.parseDouble(valor));
					m.setProfessor(table.getValueAt(table.getSelectedRow(), 4).toString());
					
					TelaEdicaoModalidade editaModalidade = new TelaEdicaoModalidade(m);
		
					editaModalidade.getFrmEdicaoDeModalidade().setVisible(true);
					
					//dao.update(a);
				}
			}
		});
		btnEditar.setBounds(168, 11, 108, 23);
		frmConsultaModalidades.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModalidadeDAO dao = new ModalidadeDAO();
				
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
				}
				else {
					dao.delete((int)table.getValueAt(table.getSelectedRow(), 0));
				}
				
				
				
			}
		});
		btnExcluir.setBounds(331, 11, 108, 23);
		frmConsultaModalidades.getContentPane().add(btnExcluir);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 62, 40, 14);
		frmConsultaModalidades.getContentPane().add(lblNome);
	}
}
