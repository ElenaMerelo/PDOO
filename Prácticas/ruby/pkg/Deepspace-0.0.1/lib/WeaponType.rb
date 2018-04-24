=begin
Representa a los tipos de armas del juego. Cada valor posible del tipo
enumerado tendrá asociado un valor numérico concreto igual a la potencia de disparo de cada tipo
de arma.
=end

module Deepspace
  module WeaponType
     class Type
       attr_reader :power
       
       def initialize (p, n)
         @power= p
         @name= n
       end
       
       def to_s
         "Name #{@name}, power #{@power}"
       end
     end

     LASER= Type.new(2.0, "LASER")
     MISSILE= Type.new(3.0, "MISSILE")
     PLASMA= Type.new(4.0, "PLASMA")
  end
end
