import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Lista.ListaLigada;

public class GerenciadordeClientes extends Thread {
	
	private ServerSocket servidor;
	private List<Socket> listadeClientes;
	private JTextPane textPane;
	private ReceberMensagem mensagem;
	
	
	public GerenciadordeClientes(ServerSocket servidor, List<Socket> listadeClientes,JTextPane textPane)
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
				
				//adiciona o Cliente que conectou, na lista de clientes
				listadeClientes.add(cliente);
				
				mensagem = new ReceberMensagem(cliente,textPane,listadeClientes);
				mensagem.start();
				
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "GerenciadorDeClientes do Server: " +e);
		}
	}

}
