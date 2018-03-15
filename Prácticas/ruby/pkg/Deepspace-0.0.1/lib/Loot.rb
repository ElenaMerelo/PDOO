=begin
Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
y/o medallas
=end

module Deepspace
  class Loot
    attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals

    def initialize(supplies, weapons, shields, hangars, medals)
      @nSupplies= supplies
      @nWeapons= weapons
      @nShields= shields
      @nHangars= hangars
      @nMedals= medals
    end
    
    def to_s
      "nSupplies #{@nSupplies}, nWeapons #{@nWeapons}, nShields #{@nShields}, nHangars #{@nHangars}, nMedals #{@nMedals}"
    end
    
  end
end
