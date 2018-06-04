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
public class Criptominati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //MiClienteREST micliente = new MiClienteREST();
        // pruebo a llamar al metodo de la clase para conseguir la cotización
        System.out.println(MiClienteREST.peticionAPIBTC());
        System.out.println(MiClienteREST.peticionAPIETH());
        System.out.println(MiClienteREST.peticionAPIBCH());
        System.out.println(MiClienteREST.peticionAPILTC());
        //VentanaJuego frame = new VentanaJuego();
        VentanaLogin frame = new VentanaLogin();
		frame.setVisible(true);
    }
    
}
