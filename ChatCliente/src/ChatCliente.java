import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager.*;
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
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.InlineView;
import javax.swing.text.html.ParagraphView;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.SizeRequirements;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;



@SuppressWarnings("serial")
public class ChatCliente extends JFrame {

	private JPanel contentPane;
	private String ipdoServidor;
	private int portadoServidor;
	private JTextPane textPane;
	private Socket cliente;
	private DataOutputStream dOut;
	private JTextPane TxTexto;
	public  String nick;
	private JTextPane textPane_1;
	private JScrollPane scrollPane;
	private Emojis emojisss = new Emojis();
	private JLayeredPane emojiPane;
	private JPanel noWrapPanel;
	private JScrollPane textoScroll;
	
	
	
	/**
	 * Create the frame.
	 */
	public ChatCliente(String ip, String porta, String nick)
	{
		
		setLookAndFeel();
		
		this.ipdoServidor = ip;
		this.portadoServidor = Integer.parseInt(porta);
		this.nick = nick;
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		
		
		emojiPane = new JLayeredPane();
		emojiPane.setVisible(false);
		emojiPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TxTexto.setText(TxTexto.getText() + "::em10:: ");
				emojiPane.setVisible(false);
			}
		});
		button_3.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (10).png")));
		
		JButton button_22 = new JButton("");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em15:: ");
				emojiPane.setVisible(false);
			}
		});
		button_22.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (15).png")));
		
		JButton button_12 = new JButton("");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em3:: ");
				emojiPane.setVisible(false);
			}
		});
		button_12.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (3).png")));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em1:: ");
				emojiPane.setVisible(false);
			}
		});
		button_2.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (1).png")));
		
		
		
		JButton button_8 = new JButton("");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em17:: ");
				emojiPane.setVisible(false);
			}
		});
		button_8.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (17).png")));
		
		JButton button_9 = new JButton("");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em18:: ");
				emojiPane.setVisible(false);
			}
		});
		button_9.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (18).png")));
		
		JButton button_10 = new JButton("");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em19:: ");
				emojiPane.setVisible(false);
			}
		});
		button_10.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (19).png")));
		
		JButton button_11 = new JButton("");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em2:: ");
				emojiPane.setVisible(false);
			}
		});
		button_11.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (2).png")));
		
		JButton button_17 = new JButton("");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em20:: ");
				emojiPane.setVisible(false);
			}
		});
		button_17.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (20).png")));
		
		JButton button_13 = new JButton("");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em21:: ");
				emojiPane.setVisible(false);
			}
		});
		button_13.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (21).png")));
		
		JButton button_14 = new JButton("");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em29:: ");
				emojiPane.setVisible(false);
			}
		});
		button_14.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (29).png")));
		
		JButton button_15 = new JButton("");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em23:: ");
				emojiPane.setVisible(false);
			}
		});
		button_15.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (23).png")));
		
		JButton button_16 = new JButton("");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em24:: ");
				emojiPane.setVisible(false);
			}
		});
		button_16.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (24).png")));
		
		JButton button_18 = new JButton("");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em25:: ");
				emojiPane.setVisible(false);
			}
		});
		button_18.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (25).png")));
		
		JButton button_19 = new JButton("");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em26:: ");
				emojiPane.setVisible(false);
			}
		});
		button_19.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (26).png")));
		
		JButton button_20 = new JButton("");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em27:: ");
				emojiPane.setVisible(false);
			}
		});
		button_20.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (27).png")));
		
		JButton button_21 = new JButton("");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxTexto.setText(TxTexto.getText() + "::em28:: ");
				emojiPane.setVisible(false);
			}
		});
		button_21.setIcon(new ImageIcon(ChatCliente.class.getResource("/imagens/EM (28).png")));
		FlowLayout fl_emojiPane = new FlowLayout(FlowLayout.LEFT, -2, -2);
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
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		DefaultCaret caret = (DefaultCaret)textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);	
		
		JScrollPane panel = new JScrollPane(textPane);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setViewportView(textPane);
		
		TxTexto = new JTextPane();
		TxTexto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(emojiPane.isVisible())
				{
					emojiPane.setVisible(false);
				}
				
			}
		});
		TxTexto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		TxTexto.addKeyListener(new KeyAdapter() {
		
		public void keyPressed(KeyEvent e) {
			
			if(emojiPane.isVisible())
			{
				emojiPane.setVisible(false);
			}
			
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
		
		JButton BtEnviar = new JButton("Enviar");
		BtEnviar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				enviarMensagem();
				emojiPane.setVisible(false);
			}

		
		});
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		textoScroll = new JScrollPane((Component) null);
		textoScroll.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textoScroll.setViewportView(TxTexto);
		
		textPane_1 = new JTextPane();
		textPane_1.setContentType("text/html");
		textPane_1.setEditable(false);
		scrollPane.setViewportView(textPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(null);
		
		JButton BtEmoji = new JButton("");
		BtEmoji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(emojiPane.isVisible())
				{
					emojiPane.setVisible(false);
				}
				else
				{
					emojiPane.setVisible(true);
				}
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(1)
								.addComponent(emojiPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textoScroll, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
								.addGap(144))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(447)
							.addComponent(BtEnviar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(textoScroll, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(emojiPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(BtEnviar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
		
		arrumarTexto();
		
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
						
			ReceberMensagem receber = new ReceberMensagem(cliente,textPane,textPane_1,nick);
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
	
	private void setLookAndFeel()
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
	
	private void arrumarTexto()
	{

		HTMLEditorKit wrapper = new HTMLEditorKit(){ 
	           @Override 
	           public ViewFactory getViewFactory(){ 
	 
	               return new HTMLFactory(){ 
	                   public View create(Element e){ 
	                      View v = super.create(e); 
	                      if(v instanceof InlineView){ 
	                          return new InlineView(e){ 
	                              public int getBreakWeight(int axis, float pos, float len) { 
	                                  return GoodBreakWeight; 
	                              } 
	                              public View breakView(int axis, int p0, float pos, float len) { 
	                                  if(axis == View.X_AXIS) { 
	                                      checkPainter(); 
	                                      int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len); 
	                                      if(p0 == getStartOffset() && p1 == getEndOffset()) { 
	                                          return this; 
	                                      } 
	                                      return createFragment(p0, p1); 
	                                  } 
	                                  return this; 
	                                } 
	                            }; 
	                      } 
	                      else if (v instanceof ParagraphView) { 
	                          return new ParagraphView(e) { 
	                              protected SizeRequirements calculateMinorAxisRequirements(int axis, SizeRequirements r) { 
	                                  if (r == null) { 
	                                        r = new SizeRequirements(); 
	                                  } 
	                                  float pref = layoutPool.getPreferredSpan(axis); 
	                                  float min = layoutPool.getMinimumSpan(axis); 
	                                  // Don't include insets, Box.getXXXSpan will include them. 
	                                    r.minimum = (int)min; 
	                                    r.preferred = Math.max(r.minimum, (int) pref); 
	                                    r.maximum = Integer.MAX_VALUE; 
	                                    r.alignment = 0.5f; 
	                                  return r; 
	                                } 
	 
	                            }; 
	                        } 
	                      return v; 
	                    } 
	                }; 
	            } 
	        };
		
		textPane.setEditorKit(wrapper);
		textPane_1.setEditorKit(wrapper);
		
		StyledDocument doc = textPane_1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
	}
}
