class Padre
  @@deClaseA=11
  @deClaseB=22
  @duda=33
  
  def initialize
    @duda=3
  end
  
  attr_reader :duda
  
  def self.deClaseA
    @@deClaseA
  end
  
  def self.deClaseB
    @deClaseB
  end
  
  def self.duda
    @duda
  end
  
  def desdeInstancia
    puts @duda
    puts self.class.duda
    puts self.class.deClaseB
    puts @@deClaseA
  end
  
end

class Hija < Padre
end

p=Padre.new
puts Padre.deClaseA
puts Padre.deClaseB
puts Padre.duda
p.desdeInstancia
puts "==="
puts Padre.deClaseA.object_id
puts Hija.deClaseA.object_id
puts Padre.deClaseB.object_id
puts Hija.deClaseB.object_id
puts Padre.duda.object_id
puts Hija.duda.object_id