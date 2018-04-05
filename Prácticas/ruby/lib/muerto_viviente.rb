class MiClase
  attr_reader :saludo 
  def initialize palabro= "holiwis"
    @saludo= palabro
  end
end

mc1 = MiClase.new("hola")
mc2 = MiClase.new("hola")
mc3 = mc1

puts "#{mc1 == mc2}"
puts "#{mc1 == mc3}"
puts "#{mc2 == mc3}"

puts "#{mc1.equal?mc2}"
puts "#{mc1.equal?mc3}"
puts "#{mc2.equal?mc3}"
