package br.ucam.enzo.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ucam.connection.ConnectionFactory;

import br.ucam.enzo.model.bean.Aluno;

public class AlunoDAO {

	public void create(Aluno aluno) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
			ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("insert into aluno(nome, data_nasc, modalidade_fk) values(?,?,?)");
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getDataNasc());
			stmt.setString(3,  null);
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno "+aluno.getNome()+" inserido com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
		} finally {
			//ConnectionFactory.closeConnection((ConnectionFactory) con, stmt);
			//JOptionPane.showMessageDialog(null, "Conexão fechada!");
			ConnectionFactory.desconectar();
		}
		
		
	}
	
	public List<Aluno> listar(){
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("select * from aluno");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Aluno a = new Aluno();
				a.setId(rs.getInt("id"));
				a.setDataNasc(rs.getString("data_nasc"));
				a.setModalidade(rs.getString("modalidade_fk"));
				a.setNome(rs.getString("nome"));
				
				alunos.add(a);
				
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
		} finally {
			ConnectionFactory.desconectar();
		}
		
		return alunos;
		
	}
}

