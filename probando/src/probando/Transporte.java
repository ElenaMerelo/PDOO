/**
 *
 * @author elena
 */

package probando; 

public abstract class Transporte {
    private String empresa;
    private int capacidad;
    private String estado;
    protected abstract void desplazarse();
    protected abstract void add_vehiculo(Transporte t);
}


