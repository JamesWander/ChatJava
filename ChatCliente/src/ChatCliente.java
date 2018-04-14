import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
		setBounds(100, 100, 564, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(3, 3, 433, 260);
		DefaultCaret caret = (DefaultCaret)textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		//textPane.setContentType("text/html");
		//panel.add(textPane);
		
		JScrollPane panel = new JScrollPane(textPane);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(2, 4, 441, 266);
		contentPane.add(panel);
		//panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(1, 274, 442, 104);
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
		
		BtEnviar.setBounds(448, 276, 106, 99);
		contentPane.add(BtEnviar);
		
		conectarServidor();
		
		
	}

	private void conectarServidor()
	{
		try
		{
			//preparando o socket do cliente
			cliente = new Socket(ipdoServidor,portadoServidor);
			
			//Criando um OutputStream pra mandar mensagens pro servidor
			
			ReceberMensagem receber = new ReceberMensagem(cliente,textPane);
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
			String aux = TxTexto.getText();
			dOut.writeUTF(nick);
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
	
	
	
	
	
	
}
