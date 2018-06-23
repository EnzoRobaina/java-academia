package br.ucam.enzo.connection;

import java.sql.*;


import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	
	
	//private static final String url = "jdbc:postgresql://localhost:5433/academia";
	
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/academia";
	private static final String user = "postgres";
	private static final String password = "root";
	public static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
			
	}
	public static void conectar() {
		
		try {
			System.setProperty("jdbc.Drivers", driver);
			con = DriverManager.getConnection(url, user, password);
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar: "+ex);
		}
	}
	
	public static void desconectar() {
		try {
			con.close();
			//JOptionPane.showMessageDialog(null, "Desconectado!");
			System.out.println("Desconectado!");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha: "+ex);
		}
	}
	

  
    public static void closeConnection(ConnectionFactory con){
  
        try {
            if(con != null){
                ((java.sql.Connection) con).close();
            }
        }catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }               
    } 
    
    public static void closeConnection(ConnectionFactory con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
        }
        }catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }       
    } 
           
    public static void closeConnection(ConnectionFactory con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
        } 
        }catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }       
    }


	
}


