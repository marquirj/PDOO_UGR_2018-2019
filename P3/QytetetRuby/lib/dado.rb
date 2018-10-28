# ENCODING: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
module QytetetRuby
class Dado
  include Singleton
  attr_reader :valor
  def initialize(valor_)
    @valor = valor_
  end
  def tirar
    @valor=rand(1..6)
    return @valor
  end
  def to_s
    "Dado #{@dado}\n"
  end
end
end