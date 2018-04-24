package probando;

class otraClase {
  private int atributo;

  otraClase() {
    this.atributo = 111;
  }

  void copiaAtributo(otraClase o) {
    atributo= o.atributo;
  }
}

public class otro {
  public static void main(String[] args) {
    otraClase o=new otraClase();
    otraClase o2=new otraClase();
    o2.copiaAtributo(o);
  }
}