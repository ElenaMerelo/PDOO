/**
 * @author Elena Merelo Molina
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTestP1 {
    @Test
    public void TestLoot(){
        Loot l= new Loot(1, 2, 3, 4, 5);
        assertEquals(1, l.getNSupplies());
        assertEquals(2, l.getNWeapons());
        assertEquals(3, l.getNShields());
        assertEquals(4, l.getNHangars());
        assertEquals(5, l.getNMedals());
    }
    
}
