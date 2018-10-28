/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloQytetet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marquirj
 */
public class PruebaQytetet {
   // static Qytetet juego = new Qytetet();
    static  Qytetet juego = Qytetet.getInstance();
    
    public static ArrayList<Sorpresa> miFuncion(){
        ArrayList<Sorpresa> aux = new ArrayList<>();
        for(Sorpresa t: juego.getMazo()){
            if(t.getValor()>0){
                aux.add(t);
            }
            
        }
        return aux;
    }
    public static void getNombreJugadores(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("Tania");
        juego.inicializarJuego(nombres);
        System.out.println(juego.getJugadores().toString());
        
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Sorpresa>ayuda=new ArrayList<>();
        juego.inicializarTablero();
        juego.inicializarCartasSorpresa();
        
       //System.out.println(juego.getMazo().toString());
       //ayuda = miFuncion();
       //System.out.println(ayuda);
       System.out.println(juego.getTablero().toString());
       
        getNombreJugadores();
       
    }
    
}
