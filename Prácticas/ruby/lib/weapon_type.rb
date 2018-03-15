=begin
Representa a los tipos de armas del juego. Cada valor posible del tipo
enumerado tendrá asociado un valor numérico concreto igual a la potencia de disparo de cada tipo
de arma.
=end

module Deepspace
  module WeaponType
     class Type
       def initialize (another_power)
         @power= another_power
       end
       
       attr_reader :power
     end

     LASER= Type.new(2.0)
     MISSILE= Type.new(3.0)
     PLASMA= Type.new(4.0)
  end
end
