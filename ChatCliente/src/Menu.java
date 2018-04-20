import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField TxServerIp;
	private JTextField TxServerPort;
	private JTextField TxNick;
	public static ChatCliente frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Conectar ao Servidor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfiguraoDoServidor = new JLabel("Conectar ao Servidor");
		lblConfiguraoDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConfiguraoDoServidor.setBounds(68, 11, 214, 44);
		contentPane.add(lblConfiguraoDoServidor);
		
		JLabel lblIpDoServidor = new JLabel("IP do Servidor:");
		lblIpDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIpDoServidor.setBounds(50, 144, 103, 17);
		contentPane.add(lblIpDoServidor);
		
		TxServerIp = new JTextField();
		TxServerIp.setBounds(167, 144, 131, 20);
		contentPane.add(TxServerIp);
		TxServerIp.setColumns(10);
		
		JLabel lblPortaDoServidor = new JLabel("Porta do Servidor:");
		lblPortaDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortaDoServidor.setBounds(50, 194, 118, 17);
		contentPane.add(lblPortaDoServidor);
		
		TxServerPort = new JTextField();
		TxServerPort.setColumns(10);
		TxServerPort.setBounds(167, 194, 131, 20);
		contentPane.add(TxServerPort);
		
		JButton btnIniciarServidor = new JButton("Conectar");
		btnIniciarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarServidor.setBounds(80, 257, 188, 44);
		btnIniciarServidor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					salvarDados();
				}
				catch(Exception e2){}
				conectarServidor(TxServerIp.getText(),TxServerPort.getText(),TxNick.getText());
				
			}
		});
		contentPane.add(btnIniciarServidor);
		
		TxNick = new JTextField();
		TxNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (TxNick.getText().length() >= 19 )
				{
			            e.consume(); 
				}
			}
		});
		TxNick.setColumns(10);
		TxNick.setBounds(167, 91, 131, 20);
		contentPane.add(TxNick);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNickname.setBounds(50, 91, 103, 17);
		contentPane.add(lblNickname);
				
		carregarDados();
		
	}
	
	public void conectarServidor(String ip, String porta, String nick)
	{
		frame = new ChatCliente(ip,porta,nick);
		this.setVisible(false);
		frame.setVisible(true);
		
	}
	
	public void salvarDados() throws IOException
	{
		String fileName = "Configs.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
		
		writer.write(TxServerPort.getText());
		writer.newLine();
		
		writer.write(TxNick.getText());
		writer.newLine();
		
		writer.write(TxServerIp.getText());
		writer.newLine();
		
		writer.close();
	}
	
	public void carregarDados()
	{
		try
		{
			String fileName = "Configs.txt";
			BufferedReader ler = new BufferedReader(new FileReader(fileName));
			TxServerPort.setText(ler.readLine());
			TxNick.setText(ler.readLine());
			TxServerIp.setText(ler.readLine());
			ler.close();
		}
		catch(Exception e){}
	}
}
