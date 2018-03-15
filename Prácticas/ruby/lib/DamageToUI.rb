
module Deepspace

# 2.3.17 - Translation from Java
# @author Profesor
    
class DamageToUI
  
  attr_reader :nWeapons, :weapons, :nShields
  
  def initialize (d) 
    @nWeapons=d.nWeapons
    @nShields=d.nShields
    tmp=d.weapons
    if (tmp!=nil) then
      @weapons=Array.new(tmp)
    else
      @weapons=nil
    end
  end
    
  public
  
  def getWeaponInfo() 
    out = "";
    
    if (nWeapons == -1) then
      out += "[" + @weapons.join(", ") + "]"
    else
      out += @nWeapons.to_s
    end
    return out
  end
    
  def to_s
    out = "Weapons: " + getWeaponInfo() + ", Shields: #{@nShields}"
  end
  
end # class

end # module
