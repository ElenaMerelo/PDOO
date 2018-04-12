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
require_relative 'WeaponType'
require_relative 'Weapon'

module Deepspace
  class Damage
    attr_reader :nWeapons, :nShields,  :weapons
    
    def initialize(nw, ns, w)
      @nShields= ns
      
      if w == nil   #si es numericWeapons
        @weapons= nil
        @nWeapons= nw
      else
        @nWeapons= 0
        @weapons= Array.new(w)
      end  
    end
    
    def self.newNumericWeapons(w, s)
      new(w, s, nil)
    end
    
    def self.newSpecificWeapons(w1, s)
      new(nil, s, w1)
    end
    
    def self.newCopy(d)
      new(d.nWeapons, d.nShields, d.weapons)
    end
    
    def getUIversion
      DamageToUI.new(self)
    end
    
    def discardWeapon(w)
      if @weapons == nil && @nWeapons > 0
        @nWeapons -= 1
      else
        @weapons.delete_at(@weapons.index(w.type))
      end
    end
    
    def discardShieldBooster
      if @nShields > 0
        @nShields -= 1
      end
    end
    
    def hasNoEffect
      @nWeapons == 0 && @nShields == 0 && (@weapons == nil or @weapons.empty? == true)
    end
    
    def to_s
      if @weapons == nil
        "nWeapons #{@nWeapons}, nShields #{@nShields}"
      else
        "nShields #{@nShields}, weapons #{@weapons.join(",")}"

      end
    end
    
    def adjust(w, s)
      n_shields= [s.length, @nShields].min
      
      if @weapons == nil  #si son numericWeapons
        n_weapons= [w.length, @nWeapons].min  #nos quedamos con quien tenga menos armas
        
        aux= Damage.newNumericWeapons(n_weapons, n_shields)
        
      else
        #Contamos el número de weapons de cada tipo que tienen ambos vectores
        freq_1 = Hash.new(0)
        @weapons.each { |weapon_type| freq_1[weapon_type] += 1 }
        
        freq_2 = Hash.new(0)
        w.each { |weapon| freq_2[weapon.type] += 1 }
        
        min_freq= []
        l= WeaponType::LASER
        m= WeaponType::MISSILE
        p= WeaponType::PLASMA
        
        [freq_1[l], freq_2[l]].min.times { min_freq << l }
        [freq_1[m], freq_2[m]].min.times { min_freq << m }
        [freq_1[p], freq_2[p]].min.times { min_freq << p }
        
        aux= Damage.newSpecificWeapons(min_freq, n_shields)
        
      end
      aux
    end
    
    private_class_method :new
    
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


