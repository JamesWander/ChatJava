import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

public class EnviarMensagem extends Thread{

	private List<Socket> clientes;
	private String nick;
	private String msgs;
	
	public EnviarMensagem(List<Socket> clientes,String nick, String msgs)
	{
		this.clientes = clientes;
		this.nick = nick;
		this.msgs = msgs;
	}
	
	public void run()
	{
		enviarMensagem();
	}
	
	public void enviarMensagem()
	{
		try
		{
			for(Socket cliente : clientes)
			{
				DataOutputStream dOut = new DataOutputStream(cliente.getOutputStream());
				dOut.writeUTF(nick);
				dOut.flush();
				dOut.writeUTF(msgs);
				dOut.flush();
				
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "EnvirMensagem do server: " +e);
		}
	}
	
}
