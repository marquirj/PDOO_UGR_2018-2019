#ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module QytetetRuby
class Tablero
  attr_reader :carcel, :casillas
  def initialize
    @casillas
    @carcel
    inicializar
  end
  def esCasillaCarcel(numeroCasilla)
    return (numeroCasilla=9)
  end
  def obtenerCasillaFinal(casilla_, desplazamiento_)
    aux = casilla_.numeroCasilla + desplazamiento_
    return casillas.get(aux)
  end
  def obtenerCasillaNumero(numeroCasilla)
    casillas.get(numeroCasilla)
  end
  private
  def inicializar
    @casillas= Array.new
    @casillas<< (Casilla.noTipoCalle(0,2500,TipoCasilla::SALIDA))
    @casillas<< Casilla.tipoCalle(1,TipoCasilla::CALLE, TituloPropiedad.new("Calle Tunel",1000,100,0.20,900,600))
    @casillas<<Casilla.tipoCalle(2,TipoCasilla::CALLE, TituloPropiedad.new("Calle Primer Centenario",975,95,0.19,875,750))
    @casillas<<Casilla.tipoCalle(3,TipoCasilla::CALLE,  TituloPropiedad.new("Calle San Francisco",950,85,0.18,800,700))
    @casillas<<Casilla.tipoCalle(4,TipoCasilla::CALLE, TituloPropiedad.new("Calle La Era",800,80,0.17,900,600))
    @casillas<<Casilla.noTipoCalle(5,0,TipoCasilla::SORPRESA)
    @casillas<<Casilla.tipoCalle(6,TipoCasilla::CALLE, TituloPropiedad.new("Calle Las Torres",750,75,0.16,600,500))
    @casillas<<Casilla.tipoCalle(7,TipoCasilla::CALLE, TituloPropiedad.new("Calle Larga",700,50,-0.15,900,250))
    @casillas<<Casilla.tipoCalle(8,TipoCasilla::CALLE, TituloPropiedad.new("Calle Molino",650,70,0.14,900,300))
    @carcel=Casilla.noTipoCalle(9,0,TipoCasilla::CARCEL)
    @casillas<<@carcel
    @casillas<<Casilla.tipoCalle(10,TipoCasilla::CALLE, TituloPropiedad.new("Calle Las Vegas",600,50,-0.13,200,250))
    @casillas<<Casilla.tipoCalle(11,TipoCasilla::CALLE, TituloPropiedad.new("Calle Una Cera",550,60,0.12,175,450))
    @casillas<< Casilla.noTipoCalle(12,0,TipoCasilla::SORPRESA)
    @casillas<<Casilla.tipoCalle(13,TipoCasilla::CALLE, TituloPropiedad.new("Calle Tesorillo",525,85,0.11,800,600))
    @casillas<<Casilla.noTipoCalle(14,0,TipoCasilla::JUEZ)
    @casillas<<Casilla.noTipoCalle(15,TipoCasilla::CALLE, TituloPropiedad.new("Calle Los pitufos",500,50,-0.10,175,250))
    @casillas<<Casilla.tipoCalle(16,TipoCasilla::CALLE, TituloPropiedad.new("Calle Cadiz",590,55,0.13,175,500))
    @casillas<<Casilla.noTipoCalle(17,0,TipoCasilla::SORPRESA)
    @casillas<<Casilla.noTipoCalle(18,0,TipoCasilla::PARKING)
    @casillas<<Casilla.noTipoCalle(19,-100,TipoCasilla::IMPUESTO)
        
  end
  public 
  def to_s
    "Tablero : #{@casillas.join}\n
    Carcel: #{@carcel}"
  end
  
end
end