/**
 *
 * @author elena
 */
package probando;

public class clase {
    private int atributo;
    clase() {
        this.atributo= 11;
    }
    
    int get_attr(){
        return atributo;
    }
    
    void set_attr(int b){
        atributo= b;
    }
    
    void copiaAtributo(clase o) {
        this.atributo= o.atributo;
    }
}
