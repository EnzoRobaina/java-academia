package br.ucam.enzo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaAluno {

	private JFrame frmConsultaAlunos;
	private JTable tableAlunos;

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
		frmConsultaAlunos.setBounds(100, 100, 450, 300);
		frmConsultaAlunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaAlunos.getContentPane().setLayout(null);
		
		tableAlunos = new JTable();
		tableAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Data de nascimento", "Modalidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableAlunos.getColumnModel().getColumn(2).setPreferredWidth(107);
		tableAlunos.getColumnModel().getColumn(3).setPreferredWidth(84);
		tableAlunos.setBounds(10, 11, 424, 250);
		frmConsultaAlunos.getContentPane().add(tableAlunos);
	}
}
