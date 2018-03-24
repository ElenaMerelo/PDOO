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
    
      if w == nil
        @weapons= nil
        @nWeapons= nw
      else
        @nWeapons= nil
        @weapons= Array.new
        for i in w
          @weapons.push(i)
        end
      end  
    end
    
    def self.newNumericWeapons(w, s)
      new(w, s, nil)
    end
    
    def self.newSpecificWeapons(w1, s)
      new(0, s, w1) #w1.length
    end
    
    def self.newCopy(d)
      new(d.nWeapons, d.nShields, d.weapons)
    end
    
    def getUIversion
      DamageToUI.new(self)
    end
    
    def discardWeapon(w)
      if @weapons != nil
        indexes= Array.new
        index= 0
        for i in @weapons
          if i.type == w
            indexes.push(index)
          end
          index += 1
        end
        
        @weapons.delete_at(indexes[0])
        
      else
        if @nWeapons > 0
          @nWeapons -= 1
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
    
    def to_s
      if @weapons == nil
        "nWeapons #{@nWeapons}, nShields #{@nShields}"
      else
        "nShields #{@nShields}, weapons #{@weapons.join(",")}"

      end
    end
    
    def adjust(w, s)
      ns = [s.length, @nShields].min
      
      aux = Damage.new(nil, ns, @weapons)
      copy = Array.new(w)
      
      if @weapons != nil
        @weapons.each {|x|
          index=arrayContainsType(copy, x)

          if(index==-1)
            aux.weapons.delete_at(aux.weapons.index(x))
          else
            copy.delete_at(index)
          end
        }
      end
      aux
    end
    
    private
    def arrayContainsType(w, t)
      index= w.index(t)
      if index == nil
        -1
      else
        index
      end
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
=end