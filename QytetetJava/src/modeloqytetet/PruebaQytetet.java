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
public class PruebaQytetet {
    static Qytetet juego = new Qytetet();
    
    
     private static ArrayList<Sorpresa> valorMayor0(){
        ArrayList<Sorpresa> aux=new ArrayList<>();
       // juego.inicializarCartasSorpresa();
        for(Sorpresa s:juego.mazo){
            if(s.getValor()>0){
                //System.out.println(s.getValor());
                aux.add(s);
            }
        }
          
        return aux;
    }
     private static ArrayList<Sorpresa> tipoCasilla(){
         ArrayList<Sorpresa> aux= new ArrayList<>();
         for(Sorpresa s:juego.mazo){
             if(s.getTipo()==TipoSorpresa.IRACASILLA){
                 aux.add(s);
             }
         }
         return aux;
     }
     private static ArrayList<Sorpresa> tipoCasilla(TipoSorpresa x){
        ArrayList<Sorpresa> aux= new ArrayList<>();
        for(Sorpresa s:juego.mazo){
            if(s.getTipo()==x){
                aux.add(s);
            }
        }
        return aux;
     }
    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        juego.inicializarTablero();//Esto debe hacerse antes para que no de el puntero nulo ya que el valor no esta declarado aún.
        juego.inicializarCartasSorpresa();
        
        //System.out.println(juego.mazo.get(1));
        ArrayList<Sorpresa>ejemplo=new ArrayList();
        ejemplo=valorMayor0();
        //System.out.println(ejemplo);
        ejemplo=tipoCasilla();
        //System.out.println(ejemplo);
        for(TipoSorpresa t: TipoSorpresa.values()){
            ejemplo=tipoCasilla(t);
            System.out.println(ejemplo);
            ejemplo.clear();
        }
        
        
        for(Casilla t: juego.getTablero().getCasillas()){
            System.out.println(t.toString());
        }
    }
    

    
}
