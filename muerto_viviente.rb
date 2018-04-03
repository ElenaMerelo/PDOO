class MuertoViviente
  attr_reader :dedos_de_frente

  def initialize(unFloat)
    @dedos_de_frente= unFloat
    @edad= 30
  end

  def asustar
    'uuuuuuuuuuuu'
  end

  def presentar
   puts "tengo #{self.dedos_de_frente} dedos y #{miEdad} lustros #{asustar}"
  end

  protected

  def comer
    'rico rico'
  end

  def miEdad
    @edad-5
  end

  private :miEdad, :asustar

end

otroZombi= MuertoViviente.new(2.2)
otroZombi.presentar
# otroZombi.comer da error al ser protected no se puede acceder desde fuera
# otroZombi.asustar es privado, no va
