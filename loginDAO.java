import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class loginDAO {
String url = "jdbc:mariadb://localhost:3307/conexao?user=root&password=root";

	
	
	//verificar conexao
	public Connection conectaBD() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return conn;
	}
	
	
	
	
	//salva
	public void save(Pessoa user) {//create (alterar) 
		String sql = "INSERT INTO login(login, senha) VALUES (?,?)";//alterar
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getLogin());//alterar
			pstm.setString(2,user.getSenha());//alterar
			pstm.execute();
		}  catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}
	public boolean listar(String login, String senha) {
	    String sql = "SELECT * FROM login WHERE login = ? AND senha = ?";

	    try (Connection conn = conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql)) {

	        pstm.setString(1, login);
	        pstm.setString(2, senha);

	        // Executa a consulta
	        ResultSet rs = pstm.executeQuery();

	        // Verifica se existe pelo menos um resultado (login válido)
	        if (rs.next()) {
	            return true;
	        } else {
	            return false;
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao validar login: " + e.getMessage());
	        return false;
	    }
	}

	
	
	
	
}