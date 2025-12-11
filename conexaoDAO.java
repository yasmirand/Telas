
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class conexaoDAO {
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
		String sql = "INSERT INTO telas(nome,cll,cpf,email,dataNasc) VALUES (?,?,?,?,?)";//alterar
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getNome());//alterar
			pstm.setString(2,user.getCll());//alterar
			pstm.setString(3,user.getCpf());//alterar
			pstm.setString(4,user.getEmail());//alterar
			pstm.setString(5,user.getNasc());//alterar
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

	public List<Pessoa> listar(){
		String sql = "SELECT * FROM telas";
		List<Pessoa> contato = new ArrayList<Pessoa>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Pessoa user = new Pessoa();
				user.setId(rset.getInt("Id"));
				user.setNome(rset.getString("nome"));
				user.setCll(rset.getString("cll"));
				user.setCpf(rset.getString("cpf"));
				user.setEmail(rset.getString("email"));
				user.setNasc(rset.getString("dataNasc"));
				contato.add(user);

			}
		} catch(SQLException e) {
			
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
		return contato;
	}
	
	
	//atualiza
	public void update(Pessoa user, int Id) {
		String sql = "UPDATE telas SET nome=?, cll=?, cpf=?, email=?, dataNasc=? WHERE id=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,user.getNome());//alterar
			pstm.setString(2,user.getCll());//alterar
			pstm.setString(3,user.getCpf());//alterar
			pstm.setString(4,user.getEmail());//alterar
			pstm.setString(5,user.getNasc());//alterar
			pstm.setInt(6, Id);//alterar
			pstm.execute();
		}catch(SQLException e) {
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
	
	
	
	//deletar
	public void delete(int id) {
		String sql="DELETE FROM telas WHERE id=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);//alterar
			pstm.execute();
		} catch(SQLException e) {
			
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
}