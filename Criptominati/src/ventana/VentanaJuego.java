package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.ShutdownChannelGroupException;
import java.sql.ResultSet;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	public static String nombrepj;
	public static JFormattedTextField valorBTC;
	public static JFormattedTextField valorBCH;
	public static JFormattedTextField valorETH;
	public static JFormattedTextField valorLTC;
	public static JTextField cantidadBTC;
	public static JTextField cantidadBCH;
	public static JTextField cantidadETH;
	public static JTextField cantidadLTC;
	private static int Turno;
	private static JFormattedTextField numTurno;
	private static float dineroefectivo;
	public static JTextField efectivo = new JTextField();
	public static TextField totalop;
	public static JTextField txtCarterabtc;
	public static JTextField txtCarteraeth;
	public static JTextField txtCarterabch;
	public static JTextField txtCarteraltc;
	private JTextField txtNombreusuario;
	private static float numBTC=0; // REPASAR ESTO A VER PORQUE NO ME LO MUESTRA
	private static float numETH=0;
	private static float numBCH=0;
	private static float numLTC=0;
	//private JTextField txtcarteraBTC;
	//private JTextField txtcarteraETH;
	//private JTextField txtcarteraBCH;
	//private JTextField txtcarteraLTC;
	private static boolean compra=true;
	private static JTable tablajuego;
	private float operacion;
	private JScrollPane scrollPane;
	private JLabel lblFondoventanajuego;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				//btnPasarTurno.setEnabled(false);
				// ahora vamos a recuperar el turno en el que se quedo el jugador la última vez que jugó
				try {
					ActualizaSaldoPantalla();
					RecuperarCantidades();
					//String querycuentoturno ="SELECT COUNT(*) FROM movimientos WHERE jugador='"+nombrepj+"';";
					//dbAccess.DCount(fieldName, tableName, whereCondition);
					Turno = (dbAccess.DCount("*", "movimientos", "jugador='"+nombrepj+"'"));
					// Como cada operación genera cuatro entradas debemos de dividir entre 4 el resultado para que el turno sea correcto
					Turno = Turno/4;
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txtNombreusuario.setText(nombrepj);
				ActualizaTurno(Turno);
				
				
				
				cantidadBTC.setText(String.valueOf(0));
				cantidadETH.setText(String.valueOf(0));
				cantidadBCH.setText(String.valueOf(0));
				cantidadLTC.setText(String.valueOf(0));
				ActualizarTabla();
				//txtcarteraBTC.setText(String.valueOf(numBTC));
				//txtcarteraETH.setText(String.valueOf(numETH));
				//txtcarteraBCH.setText(String.valueOf(numBCH));
				//txtcarteraLTC.setText(String.valueOf(numLTC));
				
				try {
					//efectivo.setValue(dbAccess.DSum("efectivo", "jugador", "nombre='bruno'"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Empezamos a incluir los iconos de las distintas monedas
		JLabel lblBTCIcon = new JLabel("BTC");
		lblBTCIcon.setIcon(new ImageIcon("/home/bruno/eclipse-workspace/Criptominati/img/btcicon.jpg"));
		lblBTCIcon.setBounds(28, 220, 65, 65);
		contentPane.add(lblBTCIcon);
		
		JLabel lblETHIcon = new JLabel("ETH");
		lblETHIcon.setIcon(new ImageIcon("/home/bruno/Imágenes/ethereumicon.jpg"));
		lblETHIcon.setBounds(128, 220, 65, 65);
		contentPane.add(lblETHIcon);
		
		JLabel lblBCHIcon = new JLabel("BCH");
		lblBCHIcon.setIcon(new ImageIcon("/home/bruno/Imágenes/bchicon.jpg"));
		lblBCHIcon.setBounds(228, 220, 65, 65);
		contentPane.add(lblBCHIcon);
		
		JLabel lblLTCIcon = new JLabel("LTC");
		lblLTCIcon.setIcon(new ImageIcon("/home/bruno/Imágenes/litecoinicon.jpg"));
		lblLTCIcon.setBounds(330, 220, 65, 65);
		contentPane.add(lblLTCIcon);
		
		valorBTC = new JFormattedTextField();
		valorBTC.setEditable(false);
		valorBTC.setBounds(24, 300, 75, 19);
		contentPane.add(valorBTC);
		valorBTC.setColumns(10);
		
		valorETH = new JFormattedTextField();
		valorETH.setEditable(false);
		valorETH.setColumns(10);
		valorETH.setBounds(124, 300, 75, 19);
		contentPane.add(valorETH);
		
		
		valorBCH = new JFormattedTextField();
		valorBCH.setEditable(false);
		valorBCH.setColumns(10);
		valorBCH.setBounds(224, 300, 75, 19);
		contentPane.add(valorBCH);
		
		valorLTC = new JFormattedTextField();
		valorLTC.setEditable(false);
		valorLTC.setColumns(10);
		valorLTC.setBounds(324, 300, 75, 19);
		contentPane.add(valorLTC);
		
		Label label = new Label("Efectivo");
		label.setBounds(30, 100, 68, 21);
		contentPane.add(label);
		
		numTurno = new JFormattedTextField();
		numTurno.setHorizontalAlignment(SwingConstants.RIGHT);
		numTurno.setEditable(false);
		numTurno.setBounds(550, 100, 105, 19);
		contentPane.add(numTurno);
		
		cantidadBTC = new JTextField();
		cantidadBTC.setBounds(24, 380, 75, 19);
		contentPane.add(cantidadBTC);
		
		cantidadETH = new JTextField();
		cantidadETH.setBounds(124, 380, 75, 19);
		contentPane.add(cantidadETH);
		
		cantidadBCH = new JTextField();
		cantidadBCH.setBounds(224, 380, 75, 19);
		contentPane.add(cantidadBCH);
		
		cantidadLTC = new JTextField();
		cantidadLTC.setBounds(324, 380, 75, 19);
		contentPane.add(cantidadLTC);
		
		
		efectivo.setEditable(false);
		efectivo.setBounds(100, 100, 320, 26);
		contentPane.add(efectivo);
		
		JFormattedTextField frmtdtxtfldNTurno = new JFormattedTextField();
		frmtdtxtfldNTurno.setEditable(false);
		frmtdtxtfldNTurno.setText("Nº Turno");
		frmtdtxtfldNTurno.setBounds(570, 120, 65, 19);
		contentPane.add(frmtdtxtfldNTurno);
		
		totalop = new TextField();
		totalop.setEditable(false);
		totalop.setBounds(150, 450, 175, 14);
		contentPane.add(totalop);
		
		JLabel lblTotalOperacion = new JLabel("Total operación");
		lblTotalOperacion.setForeground(Color.WHITE);
		lblTotalOperacion.setBounds(20, 450, 118, 15);
		contentPane.add(lblTotalOperacion);
		
		JLabel lblOperar = new JLabel("OPERAR");
		lblOperar.setForeground(Color.WHITE);
		lblOperar.setBounds(185, 350, 70, 15);
		contentPane.add(lblOperar);
		
		txtCarterabtc = new JTextField();
		txtCarterabtc.setEditable(false);
		txtCarterabtc.setText(""+numBTC);
		txtCarterabtc.setBounds(24, 189, 75, 19);
		contentPane.add(txtCarterabtc);
		txtCarterabtc.setColumns(10);
		
		txtCarteraeth = new JTextField();
		txtCarteraeth.setEditable(false);
		txtCarteraeth.setText(""+numETH);
		txtCarteraeth.setBounds(124, 189, 75, 19);
		contentPane.add(txtCarteraeth);
		txtCarteraeth.setColumns(10);
		
		txtCarterabch = new JTextField();
		txtCarterabch.setEditable(false);
		txtCarterabch.setText(""+numBCH);
		txtCarterabch.setBounds(224, 189, 75, 19);
		contentPane.add(txtCarterabch);
		txtCarterabch.setColumns(10);
		
		txtCarteraltc = new JTextField();
		txtCarteraltc.setEditable(false);
		txtCarteraltc.setText(""+numLTC);
		txtCarteraltc.setBounds(324, 189, 75, 19);
		contentPane.add(txtCarteraltc);
		txtCarteraltc.setColumns(10);
		
		txtNombreusuario = new JTextField();
		txtNombreusuario.setEditable(false);
		txtNombreusuario.setText("nombreusuario");
		txtNombreusuario.setBounds(100, 69, 114, 19);
		contentPane.add(txtNombreusuario);
		txtNombreusuario.setColumns(10);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setForeground(Color.WHITE);
		lblJugador.setBounds(29, 69, 70, 15);
		contentPane.add(lblJugador);
		
		JButton btnComprar_1 = new JButton("COMPRAR");
		btnComprar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				compra = true;
				Transaccion(1);
				Turno+=1;
				ActualizaTurno(Turno);
				ActualizarTabla();
				
				
			}
		});
		btnComprar_1.setBounds(25, 475, 200, 25);
		contentPane.add(btnComprar_1);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				compra=false;
				comprobarCantidadDivisa();
				if (cantidadsuficiente) {
				Transaccion(-1);
				Turno+=1;
				ActualizaTurno(Turno);
				ActualizarTabla();
			
			}else {
				System.out.println("No dispones de esa cantidad de monedas (verificado)");
			}
			}
		});
		btnVender.setBounds(250, 475, 200, 25);
		contentPane.add(btnVender);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(462, 189, 326, 310);
		contentPane.add(scrollPane);
		
		tablajuego = new JTable();
		scrollPane.setViewportView(tablajuego);
		tablajuego.setFillsViewportHeight(true);
		
		lblFondoventanajuego = new JLabel("fondoventanajuego");
		lblFondoventanajuego.setIcon(new ImageIcon("/home/bruno/Imágenes/capaventanagrisf.png"));
		lblFondoventanajuego.setBounds(12, 0, 776, 558);
		contentPane.add(lblFondoventanajuego);
	}

	public static int getTurno() {
		return Turno;
	}

	public void setTurno(int turno) {
		Turno = turno;
	}
	private static void ActualizaTurno(int valor) {
		numTurno.setValue(valor);
		ActualizaCotizacion();
		
	}
	/**
	 * 
	 *
	 */
	private static void ActualizaCotizacion() {
		valorBTC.setValue(MiClienteREST.peticionAPIBTC());
		valorETH.setValue(MiClienteREST.peticionAPIETH());
		valorBCH.setValue(MiClienteREST.peticionAPIBCH());
		valorLTC.setValue(MiClienteREST.peticionAPILTC());
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void Transaccion(float operacion) {
		
		//Aquí se procede a restar o sumar el total de la operación del efectivo, compra=true es compra y false es venta:
		float valorBTCtemp=(float)valorBTC.getValue();
		float valorETHtemp=(float)valorETH.getValue();
		float valorBCHtemp=(float)valorBCH.getValue();
		float valorLTCtemp=(float)valorLTC.getValue();
		// 	Aquí recogemos los datos introducidos en los jtextlabel
		float cantidadBTCtemp = operacion*Float.valueOf(cantidadBTC.getText());
		float cantidadETHtemp = operacion*Float.valueOf(cantidadETH.getText());
		float cantidadBCHtemp = operacion*Float.valueOf(cantidadBCH.getText());
		float cantidadLTCtemp = operacion*Float.valueOf(cantidadLTC.getText());
		// Aquí tenemos que poner el chequeador de que los campos introducidos son válidos
	
		//Aquí introducimos las monedas por el coste:
		float totaloperacionBTC = -(valorBTCtemp * cantidadBTCtemp);
		float totaloperacionETH = -(valorETHtemp * cantidadETHtemp);
		float totaloperacionBCH = -(valorBCHtemp * cantidadBCHtemp);
		float totaloperacionLTC = -(valorLTCtemp * cantidadLTCtemp);
		
		//Aquí procedemos a hacer los cálculos de compras y ventas:
		float totalcantidad = ((totaloperacionBTC + totaloperacionETH + totaloperacionBCH + totaloperacionLTC));
		System.out.println("Total cantidad: " + totalcantidad);
		//Mostramos el total en el campo total operación:
		totalop.setText(String.valueOf(totalcantidad));
		

		
		dineroefectivo = dineroefectivo + totalcantidad;
		if(dineroefectivo<0 && operacion==-1) {
			//no se puede realizar la operacion
			
		} else {
			efectivo.setText(String.valueOf(dineroefectivo));
			// acumulamos el dinero en sus contadores <--- REVISAR
			numBTC += cantidadBTCtemp;
			numETH += cantidadETHtemp;
			numBCH += cantidadBCHtemp;
			numLTC += cantidadLTCtemp;
			System.out.println(cantidadBTCtemp);
			System.out.println(cantidadETHtemp);
			System.out.println(cantidadBCHtemp);
			System.out.println(cantidadLTCtemp);
			String query = "INSERT INTO movimientos (jugador,cantidadbtc,cantidadeth,cantidadbch,cantidadltc) " +
			"VALUES ('"+nombrepj+"',"+cantidadBTCtemp+", "+cantidadETHtemp+", "+cantidadBCHtemp+", "+cantidadLTCtemp+");";
			System.out.println(query);
			String queryUpdate = "UPDATE jugador "+
			        "SET capital = capital + " + totalcantidad + " "+
					"WHERE nombre = '" + nombrepj + "'";
			System.out.println(queryUpdate);
			try {
				dbAccess.ExecuteNQ(query);
				dbAccess.ExecuteNQ(queryUpdate);
				System.out.println(query);
				RecuperarCantidades();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dineroefectivo = dineroefectivo + totalcantidad;
			System.out.println("EL resultado de dinero efectivo es : "+dineroefectivo);
			efectivo.setText(String.valueOf(dineroefectivo));
			ActualizarTabla();
			
			
			try {
				efectivo.setText(String.valueOf(dbAccess.DSum("capital", "jugador", "nombre = '" + nombrepj + "'")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		
		
	}
		
	public static void ActualizaSaldoPantalla() {
		// Aquí vamos a recuperar la cantidad de la BBDD que disponemos de cada divisa
		String querycapital ="SELECT capital FROM jugador WHERE nombre='"+nombrepj+"' ORDER BY nombre DESC LIMIT 1;"; 
		try {
			ResultSet hola = dbAccess.exQuery(querycapital);
			while (hola.next()) {
				float saldo = hola.getFloat(1);
				dineroefectivo = saldo;
				efectivo.setText(String.valueOf(dineroefectivo));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}	
	
	public static void ActualizarTabla() {
		String query="SELECT fecha,cantidadbtc AS btc, cantidadeth AS eth, cantidadBCH AS bch, cantidadltc AS ltc FROM movimientos WHERE jugador='"+nombrepj+"' ORDER BY fecha, jugador";
		DefaultTableModel modelo=dbAccess.ObtenerModelo(query);
		tablajuego.setModel(modelo);
	}
	
	public static void RecuperarCantidades() {
		String query="SELECT SUM(cantidadbtc),SUM(cantidadeth),SUM(cantidadbch),SUM(cantidadLTC) FROM movimientos WHERE jugador='"+nombrepj+"';";
		try {
			ResultSet cartera = dbAccess.exQuery(query);
			while (cartera.next()) {
				float tempbtc = cartera.getFloat(1);
				float tempeth = cartera.getFloat(2);
				float tempbch = cartera.getFloat(3);
				float templtc = cartera.getFloat(4);
				System.out.println("tempbtc: " + tempbtc);
				System.out.println("tempeth: " + tempeth);
				System.out.println("tempbch: " + tempbch);
				System.out.println("templtc: " + templtc);
				
				
				// vamos a ponerlos en el campo que los muestra al jugador
				txtCarterabtc.setText(String.valueOf(tempbtc));
				txtCarteraeth.setText(String.valueOf(tempeth));
				txtCarterabch.setText(String.valueOf(tempbch));
				txtCarteraltc.setText(String.valueOf(templtc));
				
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static boolean cantidadsuficiente;
	public void setUsuario(String usuario) {
		nombrepj = usuario;
	}
	public void comprobarCantidadDivisa() {
		
	if	(Float.valueOf(txtCarterabtc.getText()) < Float.valueOf(cantidadBTC.getText()) || Float.valueOf(txtCarteraeth.getText()) < Float.valueOf(cantidadETH.getText()) || Float.valueOf(txtCarterabch.getText()) < Float.valueOf(cantidadBCH.getText()) || Float.valueOf(txtCarteraltc.getText()) < Float.valueOf(cantidadLTC.getText())) {
System.out.println("no dispones de tantas monedas");
cantidadsuficiente = false;
	 }
	else {
		cantidadsuficiente=true;
	}
	}
	}

