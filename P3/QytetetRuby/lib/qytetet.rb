#ENCODING: UTF-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"
require_relative 'jugador.rb'
module QytetetRuby
class Qytetet
  include Singleton
  attr_accessor :estadoJuego, :cartaActual
  attr_reader :mazo, :jugadores
  @@MAX_JUGADORES = 4
  @@NUM_SORPRESAS = 10
  @@NUM_CASILLAS = 20
  @@PRECIO_LIBERTAD = 200
  @@SALDO_SALIDA = 1000
  def initialize
    @mazo
    @dado
    @tablero
    @jugadorActual
    @jugadores= Array.new
    @cartaActual
    @estadoJuego
  end
  def inicializarCartasSorpresa
    @mazo = Array.new
    @mazo<< Sorpresa.nuevo("Impuesto por no asistir a clase. Debe pagar una multa!",-200,TipoSorpresa::PAGARCOBRAR)
    @mazo<< Sorpresa.nuevo("Debes retrocer 5 casillas, no se puede avanzar tanto!",-5,TipoSorpresa::IRACASILLA)
    @mazo<< Sorpresa.nuevo("Por cada posesion Casa/Hotel, cobrarás 25.",25,TipoSorpresa::PORCASAHOTEL)
    @mazo<< Sorpresa.nuevo("Cada jugador te pagará 17.",17,TipoSorpresa::PORJUGADOR)
    @mazo<< Sorpresa.nuevo("Eres un suertudo. Sales de la cárcel por la cara.",0,TipoSorpresa::SALIRCARCEL)
    @mazo<< Sorpresa.nuevo("Avanza 7 casillas por tu look tan moderno.",7,TipoSorpresa::IRACASILLA)
    @mazo<< Sorpresa.nuevo("Te han pillado con las manos en la masa, debes ir a la carcel",9,TipoSorpresa::SALIRCARCEL)
    @mazo<< Sorpresa.nuevo("Cobras 185 por ese portatil tan chulo que tienes",185,TipoSorpresa::PAGARCOBRAR)
    @mazo<< Sorpresa.nuevo("Si tienes alguna casa cobraras 29",29,TipoSorpresa::PORCASAHOTEL)
    @mazo<< Sorpresa.nuevo("Pagarás 10 a cada jugardor rival",-10,TipoSorpresa::PORJUGADOR)
  end
  def actuarSiEnCasillaEdificable
    deboPagar = @jugadorActual.deboPagarAlquiler()
    if(deboPagar)
      @jugadorActual.pagarAlquiler()
      if(@jugadorActual.saldo<=0)
        @estadoJuego=EstadoJuego::ALGUNJUGADORENBANCARROTA
      end
    end
    casilla =obtenerCasillaJugadorActual()
    tengoPropietario=casilla.tengoPropietario()
    if(@estadoJuego!= EstadoJuego::ALGUNJUGADORENBANCARROTA)
      if(tengoPropietario)
        @estadoJuego=EstadoJuego::JA_PUEDEGESTIONAR
      else
        @estadoJuego=EstadoJuego::JA_PUEDECOMPRAROGESTIONAR
      end
    end
  end
  def actuarSiEnCasillaNoEdificable
    @estadoJuego=EstadoJuego::JA_PUEDEGESTIONAR
    casillaActual = @jugadorActual.casillaActual
    if(casillaActual.tipo==TipoCasilla::IMPUESTO)
      @jugadorActual.pagarImpuesto()
    else
      if(casillaActual.tipo==TipoCasilla::JUEZ)
        encarcelarJugador()
      else
        if(casillaActual.tipo==TipoCasilla::SORPRESA)
          #cartaActual=remove(0)
          @estadoJuego=EstadoJuego::JA_CONSORPRESA
        end
      end
    end
  end
  def aplicarSorpresa
    
  end
  def cancelarHipoteca(num_casilla_)
    raise NotImplementedError
  end
  def comprarTituloPropiedad
    raise NotImplementedError
  end
  def edificarCasa(num_casilla_)
    raise NotImplementedError
  end
  def edificarHotel(num_casilla_)
    raise NotImplementedError
  end
  def encarcelarJugador
    raise NotImplementedError
  end
  def getValorDado
    raise NotImplementedError
  end
  def hipotecarPropiedad(num_casilla_)
    raise NotImplementedError
  end
  def inicializarJuego(nombres_)
    inicializarTablero
    inicializarCartasSorpresa
    inicializarJugadores(nombres_)
  end
  def inicializarJugadores(nombres_)
    if (nombres_.length < 2 || nombres_.length > @@MAX_JUGADORES)
        raise ArgumentError, "Número incorrecto de jugadores."
      end
      
      @jugadores = Array.new
      
      for jugador in nombres_
        @jugadores << Jugador.new(jugador)
      end
  end
  def inicializarTablero
    @tablero=Tablero.new
  end
  def intentarSalirCarcel(metodo_)
    raise NotImplementedError
  end
  def jugar
    raise NotImplementedError
  end
  def mover(casillaDestino_)
    raise NotImplementedError
  end
  def obtenerCasillaJugadorActual
    raise NotImplementedError
  end
  def obtenerCasillasTablero
    raise NotImplementedError
  end
  def obtenerPropiedadesJugadores
    raise NotImplementedError
  end
  def obtenerPropiedadesJugadorSegunEstadoHipoteca(estadoHipoteca)
    raise NotImplementedError
  end
  def obtenerRanking
    raise NotImplementedError
  end
  def obtenerSaldoJugadorActual
    raise NotImplementedError
  end
  def salidaJugador
    raise NotImplementedError
  end
  def siguienteJugador
    raise NotImplementedError
  end
  def tirarDado
    raise NotImplementedError
  end
  def venderPropiedad(casilla)
    raise NotImplementedError
  end
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
end
end