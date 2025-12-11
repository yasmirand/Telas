import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Pessoa {
	String Nome;
	String Cll;
	String Cpf;
	String Email;
	String Nasc;
	String Login;
	String Senha;
	int Id;
	
	public Pessoa() {
		super();
	
	}
	
	public Pessoa(String nome, String cll, String cpf, String email, String nasc, String login, String senha) {
		super();
		Nome = nome;
		Cll = cll;
		Cpf = cpf;
		Email = email;
		Nasc = nasc;
		Senha = senha;
		Login = login;
		
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCll() {
		return Cll;
	}

	public void setCll(String cll) {
		Cll = cll;
	}

	public String getCpf() {
		return Cpf;
	}
	

	public void setCpf(String cpf) {
		if(verificaCpf(cpf)== true) {
		Cpf = cpf;
		}else {
			JOptionPane.showMessageDialog(null, "cpf invalido!");
		}
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNasc() {
		return Nasc;
	}

	public void setNasc(String nasc) {
		Nasc = nasc;
	}
	
	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	
	
	@Override
	public String toString() {
		return "Id: " + Id +"\nNome: " + Nome + "\nTelefone: " + Cll + "\nCpf: " + Cpf + "\nEmail: " + 
				Email + "\nData de Nascimento: " + Nasc + "\n\n";
	}

	public boolean verificaCpf(String cpf) {
		String subCPF1 = cpf.substring(0, 9);
		int sub1 = Integer.parseInt(subCPF1);
		int novoSub[] = new int[9];
		int mult1 = 2;
		int soma = 0;
		int primDig = 0;

		for (int i = 8; i >= 0; i--) {
			novoSub[i] = sub1 % 10;
			soma = soma + (sub1 % 10 * mult1);
			mult1++;
			sub1 = sub1 / 10;
		}

		primDig = soma % 11;

		if (primDig < 2) {
			primDig = 0;
		} else {
			primDig = 11 - primDig;
		}

		int outroSub[] = new int[10];

		for (int i = 0; i < 9; i++) {
			outroSub[i] = novoSub[i];
		}

		outroSub[9] = primDig;

		soma = 0;
		mult1 = 2;

		for (int i = 9; i >= 0; i--) {
			soma = soma + (outroSub[i] * mult1);
			mult1++;
		}

		int segDig = soma % 11;

		if (segDig < 2) {
			segDig = 0;
		} else {
			segDig = 11 - segDig;
		}

		String verificado = (primDig + "" + segDig);

		if (verificado.equals(cpf.substring(9))) {
			return true;
		} else {
			return false;
		}
	}
	String url = "jdbc:mariadb://localhost:3307/conexao?user=root&password=root";
	public Connection conectaBD() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch(SQLException e) {
			JOptionPane.showInputDialog(null, e);
		}
		return conn;
	}
	public boolean listar(int id) {
	    String sql = "SELECT * FROM telas WHERE id = ?";

	    try (Connection conn = conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql)) {

	        pstm.setInt(1, id);

	        // Executa a consulta
	        ResultSet rs = pstm.executeQuery();

	        // Verifica se existe pelo menos um resultado (login válido)
	        if (rs.next()) {
	        	setNome(rs.getString("nome"));
				setCpf(rs.getString("cpf"));//alterar
				setEmail(rs.getString("email"));//alterar
				setCll(rs.getString("cll"));//alterar
				setNasc(rs.getString("dataNasc"));//alterar
	            return true;
	        } else {
	            return false;
	        }

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Deu pau");
	        return false;
	
	
	}}
	public void update(int id) {
		String sql = "UPDATE telas SET nome=?, cll=?, cpf=?, email=?, dataNasc=? WHERE id=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection(url);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,Nome);//alterar
			pstm.setString(2,Cll);//alterar
			pstm.setString(3,Cpf);//alterar
			pstm.setString(4,Email);//alterar
			pstm.setString(5,Nasc);//alterar
			pstm.execute();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "deu pau");
			}
		}
		
	} }

