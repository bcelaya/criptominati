/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

/**
 *
 * @author bcelaya
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MiClienteREST {
	String ResultadoBTC;
	String ResultadoETH;
	String ResultadoBCH;
	String ResultadoLTC;
	// Realiza una petición REST a la dirURL especificada.
	// Devuelve un String con la respuesta a la petición.
	// Si se produce una excepción, muestra el error y devuelve null
	public static String request(String dirURL) {

		try {
			
			// Creamos una URL y una conexión a URL
			URL url = new URL(dirURL);
			URLConnection urlConn = url.openConnection();

			// Creamos un InputStreamReader & BufferedReader para leer la respuesta
			InputStreamReader isr = new InputStreamReader(urlConn.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// Mientras el buffer no esté vacio, leemos chars y almacenamos en String
			String txt = "";
			int c;
			while ((c = br.read()) != -1) {
				txt = txt + (char) c;
			}

			// Cerramos el BufferedReader y el InputStreamReader
			br.close();
			isr.close();

			// Devolvemos la respuesta
			return txt;
			
		} catch (Exception e) {
			
			// Mostramos información de la excepción
			System.out.print("Compruebe si hay algún error tipográfico. ");
			
			// Devolvemos null
			return null;
		}
	}
public static int ValorDivisa (String a){
    // Esto es un método para coger simplemente el valor y convertirlo en entero
    // que es lo que nos interesa para el juego, ya que con esto es con lo que jugaré
    int divisa_int = 0;
    
            
return divisa_int ;
}
public static float peticionAPIBTC(){
    // inicio prueba
    System.out.println("Hola soy el cliente REST");
    // String ResultadoMulti = MiClienteREST.request("https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH,BCH,LTC&tsyms=EUR");
    // inicio peticiones con la clase MiClienteREST y su método request
    String ResultadoBTC = MiClienteREST.request("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=EUR");
    
    int longitudBTC = ResultadoBTC.length()-1;
   
    String BTCValorString = ResultadoBTC.substring(7,longitudBTC);
   
    // Como comentamos antes ahora pasamos la cadena del valor a Float
    float BTCValorFloat = Float.parseFloat(BTCValorString);
    
    return BTCValorFloat;
    }

public static float peticionAPIETH() {
	String ResultadoETH = MiClienteREST.request("https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=EUR");
	int longitudETH = ResultadoETH.length()-1;
	String ETHValorString = ResultadoETH.substring(7,longitudETH);
	float ETHValorFloat = Float.parseFloat(ETHValorString);

    return ETHValorFloat;
}
public static float peticionAPIBCH() {
	String ResultadoBCH = MiClienteREST.request("https://min-api.cryptocompare.com/data/price?fsym=BCH&tsyms=EUR");
	int longitudBCH = ResultadoBCH.length()-1;
    String BCHValorString = ResultadoBCH.substring(7,longitudBCH);
    float BCHValorFloat = Float.parseFloat(BCHValorString);
   
    return BCHValorFloat;
	
}
public static float peticionAPILTC() {
	String ResultadoLTC = MiClienteREST.request("https://min-api.cryptocompare.com/data/price?fsym=LTC&tsyms=EUR");
	int longitudLTC = ResultadoLTC.length()-1;
	String LTCValorString = ResultadoLTC.substring(7,longitudLTC);
	float LTCValorFloat = Float.parseFloat(LTCValorString);
	
	return LTCValorFloat;
}
}