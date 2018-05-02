#!/usr/bin/env ruby
#encoding: utf-8

class Test
  private
  def privado
    puts "privado"
  end

  protected
  def protegido
    puts "Protegido"
  end

  public
  def publico
    puts "Publico"
  end

  def otropublico(otro)
    #otro.privado
    otro.protegido
    otro.publico
  end
end

class Hija < Test
  def metodo
    puts "Metodo"
    privado
    protegido
    publico
  end

  def metodo2(otro)
    #otro.privado
    otro.protegido
    otro.publico
  end
end

t=Test.new
#t.privado
#t.protegido
t.publico

t.otropublico(Test.new)

h=Hija.new
#h.privado
#h.protegido
h.publico
h.metodo
h.metodo2(Test.new)
