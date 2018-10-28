#ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module QytetetRuby
class TituloPropiedad
  attr_accessor :hipotecada, :propietario
  attr_reader :nombre, :precioCompra, :alquilerBase, :factorRevalorizacion, :hipotecaBase, :precioEdificar, :numCasas, :numHoteles
  def initialize(nombre_,precioCompra_,alquilerBase_,factorRevalorizacion_,hipotecaBase_,precioEdificar_)
   @nombre=nombre_
   @hipotecada=false
   @precioCompra=precioCompra_
   @alquilerBase=alquilerBase_
   @factorRevalorizacion=factorRevalorizacion_
   @hipotecaBase=hipotecaBase_
   @precioEdificar=precioEdificar_
   @numCasas=5
   @numHoteles=6
   @propietario=nil
  end
  def calcularCosteCancelar
    raise NotImplementedError
  end
  def calcularCosteHipotecar
    raise NotImplementedError
  end
  def calcularCosteAlquiler
    raise NotImplementedError
  end
  def calcularPrecioVenta
    raise NotImplementedError
  end
  def cancelarHipoteca
    raise NotImplementedError
  end
  def cobrarAlquiler(alquiler_)
    raise NotImplementedError
  end
  def edificaCasa
    raise NotImplementedError
  end
  def edificaHotel
    raise NotImplementedError
  end
  def hipotecar
    raise NotImplementedError
  end
  def pagarAlquiler
    raise NotImplementedError
  end
  def propietarioEncarcelado
    return @propietario.encarcelado
  end
  def tengoPropietario
    return @propietario!=nil
  end

  def to_s
    "Nombre : #{@nombre}\n
     Hipotecada?: #{@hipotecada} \n
     Precio compra: #{@precioCompra}\n
     Alquiler Base: #{@alquilerBase}\n
     Factor Revalorizacion: #{@factorRevalorizacion} \n
     Hipoteca Base: #{@hipotecaBase}\n
     Precio Edificar : #{@precioEdificar}\n
     Num Casas: #{@numCasas} \n
     Num Hoteles: #{@numHoteles}\n
     Propietario: #{@propietario}"
  end
end
end