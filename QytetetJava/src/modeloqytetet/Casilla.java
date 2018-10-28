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
public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo=null;
    Casilla(int numeroCasilla, int coste, TipoCasilla tipo){
        this.numeroCasilla=numeroCasilla;
        this.coste=coste;
        this.tipo=tipo;
        this.titulo=null;
        
    }
    Casilla(int numeroCasilla, TipoCasilla tipo, TituloPropiedad titulo){
        this.numeroCasilla=numeroCasilla;
        this.coste=titulo.getPrecioCompra();
        this.tipo=tipo.CALLE;
        setTitulo(titulo);
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
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
    private void setTitulo(TituloPropiedad titulo){
        this.titulo=titulo;
    }
    @Override
    public String toString(){
        String tit;
        if(this.titulo==null){
            tit="Carcel";
        }else
            tit=this.titulo.toString();
        return "Numero casilla: " + this.numeroCasilla + 
                "\nCoste: " + this.coste + "\nTipo Casilla: " + this.tipo + 
                "\nTitulo de la propiedad: " + tit + "\n\n";
    }
}
