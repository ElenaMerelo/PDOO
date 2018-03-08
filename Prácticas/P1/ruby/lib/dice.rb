=begin
Esta clase tiene la responsabilidad de tomar todas las decisiones que dependen del azar en el juego.
Es como una especie de dado, pero algo más sofisticado, ya que no proporciona simplemente un
número del 1 al 6, sino decisiones concretas en base a una serie de probabilidades establecidas
=end

module Deepspace
  class Dice
    def initialize
      @NHANGARSPROB= 0.25
      @NSHIELDSPROB= 0.25
      @NWEAPONSPROB= 0.33
      @FIRSTSHOTPROB= 0.5
      @generator= Random.new
    end
    
=begin
    Devuelve 0 con una probabilidad de NHANGARSPROB y 1 en caso
    contrario. Este método determina el número de hangares que recibirá una estación espacial al ser
    creada.
=end
    def initWithNHangars
      @generator.rand < @NHANGARSPROB ? 0 : 1
    end
    
=begin
Devuelve 1 con una probabilidad de NWEAPONSPROB, 2 con la misma
probabilidad y 3 con una probabilidad de (1-2* NWEAPONSPROB). Este método determina el
número de armas que recibirá una estación espacial al ser creada.
=end
    def initWithNWeapons
      rng= @generator.rand
      prob= 1 - 2*@NWEAPONSPROB
      if rng <= @NWEAPONSPROB
        1
      elsif rng > @NWEAPONSPROB && rng < prob
        2
      else
        3
      end
    end
  end
end











