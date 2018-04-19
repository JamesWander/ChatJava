import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;



@SuppressWarnings("serial")
public class ChatCliente extends JFrame {

	private JPanel contentPane;
	private String ipdoServidor;
	private int portadoServidor;
	private JTextPane textPane;
	private Socket cliente;
	private DataOutputStream dOut;
	private JTextPane TxTexto;
	public static String nick;
	private JTextPane textPane_1;
	private JScrollPane scrollPane;
	private Emojis emojisss = new Emojis();
	private JPanel emojiPane;
	
	
	/**
	 * Create the frame.
	 */
	public ChatCliente(String ip, String porta, String nick)
	{
		
		this.ipdoServidor = ip;
		this.portadoServidor = Integer.parseInt(porta);
		ChatCliente.nick = nick;
		
		setResizable(false);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(3, 3, 433, 260);
		DefaultCaret caret = (DefaultCaret)textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		emojiPane = new JPanel();
		emojiPane.setVisible(false);
		emojiPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		emojiPane.setBounds(3, 308, 408, 103);
		contentPane.add(emojiPane);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TxTexto.setText(TxTexto.getText() + "::em13:: ");
				emojiPane.setVisible(false);
			}
		});
		button_6.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (13).png")));
		
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em14:: ");
				emojiPane.setVisible(false);
			}
		});
		button_7.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (14).png")));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em12:: ");
				emojiPane.setVisible(false);
			}
		});
		button_4.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (12).png")));
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em11:: ");
				emojiPane.setVisible(false);
			}
		});
		button_5.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (11).png")));
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (10).png")));
		
		JButton button_22 = new JButton("");
		button_22.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (15).png")));
		
		JButton button_12 = new JButton("");
		button_12.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (3).png")));
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (1).png")));
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (17).png")));
		
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (18).png")));
		
		JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (19).png")));
		
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (2).png")));
		
		JButton button_17 = new JButton("");
		button_17.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (20).png")));
		
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (21).png")));
		
		JButton button_14 = new JButton("");
		button_14.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (29).png")));
		
		JButton button_15 = new JButton("");
		button_15.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (23).png")));
		
		JButton button_16 = new JButton("");
		button_16.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (24).png")));
		
		JButton button_18 = new JButton("");
		button_18.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (25).png")));
		
		JButton button_19 = new JButton("");
		button_19.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (26).png")));
		
		JButton button_20 = new JButton("");
		button_20.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (27).png")));
		
		JButton button_21 = new JButton("");
		button_21.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (28).png")));
		FlowLayout fl_emojiPane = new FlowLayout(FlowLayout.LEFT, 0, 0);
		emojiPane.setLayout(fl_emojiPane);
		emojiPane.add(button_6);
		emojiPane.add(button_7);
		emojiPane.add(button_4);
		emojiPane.add(button_5);
		emojiPane.add(button_3);
		emojiPane.add(button_22);
		emojiPane.add(button_12);
		emojiPane.add(button_2);
		emojiPane.add(button_8);
		emojiPane.add(button_9);
		emojiPane.add(button_10);
		emojiPane.add(button_11);
		emojiPane.add(button_17);
		emojiPane.add(button_13);
		emojiPane.add(button_14);
		emojiPane.add(button_15);
		emojiPane.add(button_16);
		emojiPane.add(button_18);
		emojiPane.add(button_19);
		emojiPane.add(button_20);
		emojiPane.add(button_21);
		
		
		JScrollPane panel = new JScrollPane(textPane);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(2, 4, 441, 266);
		contentPane.add(panel);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(2, 322, 442, 104);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		TxTexto = new JTextPane();
			
		TxTexto.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown())
				{
					e.consume();
					TxTexto.setText(TxTexto.getText()+"\n");
				}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown())
				{
					e.consume();
					enviarMensagem();
					TxTexto.setCaretPosition(0);
				}
				if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
				{
					removerEmoji();
				}
			}
		});
		TxTexto.setBounds(4, 3, 433, 97);
		panel_1.add(TxTexto);
		
		JButton BtEnviar = new JButton("Enviar");
		BtEnviar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				enviarMensagem();
			}

		
		});
		
		BtEnviar.setBounds(449, 324, 133, 99);
		contentPane.add(BtEnviar);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(448, 4, 133, 266);
		contentPane.add(scrollPane);
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		scrollPane.setViewportView(textPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(3, 279, 579, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton BtEmoji = new JButton("");
		BtEmoji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emojiPane.setVisible(true);
			}
		});
		BtEmoji.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (27).png")));
		BtEmoji.setBounds(0, 0, 53, 30);
		panel_2.add(BtEmoji);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/ImageIcon.png")));
		button.setBounds(60, 0, 53, 30);
		panel_2.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/question.png")));
		button_1.setBounds(120, 0, 53, 30);
		panel_2.add(button_1);
		
		conectarServidor();
		
		emojiListener();
		
		
	}

	private void conectarServidor()
	{
		try
		{
			//preparando o socket do cliente
			cliente = new Socket(ipdoServidor,portadoServidor);
			dOut = new DataOutputStream(cliente.getOutputStream());
			dOut.writeUTF(nick);
			dOut.flush();
						
			ReceberMensagem receber = new ReceberMensagem(cliente,textPane,textPane_1);
			receber.start();
			
			
		}
		catch(Exception e){}
	}	
	
	private void enviarMensagem() 
	{
		try
		{			
			//Mandando a String
			dOut = new DataOutputStream(cliente.getOutputStream());
			String aux = TxTexto.getText() + " ";
			dOut.writeUTF(aux);
			dOut.flush();
			TxTexto.setText("");
			TxTexto.setCaretPosition(0);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ChatCliente: " +e);
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
								int start = Utilities.getRowStart(TxTexto, Math.max(0, e.getOffset()-1));
								int end = Utilities.getWordStart(TxTexto, e.getOffset()+e.getLength());
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
			public void removeUpdate(DocumentEvent e) { 
				
	
			}
			
		};
		
		TxTexto.getDocument().addDocumentListener(emoji);

	}
	
	
	private void removerEmoji()
	{
		StyledDocument doc=(StyledDocument)TxTexto.getDocument();
		
		//Modificar o Codigo pra pegar a posicao do cursor para conseguir remover o emoji so apertando o backspace uma vez Independentemente de onde o emoji estiver
		
		try 
		{

			if(doc.getLength() > 7)
			{
				String teste = doc.getText(doc.getLength()-8, 8);
				if(teste.contains("::em"))
				{
					doc.remove(doc.getLength()-8, 7);
				}
			}
			
		} catch (BadLocationException e1)
		{
			e1.printStackTrace();
		}
		
	}
	
}
