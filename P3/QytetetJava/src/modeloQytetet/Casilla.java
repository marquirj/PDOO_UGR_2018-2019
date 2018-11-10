/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloQytetet;

/**
 *
 * @author marquirj
 */
public class Casilla {
    private int numCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    Casilla(int numcasilla, int coste, TipoCasilla tipo){
        this.numCasilla=numcasilla;
        this.coste=coste;
        this.tipo=tipo;
        this.titulo=null;
    }
    Casilla(int numCasilla,TipoCasilla tipo, TituloPropiedad titulo){
        this.numCasilla=numCasilla;
        this.coste=titulo.getPrecioCompra();
        this.tipo=tipo.CALLE;
        setTitulo(titulo);
    }

    public int getNumeroCasilla() {
        return numCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }
    private void setTitulo(TituloPropiedad tit){
        this.titulo=tit;
    }
    int pagarAlquiler(){
       int costeAlquiler=titulo.calcularImporteAlquiler();
       propietario.modificarSaldo(costeAlquiler);
    }
    boolean propietarioEncarcelado(){
        return this.titulo.propietarioEncarcelado();
    }
    boolean soyEdificable(){
        return this.tipo == tipo.CALLE;
    }
    boolean tengoPropietario(){
        return this.titulo.tengoPropietario();
    }
    TituloPropiedad asignarPropietario(Jugador jugador){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        String aux;
        if(this.tipo!=tipo.CALLE){
            aux="No es una calle";
        }
        else
            aux=this.titulo.toString();
        
        return "Casilla{" + "numCasilla=" + numCasilla + ", coste=" + coste + ", tipo=" + tipo + ", titulo=" + aux + "}\n";
    }
    
}
