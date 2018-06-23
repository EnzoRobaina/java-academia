package br.ucam.enzo.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.ucam.enzo.connection.ConnectionFactory;

public class LoginDAO {
	
public boolean validar(String username, String password) {
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		boolean validado = false;
		
		ConnectionFactory.conectar();
		
		try {
			stmt = ConnectionFactory.con.prepareStatement("select * from login where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(!rs.next()){
				//System.out.println("Result set is empty");
				JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
				validado = false;
			}
			else{
				validado = true;
			}
				
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro: "+ex);
		} finally {
			ConnectionFactory.desconectar();
	}
		return validado;
		
		
	}

}
