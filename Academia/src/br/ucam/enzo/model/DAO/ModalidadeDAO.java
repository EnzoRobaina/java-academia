package br.ucam.enzo.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ucam.enzo.connection.ConnectionFactory;
import br.ucam.enzo.model.bean.Modalidade;
import br.ucam.enzo.model.bean.Professor;

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
			stmt.setString(4, modalidade.getProfessor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Modalidade "+modalidade.getNome()+" inserido com sucesso!");
			
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			
		} finally {
			
			ConnectionFactory.desconectar();
		}
		
		
	}
	
	public ArrayList fillComboModalidades(){
			
			PreparedStatement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			ArrayList modalidades = new ArrayList<>();
			
			try {
				
				ConnectionFactory.conectar();
				stmt = ConnectionFactory.con.prepareStatement("select nome from modalidade");
				rs = stmt.executeQuery();
					
				while(rs.next()) {
						
					modalidades.add(rs.getString("nome"));
					
					//addItem();
						
					}
						
					
			} catch(SQLException e) {
				System.out.println(e);
			} finally {
				ConnectionFactory.desconectar();
			}
			return modalidades;
			
		}
	
	public void update(Modalidade modalidade) {
			
			PreparedStatement stmt = null;
			Connection con = null;
			
			
			ConnectionFactory.conectar();
			
			try {
				System.out.println(modalidade.getId());
				
				stmt = ConnectionFactory.con.prepareStatement("update modalidade set nome = ?, horario = ?, valor = ?, professor_fk = ? where id = ?");
				stmt.setString(1, modalidade.getNome());
				stmt.setString(2, modalidade.getHorario());
				stmt.setDouble(3, modalidade.getValor());
				stmt.setString(4, modalidade.getProfessor());
				stmt.setInt(5, modalidade.getId());
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Modalidade "+modalidade.getNome()+" atualizado com sucesso!");
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
			stmt = ConnectionFactory.con.prepareStatement("delete from modalidade where id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado!");
		
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar: "+ex);
		} finally {
			ConnectionFactory.desconectar();
	}
	}
	
	
	
	
	public List<Modalidade> listar(){
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<Modalidade> modalidades = new ArrayList<>();
		
		try {
			ConnectionFactory.conectar();
			stmt = ConnectionFactory.con.prepareStatement("select * from modalidade");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Modalidade modalidade = new Modalidade();
				modalidade.setId(rs.getInt("id"));
				modalidade.setNome(rs.getString("nome"));
				modalidade.setHorario(rs.getString("horario"));
				modalidade.setProfessor(rs.getString("professor_fk"));
				modalidade.setValor(rs.getDouble("valor"));
				
				
				modalidades.add(modalidade);
				
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
		} finally {
			ConnectionFactory.desconectar();
		}
		
		return modalidades;
		
	}
	
	public List<Modalidade> buscaNome(String nome){
			
			PreparedStatement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			List<Modalidade> modalidades = new ArrayList<>();
			
			try {
				ConnectionFactory.conectar();
				stmt = ConnectionFactory.con.prepareStatement("select * from modalidade where nome like ?");
				stmt.setString(1, "%"+ nome + "%");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					Modalidade modalidade = new Modalidade();
					modalidade.setId(rs.getInt("id"));
					modalidade.setNome(rs.getString("nome"));
					modalidade.setHorario(rs.getString("horario"));
					modalidade.setProfessor(rs.getString("professor_fk"));
					modalidade.setValor(rs.getDouble("valor"));
					
					
					modalidades.add(modalidade);
					
					
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao consultar: "+e);
			} finally {
				ConnectionFactory.desconectar();
			}
			
			return modalidades;
			
		}
	
	
}

