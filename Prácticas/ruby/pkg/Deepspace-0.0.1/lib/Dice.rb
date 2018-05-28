=begin
Esta clase tiene la responsabilidad de tomar todas las decisiones que dependen del azar en el juego.
Es como una especie de dado, pero algo más sofisticado, ya que no proporciona simplemente un
número del 1 al 6, sino decisiones concretas en base a una serie de probabilidades establecidas
=end

require_relative 'GameCharacter'

module Deepspace
  class Dice
    def initialize
      @NHANGARSPROB= 0.25
      @NSHIELDSPROB= 0.25
      @NWEAPONSPROB= 0.33
      @FIRSTSHOTPROB= 0.5
      @EXTRAEFFICIENCYPROB= 0.8
      @FORGETPROB= 0.5
      @generator= Random.new
    end
    
=begin
    Devuelve 0 con una probabilidad de NHANGARSPROB y 1 en caso
    contrario. Este método determina el número de hangares que recibirá una estación espacial al ser
    creada.
=end
    def initWithNHangars
      @generator.rand <= @NHANGARSPROB ? 0 : 1
    end

=begin
    Devuelve 0 con una probabilidad de NSHIELDSPROB y 1 en caso contrario.
    Este método determina el número de potenciadores de escudo que recibirá una estación espacial al
    ser creada.
=end 
    def initWithNShields
      @generator.rand <= @NSHIELDSPROB ? 0 : 1
    end
    
=begin
    Devuelve 1 con una probabilidad de NWEAPONSPROB, 2 con la misma
    probabilidad y 3 con una probabilidad de (1-2* NWEAPONSPROB). Este método determina el
    número de armas que recibirá una estación espacial al ser creada.
=end
    def initWithNWeapons
      rng= @generator.rand
      if rng <= @NWEAPONSPROB
        1
      elsif rng > @NWEAPONSPROB && rng <= 2*@NWEAPONSPROB
        2
      else
        3
      end
    end
    
=begin
    Genera un número aleatorio del intervalo [0,nPlayers-1].Determina el jugador (su índice) que
    iniciará la partida.
=end
    def whoStarts(num_players)
      @generator.rand(num_players)
    end
    
=begin
    Genera SPACESTATION con una probabilidad de FIRSTSHOTPROB y ENEMYSTARSHIP en otro caso. 
    Determina quién (de los dos tipos de personajes del juego) dispara primero 
    en un combate: la estación espacial o la nave enemiga.
=end
    def firstShot
      @generator.rand <= @FIRSTSHOTPROB ? GameCharacter::SPACESTATION : GameCharacter::ENEMYSTARSHIP
    end
    
=begin
    Devuelve true con una probabilidad de speed y false en otro caso 
    (se asume que speed será un número entre 0 y 1). Este método determina si la estación
    espacial se moverá para esquivar un disparo. La probabilidad de moverse será mayor cuanto más
    cerca está la velocidad potencial actual de la estación espacial de su velocidad máxima potencial.
=end
    def spaceStationMoves(speed)
      @generator.rand <= speed ? true : false
    end
    
    def extraEfficiency
      @generator.rand <= @EXTRAEFFICIENCYPROB ? false : true
    end
    
    #Examen P4
    def forget 
      @generator.rand <= @FORGETPROB ? true : false
    end
    
    def to_s
      "\nNHANGARSPROB= #{@NHANGARSPROB}, NSHIELDSPROB= #{@NSHIELDSPROB}, NWEAPONSPROB= #{@NWEAPONSPROB}, FIRSTSHOTPROB= #{@FIRSTSHOTPROB}, EXTRAEFFICIENCYPROB= #{@EXTRAEFFICIENCYPROB} "
    end
  end
end











