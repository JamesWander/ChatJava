import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Testando {

	public static void main(String[] args) {
		
		try
		{
			//preparando o socket do cliente
			Socket cliente = new Socket(InetAddress.getLocalHost().getHostName(),12312);
			
			//Criando um OutputStream pra mandar mensagens pro servidor
			DataOutputStream dOut = new DataOutputStream(cliente.getOutputStream());
			
			while(true)
			{
				//Mandando a String
				String aux = JOptionPane.showInputDialog("Digite algo");
				dOut.writeUTF(aux);
				dOut.flush();
				
				if(aux.equals("Saindo"))
				{
					dOut.close();
					break;
				}
			}
			
		}catch(Exception e){}
		
		
		
	}

}
