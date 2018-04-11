import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Lista.ListaLigada;

public class ReceberMensagem extends Thread{
	
	private Socket 		cliente;
	private JTextPane 	chat;
	private List<Socket> clientes;
	private EnviarMensagem enviar;
	
	public ReceberMensagem(Socket cliente,JTextPane chat,List<Socket> clientes)
	{
		this.cliente = cliente;
		this.chat 	 = chat;  
		this.clientes = clientes;
	}
	
	public void run()
	{
		receberMensagem();
	}

	private void receberMensagem()
	{
		try
		{
			while(true)
			{
				//Lendo o texto recebido do cliente
				DataInputStream dIn = new DataInputStream(cliente.getInputStream());
				String aux = dIn.readUTF();

				//Colocando o texto no JTextPane
				chat.setText(chat.getText()+"\n"+cliente.getInetAddress().getHostAddress()+": "+aux);
				
				//aux = cliente.getInetAddress().getHostAddress()+": "+aux;
				
				
				
				//Mandando a mensagem recebida para todos os clientes
				enviar = new EnviarMensagem(clientes,aux);
				
				enviar.start();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ReceberdoServer: " +e);
		}
	}



}
