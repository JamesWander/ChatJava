import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ChatServer extends JFrame {

	private JPanel contentPane;
	private String ipdoServidor;
	private int portadoServidor;
	private JTextPane textPane;
	//private List<Socket> listadeClientes = new ArrayList<Socket>();
	private List<Usuario> listadeClientes = new ArrayList<Usuario>();

	/**
	 * Create the frame.
	 */
	public ChatServer(String ip, String porta)
	{
		this.ipdoServidor = ip;
		this.portadoServidor = Integer.parseInt(porta);
		setResizable(false);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(3, 3, 434, 260);
		contentPane.add(textPane);
		
		iniciaServidor();
	}


	private void iniciaServidor() 
	{
		try
		{
			//Preparando o Socket do servidor
			InetAddress ip = InetAddress.getByName(ipdoServidor);
			ServerSocket servidor = new ServerSocket(portadoServidor, 0, ip);
			
			//Executando Thread que vai ficar recebendo e aceitando conexões dos clientes
			GerenciadordeClientes Clientes = new GerenciadordeClientes(servidor,listadeClientes,textPane);
			Clientes.start();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ChatServer: " +e);
		}
		
	}
}
