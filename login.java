import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;



public class login extends JFrame {



	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtLogin;
	private JTextField txtSenha;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					login frame = new login();

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

	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\download.png"));

		setTitle("Tela de Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 497, 290);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(64, 128, 128));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JLabel lblNewLabel = new JLabel("Login");

		lblNewLabel.setBounds(27, 31, 51, 14);

		contentPane.add(lblNewLabel);

		

		txtLogin = new JTextField();

		txtLogin.setBounds(76, 28, 371, 20);

		contentPane.add(txtLogin);

		txtLogin.setColumns(10);

		

		JLabel lblNewLabel_1 = new JLabel("Senha");

		lblNewLabel_1.setBounds(27, 70, 51, 14);

		contentPane.add(lblNewLabel_1);

		

		JButton btnSair = new JButton("Sair");

		btnSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\letter-x_9313434.png"));

		btnSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		});

		btnSair.setBounds(371, 217, 100, 23);

		contentPane.add(btnSair);

		

		JButton btnApagar = new JButton("Apagar");

		btnApagar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\broom_9742093.png"));

		btnApagar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				txtLogin.setText("");

				txtSenha.setText("");



			}

		});

		btnApagar.setBounds(341, 98, 106, 23);

		contentPane.add(btnApagar);

		

		JButton btnEntrar = new JButton(" Entrar");

		btnEntrar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\check_16799038.png"));

		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				loginDAO lg = new loginDAO();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				
				if(lg.listar(login,senha) == true){
					dispose();
					TelaPrincipal st = new TelaPrincipal();
					st.setVisible(true);
				} else {

					JOptionPane.showMessageDialog(null, "Login ou Senha incorretos");

				}

				txtLogin.setText("");

				txtSenha.setText("");

			}

		});

		btnEntrar.setBounds(261, 217, 100, 23);

		contentPane.add(btnEntrar);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(76, 67, 371, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);



	}
}