/*
 * @brief Programa para probar lo que voy aprendiendo de java 
 * @author Elena Merelo 
 */
package lapicero;

public class Lapicero {
    //Atributos de instancia
    private bool is_clean;
    private int num_serie;
    private int portaminas;
    private final String color;
    
    //Atributos de clase
    private static final double precio= 9.99;
    private static int num_lapiceros= 0;
    
    //Constructor 
    public Lapicero(bool esta_limpio, int num_portaminas, String un_color){
        is_clean= esta_limpio;
        portaminas= num_portaminas;
        num_serie= Lapicero.get_num_lapiceros();
        Lapicero.incrementa_num_lapiceros();
    }
    
    //Métodos de instancia
    public int get_num_serie(){
        return num_serie;
    }
    
    public int get_num_portaminas(){
        return portaminas;
    }
    
    public bool get_info(){
        return is_clean;
    }
    
    public String get_color(){
        return color;
    }
    
    //Métodos de clase 
    public static int get_num_lapiceros(){
        return num_lapiceros;
    }
    
    public static double get_precio(){
        return precio;
    }
    
    public static void incrementa_num_lapiceros(){
        num_lapiceros++;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
