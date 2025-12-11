import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\butterfly.png"));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem novo = new JMenuItem("Novo");
		novo.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\add.png"));
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cadastro c1 = new Cadastro();
				c1.setVisible(true);
			}
		});
		mnNewMenu.add(novo);
		
		JMenuItem salvar = new JMenuItem("Salvar");
		salvar.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\diskette.png"));
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login lg = new login();
				lg.setVisible(true);
			}
		});
		mnNewMenu.add(salvar);
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\logout.png"));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mnRelatorio = new JMenuItem("Relatório");
		mnRelatorio.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\atualizada.png"));
		mnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexaoDAO conecta = new conexaoDAO();

				List<Pessoa> user = new ArrayList<Pessoa>();

				user = conecta.listar();

				String caminhoArquivo = "C:\\Users\\Aluno\\Desktop\\relatorio.txt";

				try (FileWriter writer = new FileWriter(caminhoArquivo)){

				writer.write("RELATÓRIO\n\n");

				for(Pessoa u1: user) {

				writer.write(u1.toString());

				}
				JOptionPane.showMessageDialog(mnRelatorio, "Deu boa");
				
				}catch(Exception e2) {
				JOptionPane.showMessageDialog(mnRelatorio, "Erro ao escrever no arquivo: " + e2.getMessage());
	
				e2.printStackTrace();

				}

				}

				});
		mnNewMenu.add(mnRelatorio);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(sair);
		
		JMenu mnNewMenu_1 = new JMenu("Editar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Atualizar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atualiza at = new Atualiza();
				dispose();
				at.setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\lista-de-controle.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar lt = new Listar();
				dispose();
				lt.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\editar.png"));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Excluir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excluir ex = new Excluir();
				dispose();
				ex.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\eclipse-workspace\\Telas\\src\\imagens\\excluir.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);

	}
}
