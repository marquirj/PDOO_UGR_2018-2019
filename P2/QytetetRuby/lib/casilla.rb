#ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module QytetetRuby
class Casilla
  private_class_method :new
  attr_reader :numeroCasilla, :coste, :titulo, :tipo
  attr_writer :titulo
  private :titulo, :titulo=
  def initialize(numeroCasilla_,coste_,tipo_,titulo_)
    @numeroCasilla = numeroCasilla_
    @coste = coste_
    @tipo = tipo_
    @titulo = titulo_
  end
  def self.noTipoCalle(numeroCasilla_,coste_,tipo_)
    new(numeroCasilla_,coste_,tipo_,nil)
  end
  def self.tipoCalle(numeroCasilla_,tipo_,titulo_)
    new(numeroCasilla_,titulo_.precioCompra,tipo_,titulo_)
  end
  
  def asignarPropietario(jugador)
    raise NotImplementedError
  end
  def pagarAlquiler
    raise NotImplementedError
  end
  def propietarioEncarcelado
    raise NotImplementedError
  end
  def soyEdificable
    raise NotImplementedError
  end
  def tengoPropietario
    raise NotImplementedError
  end
  
  
  
  
  def to_s
    "Numero Casilla : #{@numeroCasilla}\n
     Coste: #{@coste} \n
     Tipo: #{@tipo}\n
     Titulo Propiedad: #{@titulo.to_s}\n
     "
  end
end
end