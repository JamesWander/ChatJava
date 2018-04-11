import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class ReceberMensagem extends Thread {

	private Socket cliente;
	private JTextPane chat;
	private DataInputStream dIn;
	
	public ReceberMensagem(Socket cliente, JTextPane chat)
	{
		this.cliente = cliente;
		this.chat = chat;
	}
	
	public void run()
	{
		receberMensagem();
	}

	private void receberMensagem()
	{
		
		while(true)
		{
			try
			{
				dIn = new DataInputStream(cliente.getInputStream());
				chat.setText(chat.getText()+"\n"+dIn.readUTF());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "é aqui no Recebermensagen cliente: " + e);
			}
				
		}
		
		
	}
	
	
}
