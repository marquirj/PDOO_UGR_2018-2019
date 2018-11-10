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
    private EstadoJuego estadoJuego;
    //private MetodoSalirCarcel metodoSalirCarcel;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Qytetet(){}

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public EstadoJuego getEstadoJuego() {
        return estadoJuego;
    }
    
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
    public void actuarSiEnCasillaEdificable(){
        boolean deboPagar=jugadorActual.deboPagarAlquiler();
        if(deboPagar){
            jugadorActual.pagarAlquiler();
        }
        Casilla casilla=obtenerCasillaJugadorActual();
        boolean tengoPropietario=casilla.tengoPropietario();
        if(tengoPropietario){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }else{
        }
    }
    public void actuarSiEnCasillaNoEdificable(){
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        Casilla casillaActual=jugadorActual.getCasillaActual();
        if(casillaActual.getTipo()==TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }else{
            if(casillaActual.getTipo()==TipoCasilla.JUEZ){
              encarcelarJugador();  
            }else if(casillaActual.getTipo()==TipoCasilla.SORPRESA){
                //cartaActual=remove(0);
                setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
            }
        }
        
        
}
    public void aplicarSorpresa(){
        setEstadoJuego(EstadoJuego.PUEDOGESTIONAR);
        if(cartaActual.getTipo()==TipoSorpresa.SALIRCARCEL){
            jugadorActual.setCartaLibertad(cartaActual);
        }else{
            mazo.add(cartaActual);
            if(cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
                jugadorActual.modificarSaldo(cartaActual.getValor());
                if(jugadorActual.getSaldo()<0){
                     setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
            }else if(cartaActual.getTipo() ==TipoSorpresa.IRACASILLA){
                int valor=cartaActual.getValor();
                boolean casillaCarcel=tablero.esCasillaCarcel(valor);
                if(casillaCarcel==true){
                    encarcelarJugador();
                    
                }else{
                    mover(valor);
                }
            }else if(cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
                int cantidad = cartaActual.getValor();
                int numeroTotal = jugadorActual.cuantasCasasHotelesTengo();
                jugadorActual.modificarSaldo((cantidad*numeroTotal));
                if(jugadorActual.getSaldo()<0){
                     setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
                
            }else if(cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
                for(Jugador jugador : jugadores){
                    if(jugador!=jugadorActual){
                        jugador.modificarSaldo(cartaActual.getValor());
                    }else if(jugador.getSaldo()<0){
                         setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    }else if(jugadorActual.getSaldo()<0){
                         setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    }
                
                }
            }
            
        }
        
        
        
    }
    public boolean cancelarHipoteca(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public boolean comprarTituloPropiedad(){
         boolean comprado= jugadorActual.comprarTituloPropiedad();
         if (comprado==true){
              setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
         }
         return comprado;
    }
    public boolean edificarCasa(int numCasilla){
         Casilla casilla = tablero.obtenerCasillaNumero(numCasilla);
         boolean edificada=false;
         TituloPropiedad titulo = casilla.getTitulo();
         edificada =jugadorActual.edificarCasa(titulo);
         if(edificada){
              setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
         }
         return edificada;
    }
    public boolean edificarHotel(int numCasilla){
         throw new UnsupportedOperationException("Sin implementar");
    }
    public void encarcelarJugador(){
        if(!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            jugadorActual.irACarcel(casillaCarcel);
             setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
             setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
    }
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
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int resultado = tirarDado();
            if(resultado>=5){
                jugadorActual.setEncarcelado(false); 
            }
        }else if(metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
            
        }
        boolean encarcelado=jugadorActual.getEncarcelado();
        if(encarcelado){
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }else{
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        }
        return encarcelado;
    }
    public void jugar(){}
    public void mover(int numCasillaDestino){
        Casilla casillaInicial =jugadorActual.getCasillaActual();
        Casilla casillaFinal= tablero.obtenerCasillaNumero(numCasillaDestino);
        jugadorActual.setCasillaActual(casillaFinal);
        if(numCasillaDestino<casillaInicial.getNumeroCasilla()){
            jugadorActual.modificarSaldo(SALDO_SALIDA);
        }
        if(casillaFinal.soyEdificable()){
            actuarSiEnCasillaEdificable();
        }else{
            actuarSiEnCasillaNoEdificable();
        }
    }
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
