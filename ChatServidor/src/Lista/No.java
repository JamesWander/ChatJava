package Lista;

import java.net.Socket;

public class No {

	public Socket dado;
	
	public No prox;
	
	public No(Socket e)
	{
		dado = e;
		prox = null;
	}
	
}
