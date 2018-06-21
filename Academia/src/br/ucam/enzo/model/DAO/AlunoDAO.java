package br.ucam.enzo.model.DAO;

import java.sql.Connection;
import java.sql.*;

import br.ucam.connection.*;

import br.ucam.enzo.model.bean.Aluno;

public class AlunoDAO {

	public void create(Aluno aluno) {
		
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
