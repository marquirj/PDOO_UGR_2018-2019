#ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module QytetetRuby
class Sorpresa
  private_class_method :new
  attr_reader :texto, :valor, :tipo
  def initialize(texto_,valor_,tipo_)
    @texto=texto_
    @tipo=tipo_
    @valor=valor_
   # nuevo(texto_,valor_,tipo_)
  end
  def self.nuevo(texto_,valor_,tipo_)
    new(texto_,valor_,tipo_)
  end
  
  def to_s
    "Texto : #{@texto}\n
     Tipo: #{@tipo} \n
     Valor: #{@valor}\n"
  end
end
end