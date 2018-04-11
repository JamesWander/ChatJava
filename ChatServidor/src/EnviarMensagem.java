import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

public class EnviarMensagem extends Thread{

	private List<Socket> clientes;
	private String texto;
	
	public EnviarMensagem(List<Socket> clientes,String texto)
	{
		this.clientes = clientes;
		this.texto = texto;
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
				dOut.writeUTF(texto);
				dOut.flush();
				System.out.println("To Mandando: "+texto);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "EnvirMensagem do server: " +e);
		}
	}
	
}
