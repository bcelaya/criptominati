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
public class Usuario {
    private int idjugador;
    private String nombre;
    private float euros;
    private float bitcoin;
    private float bitcoincash;
    private float ethereum;
    private float litecoin;
    private float puntuacion;
    
    public int getId(){
    return idjugador;
    }
    public void setId(int idjugador){
    this.idjugador = idjugador;
    }
    
    public String getNombre(){
     return nombre;   
    }
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    
    public float getEuros() {
    	return euros;
    }
    
    public void setEuros(float euros) {
    	this.euros = euros;
    }
    
    public float getBitcoin(){
    return bitcoin;
    }
    public void setBitcoin(float bitcoin){
    this.bitcoin = bitcoin;
    }
    
    public float getBitcoincash(){
    return bitcoincash;
    }
    public void setBitcoincash(float bitcoincash){
    this.bitcoincash = bitcoincash;
    }
    
    public float getEthereum(){
    return ethereum;
    }
    public void setEthereum(float ethereum){
    this.ethereum = ethereum;
    }
    
    public float getLitecoin(){
    return litecoin;
    }
    public void setLitecoin(float litecoin){
    this.litecoin = litecoin;
    }
    
    public float getPuntuacion(){
    return puntuacion;
    }
    public void setPuntuacion(float puntuacion){
    this.puntuacion = puntuacion;
     }
    
    
    public static void main (String args[]) {
    	//Usuario jugador = new Usuario('');
    }
    }

