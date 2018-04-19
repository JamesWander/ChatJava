import java.net.Socket;

public class Usuario {
	
	private Socket 	socket;
	private String 	nick;
	private String	ip;
	
	public Usuario(Socket socket, String nick, String ip)
	{
		this.socket = socket;
		this.nick = nick;
		this.ip = ip;
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
