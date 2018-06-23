package br.ucam.enzo.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.bean.Aluno;
import br.ucam.enzo.model.bean.Modalidade;

public class AlunoDAO {

	public void create(Aluno aluno) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		
			ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("insert into aluno(nome, data_nasc, modalidade_fk) values(?,?,?)");
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getDataNasc());
			stmt.setString(3,  aluno.getModalidade());
			
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
	
	public void update(Aluno aluno) {
			
			PreparedStatement stmt = null;
			Connection con = null;
			
			
			ConnectionFactory.conectar();
			
			try {
				stmt = ConnectionFactory.con.prepareStatement("update aluno set nome = ?, data_nasc = ?, modalidade_fk = ? where id = ?");
				stmt.setString(1, aluno.getNome());
				stmt.setString(2, aluno.getDataNasc());
				stmt.setString(3,  aluno.getModalidade());
				stmt.setInt(4, aluno.getId());
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Aluno "+aluno.getNome()+" atualizado com sucesso!");
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
			stmt = ConnectionFactory.con.prepareStatement("delete from aluno where id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado!");
		
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: "+ex);
		} finally {
			ConnectionFactory.desconectar();
	}
	}
	
	
	
	
	public List<Aluno> listar(){
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			ConnectionFactory.conectar();
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
	
	public List<Aluno> buscaNome(String nome){
			
			PreparedStatement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			List<Aluno> alunos = new ArrayList<>();
			
			try {
				ConnectionFactory.conectar();
				stmt = ConnectionFactory.con.prepareStatement("select * from aluno where nome like ?");
				//stmt.setInt(1, Integer.parseInt(nome));
				stmt.setString(1, "%"+ nome + "%");
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

