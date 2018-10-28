/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author marquirj
 */
public class Qytetet {

     ArrayList<Sorpresa> mazo= new ArrayList<>();
     private Tablero tablero;
     public ArrayList<Sorpresa> getMazo() {
         
        return mazo;
    }
    protected void inicializarCartasSorpresa(){
        mazo.add(new Sorpresa("Impuesto por no asistir a clase. Debe pagar una multa!",-200,TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Debes retrocer 5 casillas, no se puede avanzar tanto!",-5,TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Por cada posesion Casa/Hotel, cobrarás 25.",25,TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Cada jugador te pagará 17.",17,TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Eres un suertudo. Sales de la cárcel por la cara.",0,TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Avanza 7 casillas por tu look tan moderno.",7,TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Te han pillado con las manos en la masa, debes ir a la carcel",tablero.getCarcel().getNumeroCasilla(),TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Cobras 185 por ese portatil tan chulo que tienes",185,TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Si tienes alguna casa cobraras 29",29,TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Pagarás 10 a cada jugardor rival",-10,TipoSorpresa.PORJUGADOR));
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    protected void inicializarTablero(){
        this.tablero = new Tablero();
    }
}
