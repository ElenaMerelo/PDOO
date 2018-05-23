/**
 * @author Elena Merelo
 */

import org.junit.*;
import static org.junit.Assert.*;


public class WeaponTypeTest {
    private WeaponType l = WeaponType.LASER;
    private WeaponType m = WeaponType.MISSILE;
    private WeaponType p = WeaponType.PLASMA;
    
    @Test
    public void test_content(){
       assertNotNull("l es null", l);
       assertNotNull("m es null", m);
       assertNotNull("p es null", p);
    }
    
    @Test
    public void test_power(){
        assertEquals("Error en getPower de l", 2.0f, l.getPower());
        assertEquals("Error en getPower de m", 3.0f, m.getPower());
        assertEquals("Error en getPower de p", 4.0f, p.getPower());
    }
    
}
