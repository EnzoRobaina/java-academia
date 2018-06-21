package br.ucam.enzo.model.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import br.ucam.connection.ConnectionFactory;

import br.ucam.enzo.model.bean.Modalidade;

public class ModalidadeDAO {

	public void create(Modalidade modalidade) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
			ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("insert into modalidade(nome, horario, valor, professor_fk) values(?,?,?,?)");
			stmt.setString(1, modalidade.getNome());
			stmt.setString(2, modalidade.getHorario());
			stmt.setDouble(3, modalidade.getValor());
			stmt.setString(4,  null);
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Modalidade "+modalidade.getNome()+" inserido com sucesso!");
			
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			
		} finally {
			
			ConnectionFactory.desconectar();
		}
		
		
	}
}

