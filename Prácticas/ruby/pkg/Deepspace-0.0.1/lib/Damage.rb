=begin
Los objetos de esta clase representan el daño producido a una estación espacial por una nave
enemiga cuando se pierde un combate. Cada instancia indicará la perdida de una cantidad de
potenciadores de escudo y por otro lado, o bien una cantidad de tipos indeterminados de armas o un
conjunto de tipos de armas concretas que se deben eliminar.
Todas las instancias deben ser unas independientes de otras y por lo tanto no deben compartir
instancias de objetos mutables (modificables)
By: Elena Merelo
=end

require_relative "DamageToUI"

module Deepspace
  class Damage
    attr_reader :nWeapons, :nShields,  :weapons
    
    def initialize(nw, ns, w)
      @nShields= ns
      @nWeapons= nw
      @weapons= Array.new(w)
    end
    
    def self.newNumericWeapons(w, s)
      new(w, s, nil)
    end
    
    def self.newSpecificWeapons(w1, s)
      new(w1.length, s, w1)
    end
    
    def self.newCopy(d)
      new(d.nWeapons, d.nShields, d.weapons)
    end
    
    def getUIversion
      DamageToUI.new(self)
    end
    
    def discardWeapon(w)
      if @weapons.length > 0
        @weapons.delete(w)
      else
        if @nWeapons > 0
          @nWeapons -= -1
        end
      end
    end
    
    def discardShieldBooster
      if @nShields > 0
        @nShields -= 1
      end
    end
    
    def hasNoEffect
      @nWeapons == 0 && @nShields == 0
    end
    
    private
    def adjust(w, s)
      if (@nShields > s.length)
        @nShields= s.length
      end
      
      adjusted = Damage.newCopy(self)
      copy = w.clone()
      
      for i in @weapons
        index= arrayContainsType(copy, i)
        if index == -1
          adjusted.weapons.delete(i)
        else
          copy.delete_at(index)
        end
      end
      
      adjusted
    end
    
    def arrayContainsType(w, t)
      for i in w
        if i.type == t
          return w.index(i)
        end
      end
      return -1
    end
    
  end #class
end #module


=begin

def adjust(w,s)
    # Primero miramos si es numérico o armas concretas el arma
    if @nWeapons == -1 # Entonces es específico
      weaponTypes = []
      w.each{|elem|
        weaponTypes.push(elem.type)
      }   
      # Calculamos la intersección entre weaponTypes & @weapons
      aux = weaponTypes & @weapons
      for i in 0...aux.length
        k = [weaponTypes.count(aux[i]), @weapons.count(aux[i])].min
        for j in 2..k
          aux.push(aux[i])
        end
      end
      Damage.newSpecificWeapons(aux, [@nShields,s.length].min)      
    else # Entonces es numérico
      Damage.newNumericWeapons([@nWeapons,w.length].min, [@nShields,s.length].min)      
    end    
end

def adjust(w,s)
      aux = Damage.newCopy(self)
      copy = w.clone()
      
      @weapons.each {|x|
        index=arrayContainsType(copy, x)
        if(index==-1)
          aux.weapons.delete(x)
        else
          copy.delete_at(index)
        end
      }
      
      if(@nShields>s.size)
        aux.nShields=s.size
      end
      
return aux

=end