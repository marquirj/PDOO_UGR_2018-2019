/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author marquirj
 */
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada=false;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private int numHoteles=0;
    private int numCasas=0;
    TituloPropiedad(String nombre, int precioCompra,int alquilerBase,float factorRevalorizacion,int hipotecaBase,int precioEdificar){
        this.nombre=nombre;
        this.precioCompra=precioCompra;
        this.alquilerBase=alquilerBase;
        this.factorRevalorizacion=factorRevalorizacion;
        this.hipotecaBase=hipotecaBase;
        this.precioEdificar=precioEdificar;
    }
    protected String getNombre(){
        return this.nombre;
    }
    protected boolean estaHipotecada(){
        return this.hipotecada;
    }
    protected int getPrecioCompra(){
        return this.precioCompra;
    }
    protected int getAlquilerBase(){
        return this.alquilerBase;
    }
    protected float getFactorRevalorizacion(){
        return this.factorRevalorizacion;
    }
    protected int getHipotecaBase(){
        return this.hipotecaBase;
    }
    protected int getPrecioEdificar(){
        return this.precioEdificar;
    }
    protected int getNumHoteles(){
        return this.numHoteles;
    }
    protected int getNumCasas(){
        return this.numCasas;
    }
    protected void setHipotecada(boolean tipo){
        this.hipotecada=tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setAlquilerBase(int alquilerBase) {
        this.alquilerBase = alquilerBase;
    }

    public void setFactorRevalorizacion(float factorRevalorizacion) {
        this.factorRevalorizacion = factorRevalorizacion;
    }

    public void setHipotecaBase(int hipotecaBase) {
        this.hipotecaBase = hipotecaBase;
    }

    public void setPrecioEdificar(int precioEdificar) {
        this.precioEdificar = precioEdificar;
    }

    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }
    
    @Override
    public String toString(){
        return "\nNombre: "+  this.nombre + ". \nHipotecada?= " + this.hipotecada +
                " \nEl precio de compra es: " + this.precioCompra + " \nEl alquiler base es: " + this.alquilerBase + 
                " \nEl factor de revalorización es: " + this.factorRevalorizacion + " \nLa hipoteca base es: " + this.hipotecaBase +
                " \nEl precio para edificar es: " + this.precioEdificar + 
                "\nEl numero de casas es " + this.numCasas + " y de hoteles es " + this.numHoteles + "\n\n";
    }
    
    
    
    
    
    
    
    
}
