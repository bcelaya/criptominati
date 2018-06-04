package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.TextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private static JPasswordField passwordlogin;
	private static JPasswordField passwordnuevo;
	private static TextField loginuser;
	private static TextField loginnuevo;
	private static String stloginuser;
	private static String stloginpassword;
	private static String stloginnuevo;
	private static String stpasswordnuevo;
	private JButton enviarlogin;
	private JButton enviarnuevo;
    
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Este es el evento para comprobar que existe el usuario en la BBDD
		
		enviarlogin = new JButton("Entrar");
		enviarlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				stloginuser = loginuser.getText();
				stloginpassword = String.copyValueOf(passwordlogin.getPassword());
				String query = "SELECT COUNT(*) "+"FROM jugador "+"WHERE nombre='"+stloginuser+"' AND password=md5('"+stloginpassword+"')";
				try {
					if (dbAccess.DCount("*", "jugador", "nombre='"+stloginuser+"' AND password=md5('"+stloginpassword+"')")==1){
						VentanaJuego vj = new VentanaJuego();
						vj.setUsuario(stloginuser);
						vj.setVisible(true);
						dispose();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(query);
				System.out.println(stloginuser);
				System.out.println(stloginpassword);
			}
		});
		enviarlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		// Este es el evento para crear un nuevo usuario en la base de datos
		enviarnuevo = new JButton("Entrar");
		enviarnuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		enviarnuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stloginnuevo = loginnuevo.getText();
				stpasswordnuevo = String.copyValueOf(passwordnuevo.getPassword());
				System.out.println(stloginnuevo);
				System.out.println(stpasswordnuevo);
				String querynuevousuario = "INSERT INTO jugador (nombre,password) "+
				"VALUES ('"+ stloginnuevo + "', md5('"+ stpasswordnuevo+"'));";
				System.out.println(querynuevousuario);
				try {
					dbAccess.ExecuteNQ(querynuevousuario);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		loginuser = new TextField();
		loginuser.setBounds(280, 138, 186, 19);
		contentPane.add(loginuser);
		
		passwordlogin = new JPasswordField();
		passwordlogin.setBounds(280, 178, 186, 19);
		contentPane.add(passwordlogin);
		enviarnuevo.setBounds(485, 303, 117, 25);
		contentPane.add(enviarnuevo);
		
		loginnuevo = new TextField();
		loginnuevo.setBounds(280, 288, 186, 19);
		contentPane.add(loginnuevo);
		
		passwordnuevo = new JPasswordField();
		passwordnuevo.setBounds(280, 323, 186, 19);
		contentPane.add(passwordnuevo);
		enviarlogin.setBounds(485, 150, 117, 25);
		contentPane.add(enviarlogin);
		
		JLabel lblFondologin = new JLabel("fondo-login");
		lblFondologin.setIcon(new ImageIcon("/home/bruno/Imágenes/criptominatilogin2.png"));
		lblFondologin.setBounds(12, 0, 626, 358);
		contentPane.add(lblFondologin);
		
	}
}
