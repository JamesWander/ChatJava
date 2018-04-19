import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

public class EnviarMensagem extends Thread{

	//private List<Socket> clientes;
	private List<Usuario> clientes;
	private String nick;
	private String msgs;
	
	public EnviarMensagem(List<Usuario> clientes,String nick, String msgs)
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
			for(Usuario cliente : clientes)
			{
				DataOutputStream dOut = new DataOutputStream(cliente.getSocket().getOutputStream());
				dOut.writeByte(0);
				dOut.writeUTF(nick);
				dOut.flush();
				dOut.writeUTF(msgs);
				dOut.flush();
				
				enviarUsuario();
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "EnvirMensagem do server: " +e);
		}
	}
	
	
	private void enviarUsuario()
	{
		String usuarios = "";
		
		try
		{
			for(Usuario cliente : clientes)
			{
				usuarios += cliente.getNick()+"\n";
			}
			
			for(Usuario cliente : clientes)
			{
				DataOutputStream dOut = new DataOutputStream(cliente.getSocket().getOutputStream());
				dOut.writeByte(1);
				dOut.flush();
				dOut.writeUTF(usuarios);
				dOut.flush();
				
			}
			
		}
		catch(Exception e)
		{		
			JOptionPane.showMessageDialog(null, e);	
		}
			
	}
	
}
