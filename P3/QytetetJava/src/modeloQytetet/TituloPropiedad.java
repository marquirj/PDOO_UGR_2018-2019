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
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecado=false;
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private int numCasas=0;
    private int numHoteles=0;
    private Jugador propietario;
    TituloPropiedad(String nombre, int preciocompra, int alquilerbase, float factorrevalorizacion, int hipotecabase, int precioedificar){
        this.nombre=nombre;
        this.hipotecado=false;
        this.precioCompra=preciocompra;
        this.alquilerBase=alquilerbase;
        this.factorRevalorizacion=factorrevalorizacion;
        this.hipotecaBase=hipotecabase;
        this.precioEdificar=precioedificar;
        this.numCasas=0;
        this.numHoteles=0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecado() {
        return hipotecado;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getAlquilerBase() {
        return alquilerBase;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public void setHipotecado(boolean hipotecado) {
        this.hipotecado = hipotecado;
    }
    int calcularCosteCancelar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int calcularCostHipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    int calcularImporteAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
        
    }
    int calcularPrecioVenta(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void cancelarHipoteca(){}
    void cobrarAlquiler(int coste){}
    void edificarCasa(){}
    void edificarHotel(){}

    public Jugador getPropietario() {
        return propietario;
    }
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    void setHipotecada(boolean hipotecada){}

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }
        
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecado=" + hipotecado + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", numCasas=" + numCasas + ", numHoteles=" + numHoteles + '}';
    }
    
}
