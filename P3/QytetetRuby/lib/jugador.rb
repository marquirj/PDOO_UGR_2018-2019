# ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module QytetetRuby
class Jugador
  attr_reader :cartaLibertad, :encarcelado, :nombre, :saldo, :propiedades, :casillaActual
  attr_writer :cartaLibertad, :casillaActual, :encarcelado
  def initialize(nombre_)
    @encarcelado=false
    @nombre=nombre_
    @saldo=7500
    @propiedades=Array.new
    @casillaActual=nil
    @cartaLibertad=nil
  end
  def <=>
    otroJugador.obtenerCapital <=> obtenerCapital
  end
  def cancelarHipoteca(titulo_)
    raise NotImplementedError
  end
  def comprarTituloPropiedad
    raise NotImplementedError
  end
  def cuantasCasasHotelesTengo
    casas = hoteles = 0
    @propiedades.each do  |propiedad|
      casas = casas + propiedad.numCasas
      hoteles = hoteles + propiedad.numHoteles
    end  
    return casas + hoteles
  end
  def deboPagarAlquiler
    raise NotImplementedError
  end
  def devolverCartaLibertad
    carta = @cartaLibertad
    @cartaLibertad=nil
    return carta
  end
  def edificarCasa(titulo_)
    raise NotImplementedError
  end
  def edificarHotel(titulo_)
    raise NotImplementedError
  end
  def eliminarDeMisPropiedades(titulo_)
    raise NotImplementedError
  end
  def esDeMiPropiedad(titulo_)
    @propiedades.each do |propiedad|
      if(propiedad.nombre == titulo_.nombre)
        return true
      end
    end
    return false
  end
  def estoyEnCalleLibre()
    raise NotImplementedError
  end
  def hipotecarPropiedad(titulo_)
    raise NotImplementedError
  end
  def irACarcel(casilla_)
    raise NotImplementedError
  end
  def modificarSaldo(cantidad_)
    @saldo = @saldo + cantidad_
    return @saldo
  end 
  def obtenerCapital
    valorPropiedades=0
    @propiedades.each do |propiedad|
      if(!propiedad.hipotecada)
        valorPropiedades= valorPropiedades+propiedad.precioCompra + (propiedad.numCasas+propiedad.numHoteles)*propiedad.precioEdificar
      else
        valorPropiedades= valorPropiedades+ propiedad.precioCompra + (propiedad.numCasas+propiedad.numHoteles)*propiedad.precioEdificar - propiedad.hipotecaBase
      end
    end
    return @saldo + valorPropiedades
  end
  def obtenerPropiedades(hipotecada_)
    aux=Array.new
    @propiedades.each do |propiedad|
      if(propiedad.hipotecada==hipotecada_)
        aux<<propiedad
      end
    end
    return aux
  end
  def pagarAlquiler
    raise NotImplementedError
  end
  def pagarImpuesto
    @saldo = @saldo - @casillaActual.coste
  end
  def pagarLibertad(cantidad_)
    raise NotImplementedError
  end
  def tengoCartaLibertad
    if @cartaLibertad !=nil
      return true
    else
      return false
    end
  end
  def tengoSaldo(cantidad_)
    return @saldo > cantidad_
  end
  def venderPropiedad(casilla_)
    raise NotImplementedError
  end
  def to_s
    " Encarcelado: #{@encarcelado}\n
    Nombre: #{@nombre}\n
    Saldo: #{@saldo}\n
    Capital: #{obtenerCapital}\n
    Propiedades#{@propiedades.join}\n
    Casilla Actual: #{@casillaActual}\n
    Carta Libertad: #{@cartaLibertad}"
  end
  
  
  
  
  
  
  
  
  
end
end