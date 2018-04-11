import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField TxServerIp;
	private JTextField TxServerPort;
	private JTextField TxNick;

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
				conectarServidor(TxServerIp.getText(),TxServerPort.getText(),TxNick.getText());
				
			}
		});
		contentPane.add(btnIniciarServidor);
		
		TxNick = new JTextField();
		TxNick.setColumns(10);
		TxNick.setBounds(167, 91, 131, 20);
		contentPane.add(TxNick);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNickname.setBounds(50, 91, 103, 17);
		contentPane.add(lblNickname);
	}
	
	public void conectarServidor(String ip, String porta, String nick)
	{
		ChatCliente frame = new ChatCliente(ip,porta,nick);
		this.setVisible(false);
		frame.setVisible(true);
		
	}
}
