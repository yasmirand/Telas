import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Excluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtNasc;
	private JTextField txtCll;
	private JTextField txtEmail;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir frame = new Excluir();
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
	public Excluir() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\butterfly.png"));
		setTitle("Excluir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(22, 27, 42, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(22, 61, 42, 23);
		contentPane.add(lblCpf);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de Nascimento:");
		lblNewLabel_1_1.setBounds(22, 95, 123, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(22, 129, 59, 23);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 163, 59, 23);
		contentPane.add(lblEmail);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\letter-x_9313434.png"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
			}
		});
		btnFechar.setBounds(321, 250, 113, 23);
		contentPane.add(btnFechar);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pessoa p1 = new Pessoa();
				int Id = Integer.parseInt(txtId.getText());
				
				if(p1.listar(Id) == true){
					txtNome.setText(p1.getNome());
					txtCpf.setText(p1.getCpf());
					txtNasc.setText(p1.getNasc());
					txtCll.setText(p1.getCll());
					txtEmail.setText(p1.getEmail());
				} else {

					JOptionPane.showMessageDialog(null, "O Usuário com o id "+ Id + " não foi encontrado");

				}
				
			}}
		);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\pesquisar-arquivo.png"));
		btnNewButton.setBounds(191, 203, 106, 23);
		contentPane.add(btnNewButton);
		
		JLabel txt = new JLabel("ID:");
		txt.setBounds(22, 207, 46, 14);
		contentPane.add(txt);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCpf.setText("");
				txtNasc.setText("");
				txtCll.setText("");
				txtEmail.setText("");
				txtId.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\broom_9742093.png"));
		btnNewButton_1.setBounds(307, 203, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexaoDAO c1 = new conexaoDAO();
				Pessoa p1 = new Pessoa();
				p1.setNome(txtNome.getText());
				p1.setCll(txtCll.getText());
				p1.setCpf(txtCpf.getText());
				p1.setEmail(txtEmail.getText());
				p1.setNasc(txtNasc.getText());
				int Id = Integer.parseInt(txtId.getText());
				c1.delete(Id);
			
		}});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\excluir.png"));
		btnNewButton_2.setBounds(198, 250, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 237, 391, 0);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(80, 237, 65, 0);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(54, 276, 76, 0);
		contentPane.add(separator_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 28, 339, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(74, 62, 339, 20);
		contentPane.add(txtCpf);
		
		txtNasc = new JTextField();
		txtNasc.setColumns(10);
		txtNasc.setBounds(148, 96, 265, 20);
		contentPane.add(txtNasc);
		
		txtCll = new JTextField();
		txtCll.setColumns(10);
		txtCll.setBounds(80, 130, 333, 20);
		contentPane.add(txtCll);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(65, 163, 348, 20);
		contentPane.add(txtEmail);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(54, 204, 127, 20);
		contentPane.add(txtId);
	}
}
