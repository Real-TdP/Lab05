package it.polito.tdp.lab05.DAO;

import java.sql.*;

public class DizionarioDAO {
	
	public boolean isCorrect(String anagramma){
		
		final String sql="SELECT ID FROM parola WHERE nome LIKE ?";
		final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root";
		try {
			Connection conn =DriverManager.getConnection(jdbcUrl);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,anagramma);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				st.close();
				rs.close();
				conn.close();
				return true;
			}				
			else {
				st.close();
				rs.close();
				conn.close();
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
