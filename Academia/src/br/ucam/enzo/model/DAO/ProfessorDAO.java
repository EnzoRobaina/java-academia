package br.ucam.enzo.model.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import br.ucam.connection.ConnectionFactory;

import br.ucam.enzo.model.bean.Professor;

public class ProfessorDAO {

	public void create(Professor prof) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
			ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("insert into professor(nome, data_nasc, salario, modalidade_fk) values(?,?,?,?)");
			stmt.setString(1, prof.getNome());
			stmt.setString(2, prof.getDataNasc());
			stmt.setDouble(3, prof.getSalario());
			stmt.setString(4,  null);
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Professor "+prof.getNome()+" inserido com sucesso!");
			
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			
		} finally {
			
			ConnectionFactory.desconectar();
		}
		
		
	}
}

