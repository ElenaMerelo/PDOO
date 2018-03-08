=begin
Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
y/o medallas
=end

module Deepspace
  class Loot
    def initialize(supplies, weapons, shields, hangars, medals)
      @nSupplies= supplies
      @nWeapons= weapons
      @nShields= shields
      @nHangars= hangars
      @nMedals= medals
    end
    
    attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals
  end
end
