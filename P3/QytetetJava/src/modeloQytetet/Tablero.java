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
public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList<>();
    private Casilla carcel;
    
    Tablero(){
        inicializar();
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public Casilla getCarcel() {
        return carcel;
    }
    @Override
    public String toString(){
        return "Casilla : " + casillas.toString() +" Carcel: "+ carcel.toString();
    }
    private void inicializar(){
        casillas  = new ArrayList<>();
        casillas.add(new Casilla(0,2500,TipoCasilla.SALIDA));
        casillas.add(new Casilla(1,TipoCasilla.CALLE, new TituloPropiedad("Calle Tunel",1000,100,(float)0.20,900,600)));
        casillas.add(new Casilla(2,TipoCasilla.CALLE, new TituloPropiedad("Calle Primer Centenario",975,95,(float)0.19,875,750)));
        casillas.add(new Casilla(3,TipoCasilla.CALLE, new TituloPropiedad("Calle San Francisco",950,85,(float)0.18,800,700)));
        casillas.add(new Casilla(4,TipoCasilla.CALLE, new TituloPropiedad("Calle La Era",800,80,(float)0.17,900,600)));
        casillas.add(new Casilla(5,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(6,TipoCasilla.CALLE, new TituloPropiedad("Calle Las Torres",750,75,(float)0.16,600,500)));
        casillas.add(new Casilla(7,TipoCasilla.CALLE, new TituloPropiedad("Calle Larga",700,50,(float)-0.15,900,250)));
        casillas.add(new Casilla(8,TipoCasilla.CALLE, new TituloPropiedad("Calle Molino",650,70,(float)0.14,900,300)));
        casillas.add(new Casilla(9,-100,TipoCasilla.CARCEL));
        casillas.add(new Casilla(10,TipoCasilla.CALLE, new TituloPropiedad("Calle Las Vegas",600,50,(float)-0.13,200,250)));
        casillas.add(new Casilla(11,TipoCasilla.CALLE, new TituloPropiedad("Calle Una Cera",550,60,(float)0.12,175,450)));
        casillas.add(new Casilla(12,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(13,TipoCasilla.CALLE, new TituloPropiedad("Calle Tesorillo",525,85,(float)0.11,800,600)));
        casillas.add(new Casilla(14,0,TipoCasilla.JUEZ));
        casillas.add(new Casilla(15,TipoCasilla.CALLE, new TituloPropiedad("Calle Los pitufos",500,50,(float)-0.10,175,250)));
        casillas.add(new Casilla(16,TipoCasilla.CALLE, new TituloPropiedad("Calle Cadiz",590,55,(float)0.13,175,500)));
        casillas.add(new Casilla(17,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(18,0,TipoCasilla.PARKING));
        casillas.add(new Casilla(19,-100,TipoCasilla.IMPUESTO));
        carcel = casillas.get(9);
    }
    Casilla obtenerCasillaFinal(Casilla casilla, int desplazamiento){
        int aux;
         aux = casilla.getNumeroCasilla() + desplazamiento;
         return casillas.get(aux);
    }
    Casilla obtenerCasillaNumero(int numeroCasilla){
        return casillas.get(numeroCasilla);
    }
   boolean esCasillaCarcel(int numeroCasilla){
        return (9==numeroCasilla);
   }
   
}
