import java.awt.Color;
import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

public class ReceberMensagem extends Thread {

	private Socket cliente;
	private JTextPane chat;
	private DataInputStream dIn;
	private JTextPane TxUser;
	private Emojis emojisss = new Emojis();
	
	public ReceberMensagem(Socket cliente, JTextPane chat,JTextPane user)
	{
		this.cliente = cliente;
		this.chat = chat;
		this.TxUser = user;

		
	}
	
	public void run()
	{
		emojiListener();
		receberMensagem();		
	}

	private void receberMensagem()
	{
		
		try
		{
			while(true)
			{
					dIn = new DataInputStream(cliente.getInputStream());	
					
					int op = dIn.readByte();
					
					if(op == 0)
					{
						StyledDocument doc = chat.getStyledDocument();
						
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
						
						if(Menu.frame.getState() == JFrame.ICONIFIED)
						{
							Notificacao not = new Notificacao(nick,msgs);
							not.exibir();
						}

					}
					else if(op == 1)
					{
						StyledDocument doc = TxUser.getStyledDocument();
						
						String nick = dIn.readUTF();
						
						Style style = TxUser.addStyle("nick",null);
						StyleConstants.setForeground(style, Color.RED);
						StyleConstants.setBold(style, true);
						doc.remove(0, doc.getLength());
						doc.insertString(0,nick, style);
							
					}
				}
			
			
		}
		catch(Exception e)
		{
				JOptionPane.showMessageDialog(null, "� aqui no Recebermensagen cliente: " + e);
		}
				
	}
	
	//Metodo que executa uma thread que vai procurar Emojis inseridos ou digitados em TxTexto
	private void emojiListener()
	{
		
		DocumentListener emoji = new DocumentListener(){
			
			public void insertUpdate(DocumentEvent event)
			{
				final DocumentEvent e = event;
				SwingUtilities.invokeLater(new Runnable(){

					@Override
					public void run()
					{
						if(e.getDocument() instanceof StyledDocument)
						{
							try
							{
								StyledDocument doc=(StyledDocument)e.getDocument();
								int start = Utilities.getRowStart(chat, Math.max(0, e.getOffset()-1));
								int end = Utilities.getWordStart(chat, e.getOffset()+e.getLength());
								String texto = doc.getText(start, end - start);
								
				
								
								for(String key: emojisss.emojis.keySet())
                                {
	                                int i=texto.indexOf(key);
	                                while(i>=0)
	                                {
	                                    final SimpleAttributeSet attrs=new SimpleAttributeSet(
	                                       doc.getCharacterElement(start+i).getAttributes());
	                                    
	                                    if (StyleConstants.getIcon(attrs)==null)
	                                    {
	                                        StyleConstants.setIcon(attrs, emojisss.emojis.get(key));
	                                        doc.remove(start+i, key.length());
	                                        doc.insertString(start+i,key, attrs);
	                                    }
	                                    i=texto.indexOf(key, i + key.length() );
	                                }
                                }
									
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
					}
					
					
					
				});
			}

			@Override
			public void changedUpdate(DocumentEvent e) { }

			@Override
			public void removeUpdate(DocumentEvent e) { }
			
		};

		chat.getDocument().addDocumentListener(emoji);
		
	}
	
}
