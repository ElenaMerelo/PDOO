=begin
Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
y/o medallas
=end

require_relative "LootToUI"

module Deepspace
  class Loot
    attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals, :getEfficient, :spaceCity

    protected
    def initialize(supplies, weapons, shields, hangars, medals, ef, city)
      @nSupplies= supplies
      @nWeapons= weapons
      @nShields= shields
      @nHangars= hangars
      @nMedals= medals
      @getEfficient= ef 
      @spaceCity= city
    end
    
    public
    def to_s
      "nSupplies #{@nSupplies}, nWeapons #{@nWeapons}, nShields #{@nShields}, nHangars #{@nHangars}, nMedals #{@nMedals}"
    end
    
    def getUIversion
      LootToUI.new(self)
    end
    
  end
end
