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
    private Casilla casillaActual;
    
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

    public Casilla getCasillaActual() {
        return casillaActual;
    }

    public void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    public void setCartaLibertad(Sorpresa cartaLibertad) {
        this.cartaLibertad = cartaLibertad;
    }

    public void setCasillaActual(Casilla casillaActual) {
        this.casillaActual = casillaActual;
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean comprarTituloPropiedad( ){
        int costeCompra=casillaActual.getCoste();
        boolean comprado=false;
        if(costeCompra<saldo){
            TituloPropiedad titulo = casillaActual.asignarPropietario(this);
            titulo.setPropietario(this);
            comprado=true;
        }
        return comprado;
    }
    int cuantasCasasHotelesTengo(){
        int casas=0, hoteles=0;
        for (TituloPropiedad propiedad : propiedades){
            casas=casas+propiedad.getNumCasas();
            hoteles=hoteles+propiedad.getNumHoteles();
        }
        return casas+ hoteles;
    }
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa carta = this.cartaLibertad;
        this.cartaLibertad=null;
        return carta;
    }
    boolean edificarCasa(TituloPropiedad titulo){
        int numCasas=titulo.getNumCasas();
        boolean edificada=false;
        if(numCasas<4){
            int costeEdificarCasa= titulo.getPrecioEdificar();
            boolean tengoSaldo=tengoSaldo(costeEdificarCasa);
            if(tengoSaldo){
                titulo.edificarCasa();
                modificarSaldo(-costeEdificarCasa);
                edificada=true;
            }
        }
        return edificada;
    }
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void eliminarDeMisPropiedades(TituloPropiedad titulo){}
    
    boolean esDeMiPropiedad(TituloPropiedad titulo){
        for(TituloPropiedad propiedad : propiedades){
            if(titulo.getNombre()== propiedad.getNombre()){
                return true;
            }
        }
        return false;
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean hipotecarPropiedad(TituloPropiedad tiutlo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void irALaCarcel(Casilla casilla){
    
    }
    int modificarSaldo(int cantidad){
        this.saldo = this.saldo + cantidad;
        return this.saldo;
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
        ArrayList<TituloPropiedad> aux = new ArrayList<>();
        for(TituloPropiedad propiedad :propiedades){
            if(propiedad.isHipotecado() == hipotecada){
                aux.add(propiedad);
            }
            
        }
        return aux;
    }
    void pagarAlquiler(){}
    void pagarImpuesto(){
        this.saldo = this.saldo - this.casillaActual.getCoste();
    }
    void pagarLibertad(int cantidad){}
    boolean tengoCartaLibertad(){
        if(this.cartaLibertad!=null){
            return true;
        }else
            return false;
    }
    boolean tengoSaldo(int cantidad){
        return this.saldo > cantidad;
    }
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "Jugador{" + "encarcelado=" + encarcelado + ", nombre=" + nombre + ", saldo=" + saldo + ", capital= "+obtenerCapital() + ", propiedades=" + propiedades + ", cartaLibertad=" + cartaLibertad + ", casillaActual=" + casillaActual + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}
