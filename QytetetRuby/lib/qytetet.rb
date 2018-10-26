#ENCODING: UTF-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"
module QytetetRuby
class Qytetet
  include Singleton
  attr_reader :mazo
  @@MAX_JUGADORES = 4
  @@NUM_SORPRESAS = 10
  @@NUM_CASILLAS = 20
  @@PRECIO_LIBERTAD = 200
  @@SALDO_SALIDA = 1000
  def initialize(mazo_,dado_,tablero_,jugadorActual_,numeroJugadores_,cartaActual_)
    @mazo=mazo_
    @dado=dado_
    @tablero=tablero_
    @jugadorActual=jugadorActual_
    @numeroJugadores=numeroJugadores_
    @cartaActual=cartaActual_
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
    raise NotImplementedError
  end
  def actuarSiEnCasillaNoEdificable
    raise NotImplementedError
  end
  def aplicarSorpresa
    raise NotImplementedError
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
    raise NotImplementedError
  end
  def inicializarJugadores(nombres_)
    raise NotImplementedError
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