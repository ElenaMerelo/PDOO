class A
  attr_accessor :attr
  def initialize
    @attr= 1
  end
end

class B
  attr_accessor :attr
  def initialize
    @attr= 2
  end
end

class C
  attr_accessor :attr
  def initialize(a)
    @attr= a
  end
end

class Prueba_temas_1_2
  @@a= A.new
  @b= B.new
  
  def self.b
    @b
  end
  
  def initialize
    @c= C.new(99)
  end
  
  def to_s
    @@a.attr.to_s + " " + self.class.b.attr.to_s + @c.attr.to_s
  end
  
  def modifica
    @@a.attr= 11
    @c.attr= 33
  end
  
  def modifica2
      @@a.attr= 111
      @c.attr= 333
  end
end

t1=Prueba_temas_1_2.new
t2=Prueba_temas_1_2.new
t3=t1
puts t1.to_s  #1 2 99
puts t2.to_s  #1 2 99
puts t3.to_s  #1 2 99
t1.modifica
puts t1.to_s  #11 2 33
puts t2.to_s  #11 2 99
puts t3.to_s  #11 2 33
t2.modifica2
puts t1.to_s  #111 2 33
puts t2.to_s  # 111 2 333
puts t3.to_s  # 111 2 33
