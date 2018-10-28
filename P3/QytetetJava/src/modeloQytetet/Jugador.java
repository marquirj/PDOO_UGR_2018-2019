/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloQytetet;

import java.util.ArrayList;

/**
 *
 * @author marquirj
 */
public class Jugador implements Comparable{
    private boolean encarcelado=false;
    private String nombre;
    private int saldo = 7500;
    private ArrayList<TituloPropiedad> propiedades=new ArrayList<>();
    private Sorpresa cartaLibertad;
    private ArrayList<Casilla> casillaActual;
    
    @Override
     public int compareTo(Object otroJugador){
         int otroCapital = ((Jugador) otroJugador).obtenerCapital();
         return otroCapital - obtenerCapital();
                
     }
    
    Jugador(String name){
        this.nombre=name;
        this.saldo=7500;
        this.cartaLibertad = null;
        this.propiedades=new ArrayList<>();
        //this.casillaActual=casillaActual.getNumeroCasilla();
    }

    public boolean isEncarcelado() {
        return encarcelado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }

    public Sorpresa getCartaLibertad() {
        return cartaLibertad;
    }

    public ArrayList<Casilla> getCasillaActual() {
        return casillaActual;
    }

    public void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    public void setCartaLibertad(Sorpresa cartaLibertad) {
        this.cartaLibertad = cartaLibertad;
    }

    public void setCasillaActual(ArrayList<Casilla> casillaActual) {
        this.casillaActual = casillaActual;
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean comprarTituloPropiedad( ){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int cuantasCasasHotelesTengo(){
        int casas=0, hoteles=0;
        for (TituloPropiedad propiedad : propiedades){
            casas=casas+propiedad.getNumCasas();
            hoteles=hoteles+propiedad.getNumHoteles();
        }
        return casas+ hoteles;
    }
    Sorpresa devolverCartaLibertad(){
        Sorpresa carta = this.cartaLibertad;
        this.cartaLibertad=null;
        return carta;
    }
    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void eliminarDeMisPropiedades(TituloPropiedad titulo){}
    boolean esDeMiPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean hipotecarPropiedad(TituloPropiedad tiutlo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void irALaCarcel(Casilla casilla){}
    int modificarSaldo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int obtenerCapital(){
        int capital=this.saldo;
        int valorPropiedades=0;
        for(TituloPropiedad propiedad : propiedades){
            if(!propiedad.isHipotecado())
                valorPropiedades= valorPropiedades + propiedad.getPrecioCompra() + (propiedad.getNumHoteles() + propiedad.getNumCasas()) *propiedad.getPrecioEdificar();
            else
                valorPropiedades= valorPropiedades + propiedad.getPrecioCompra() + (propiedad.getNumHoteles() + propiedad.getNumCasas()) *propiedad.getPrecioEdificar() - propiedad.getHipotecaBase();
         }
        return capital + valorPropiedades;
    }
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void pagarAlquiler(){}
    void pagarImpuesto(){}
    void pagarLibertad(int cantidad){}
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean tengoSaldo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "Jugador{" + "encarcelado=" + encarcelado + ", nombre=" + nombre + ", saldo=" + saldo + ", propiedades=" + propiedades + ", cartaLibertad=" + cartaLibertad + ", casillaActual=" + casillaActual + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}
