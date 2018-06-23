package br.ucam.enzo.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Professor;

public class ProfessorDAO {

	public void create(Professor prof) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
			ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("insert into professor(nome, data_nasc, salario) values(?,?,?)");
			stmt.setString(1, prof.getNome());
			stmt.setString(2, prof.getDataNasc());
			stmt.setDouble(3, prof.getSalario());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Professor "+prof.getNome()+" inserido com sucesso!");
			
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			
		} finally {
			
			ConnectionFactory.desconectar();
		}
		
		
	}
	
	public void update(Professor prof) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
		ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("update professor set nome = ?, data_nasc = ?, salario = ? where id = ?");
			stmt.setString(1, prof.getNome());
			stmt.setString(2, prof.getDataNasc());
			stmt.setDouble(3,  prof.getSalario());
			stmt.setInt(4, prof.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno "+prof.getNome()+" atualizado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
		} finally {
	
			ConnectionFactory.desconectar();
		}
		
		
	}

	public void delete(int id) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
		ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("delete from professor where id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado!");
		
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: "+ex);
		} finally {
			ConnectionFactory.desconectar();
	}
	}
	
	
	
	
	public List<Professor> listar(){
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<Professor> professores = new ArrayList<>();
		
		try {
			ConnectionFactory.conectar();
			stmt = ConnectionFactory.con.prepareStatement("select * from professor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Professor prof = new Professor();
				prof.setId(rs.getInt("id"));
				prof.setDataNasc(rs.getString("data_nasc"));
				prof.setSalario(rs.getDouble("salario"));
				prof.setNome(rs.getString("nome"));
				
				professores.add(prof);
				
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
		} finally {
			ConnectionFactory.desconectar();
		}
		
		return professores;
		
	}
	
	public List<Professor> buscaNome(String nome){
			
			PreparedStatement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			List<Professor> professores = new ArrayList<>();
			
			try {
				ConnectionFactory.conectar();
				stmt = ConnectionFactory.con.prepareStatement("select * from professor where nome like ?");
				//stmt.setInt(1, Integer.parseInt(nome));
				stmt.setString(1, "%"+ nome + "%");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					Professor prof = new Professor();
					prof.setId(rs.getInt("id"));
					prof.setDataNasc(rs.getString("data_nasc"));
					prof.setSalario(rs.getDouble("salario"));
					prof.setNome(rs.getString("nome"));
					
					professores.add(prof);
					
					
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
			} finally {
				ConnectionFactory.desconectar();
			}
			
			return professores;
			
		}
	
	public ArrayList fillComboProfessores(){
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList professores = new ArrayList<>();
		
		try {
			
			ConnectionFactory.conectar();
			stmt = ConnectionFactory.con.prepareStatement("select nome from professor");
			rs = stmt.executeQuery();
				
			while(rs.next()) {
					
				professores.add(rs.getString("nome"));
				
				//addItem();
					
				}
					
				
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			ConnectionFactory.desconectar();
		}
		return professores;
		
	}
}

