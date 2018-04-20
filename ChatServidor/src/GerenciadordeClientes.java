import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class GerenciadordeClientes extends Thread {
	
	private ServerSocket servidor;
	//private List<Socket> listadeClientes;
	private List<Usuario> listadeClientes;
	private JTextPane textPane;
	private ReceberMensagem mensagem;
	
	
	public GerenciadordeClientes(ServerSocket servidor, List<Usuario> listadeClientes,JTextPane textPane)
	{
		this.servidor = servidor;
		this.listadeClientes = listadeClientes;
		this.textPane = textPane;
	}
	
	public void run()
	{
		esperarClientes();
	}

	private void esperarClientes()
	{
		try
		{
			while(true)
			{
				//aceita a conexao do usuario
				Socket cliente = servidor.accept();
				
				//exibe o usuario que foi conectado
				textPane.setText(textPane.getText()+"\nUsuario conectado: " + cliente.getInetAddress().getHostAddress());
				DataInputStream dIn = new DataInputStream(cliente.getInputStream());
				String nick = dIn.readUTF();
				
				Usuario user = new Usuario(cliente, nick, cliente.getInetAddress().getHostAddress());
				
				//adiciona o Cliente que conectou, na lista de clientes
				listadeClientes.add(user);
				
				mensagem = new ReceberMensagem(user,textPane,listadeClientes);
				mensagem.start();
				
				
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
