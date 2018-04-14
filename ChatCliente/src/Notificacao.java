import java.awt.*;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

public class Notificacao {

	private String usuario;
	
	private String msg;
	
	public Notificacao(String usuario, String msg)
	{
		this.usuario = usuario;
		this.msg = msg;
	}

    public void exibir(){
    	
    	try
    	{
	    	if(SystemTray.isSupported())
	    	{
		        
		        SystemTray tray = SystemTray.getSystemTray();
	
		        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		        trayIcon.setImageAutoSize(true);
		        trayIcon.setToolTip("Notificação");
		        tray.add(trayIcon);
		
		        trayIcon.displayMessage(usuario, msg, MessageType.INFO);
	    	}

    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
}