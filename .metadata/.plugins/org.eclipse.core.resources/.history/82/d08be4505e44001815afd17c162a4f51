import java.io.DataInputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class ReceberMensagem extends Thread{
	
	private Usuario cliente;
	private JTextPane chat;
	//private List<Socket> clientes;
	private List<Usuario> clientes;
	private EnviarMensagem enviar;
	
	public ReceberMensagem(Usuario cliente,JTextPane chat,List<Usuario> clientes)
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
				DataInputStream dIn = new DataInputStream(cliente.getSocket().getInputStream());
				//String nick = dIn.readUTF();
				String msgs = dIn.readUTF(); 

				//Colocando o texto no JTextPane
				chat.setText(chat.getText()+"\n"+cliente.getIp()+": "+cliente.getNick()+": "+msgs);
							
				//Mandando a mensagem recebida para todos os clientes
				enviar = new EnviarMensagem(clientes,cliente.getNick(),msgs);
				enviar.start();
				
	
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ReceberdoServer: " +e);
			clientes.remove(cliente);
		}
	}



}
