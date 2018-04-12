import java.awt.Color;
import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
				
				StyledDocument doc = chat.getStyledDocument();
				
				dIn = new DataInputStream(cliente.getInputStream());
				
				/*String aux = dIn.readUTF();
				Style style = chat.addStyle(aux,null);
				StyleConstants.setForeground(style, Color.red);
				
				doc.insertString(doc.getLength(), "seila", style);
				
				chat.setText(chat.getText()+"\n"+aux);*/
				
				
				
				String nick = dIn.readUTF();
				String msgs = dIn.readUTF();
				
				
				if(ChatCliente.nick.equals(nick))
				{
					Style style = chat.addStyle("nick",null);
					StyleConstants.setForeground(style, new Color(0,153,51));
					StyleConstants.setBold(style, true);
					doc.insertString(doc.getLength(), "\n"+nick+": ", style);
				}
				else
				{
					Style style = chat.addStyle("nick",null);
					StyleConstants.setForeground(style, Color.blue);
					StyleConstants.setBold(style, true);
					doc.insertString(doc.getLength(), "\n"+nick+": ", style);
				}
				
				doc.insertString(doc.getLength(), msgs, null);
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "é aqui no Recebermensagen cliente: " + e);
			}
				
		}
		
		
	}
	
	
}
