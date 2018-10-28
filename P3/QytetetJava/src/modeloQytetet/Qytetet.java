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
public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    private Tablero tablero;
    private Jugador jugadorActual;
    public int MAX_JUGADORES = 4;
    public int NUM_CASILLAS = 20;
    public int PRECIO_LIBERTAD = 200;
    public int SALDO_SALIDA = 1000;
    private Sorpresa cartaActual;
    private Dado dado;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Qytetet(){}
    
    public Tablero getTablero(){
        return this.tablero;
    }
     public ArrayList<Sorpresa> getMazo() {
         
        return mazo;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public Sorpresa getCartaActual() {
        return cartaActual;
    }

    public Dado getDado() {
        return dado;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
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
    protected void inicializarTablero(){
        tablero = new Tablero();
    }
    public static Qytetet getInstance() {
        return instance;
    }
    public void actuarSiEnCasillaEdificable(){}
    public void actuarSiEnCasillaNoEdificable(){}
    public void aplicarSorpresa(){}
    public boolean cancelarHipoteca(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public boolean comprarTituloPropiedad(){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public boolean edificarCasa(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public boolean edificarHotel(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public void encarcelarJugador(){}
    public int getValorDado(){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public void hipotecarPropiedad(int numCasilla){}
    public void inicializarJuego(ArrayList<String> nombres){
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
    }
    public void inicializarJugadores(ArrayList<String>nombres){
        for(String nombre: nombres){
            this.jugadores.add( new Jugador(nombre));
        }
    }
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public void jugar(){}
    public void mover(int numCasillaDestino){}
    public Casilla obtenerCasillaJugadorActual(){
             throw new UnsupportedOperationException("Sin implementar");
    }
    public ArrayList<Casilla> obtenerCasillaTablero(){
         throw new UnsupportedOperationException("Sin implementar");
    }
    /*public ArrayList<int> obtenerPropiedadesJugador(){
         throw new UnsupportedOperationException("Sin implementar");
    }
    */
    public void obtenerRanking(){}
    public int obtenerSaldoJugadorActual(){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public void salidaJugadores(){}
    public void siguienteJugador(){}
    public int tirarDado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    public boolean venderPropiedad(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
