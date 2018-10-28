#ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'sorpresa'
require_relative 'tipo_sorpresa'
require_relative 'qytetet'
require_relative 'titulo_propiedad'
require_relative 'casilla'
require_relative 'tipo_casilla'
require_relative 'tablero'
require_relative 'jugador'
module QytetetRuby
  class PruebaQytetet
    @@juego = Qytetet.instance
    @@titulo = TituloPropiedad.new("Juan",10,25,15,12,15)
    @@casilla = Casilla.noTipoCalle(9,250 ,TipoCasilla::CARCEL)
    @@casilla1 = Casilla.tipoCalle(6, TipoCasilla::CALLE, TituloPropiedad.new("nombre_",25,125,225,335,445))
    @@tablero = Tablero.new
    
    
    
    
    def PruebaQytetet.mayorquecero
      ex = Array.new
       @@juego.mazo.each do |i| 
       if i.valor > 0
         puts i.to_s
         ex << i
        end 
      end
      return ex
    end
    def PruebaQytetet.main
        @nombresjug= Array.new
        @nombresjug <<  "juan"
        @nombresjug <<  "tania"
        @@juego.inicializarJuego(@nombresjug)
    

        @@juego.inicializarCartasSorpresa
    
        @@juego.jugadores.each do |j|
          j.propiedades << @@titulo
          puts j.nombre
          puts j.cuantasCasasHotelesTengo
        end
    
       puts @@tablero.esCasillaCarcel(9)
       puts @@tablero.obtenerCasillaNumero(3)
       puts @@tablero.obtenerCasillaFinal(@@casilla,12)
      #puts @@tablero
      #puts mayorquecero()
#     puts @@titulo.to_s
#     puts @@casilla.to_s
#     puts @@casilla1.to_s
    end
    PruebaQytetet.main
  end
end
