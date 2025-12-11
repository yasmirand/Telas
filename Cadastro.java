
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtNasc;
	private JTextField txtCll;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(22, 27, 42, 23);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 28, 330, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(22, 61, 42, 23);
		contentPane.add(lblCpf);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de Nascimento:");
		lblNewLabel_1_1.setBounds(22, 95, 123, 23);
		contentPane.add(lblNewLabel_1_1);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(74, 62, 330, 20);
		contentPane.add(txtCpf);
		
		txtNasc = new JTextField();
		txtNasc.setColumns(10);
		txtNasc.setBounds(150, 96, 254, 20);
		contentPane.add(txtNasc);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(22, 129, 59, 23);
		contentPane.add(lblTelefone);
		
		txtCll = new JTextField();
		txtCll.setColumns(10);
		txtCll.setBounds(86, 129, 318, 20);
		contentPane.add(txtCll);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 163, 59, 23);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(74, 163, 330, 20);
		contentPane.add(txtEmail);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login tl = new login();
				tl.setVisible(true);
			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\letter-x_9313434.png"));
		btnSair.setBounds(294, 287, 110, 23);
		contentPane.add(btnSair);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\broom_9742093.png"));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCll.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtNasc.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
			}
		});
		btnApagar.setBounds(294, 253, 110, 23);
		contentPane.add(btnApagar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexaoDAO conecta = new conexaoDAO();
				loginDAO lg = new loginDAO();
				Pessoa p1 = new Pessoa();
				p1.setNome(txtNome.getText());
				p1.setCll(txtCll.getText());
				p1.setCpf(txtCpf.getText());
				p1.setEmail(txtEmail.getText());
				p1.setNasc(txtNasc.getText());
				p1.setLogin(txtLogin.getText());
				p1.setSenha(txtSenha.getText());
				txtNome.setText("");
				txtCll.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtNasc.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
				conecta.save(p1);
				lg.save(p1);
				dispose();
				TelaPrincipal st = new TelaPrincipal();
				st.setVisible(true);
				
			}
		});
		btnEnviar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\check_16799038.png"));
		btnEnviar.setBounds(175, 287, 110, 23);
		contentPane.add(btnEnviar);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(22, 219, 59, 23);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(74, 220, 123, 20);
		contentPane.add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(229, 219, 59, 23);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(281, 219, 123, 20);
		contentPane.add(txtSenha);

	}
}
