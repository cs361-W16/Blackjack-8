package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Created by Jason Ye on 3/12/2016.
 */
public class testDealer {

    @Test
    public void testStartHand(){
        Game g = new Game();
        assertEquals(7,g.dealer.DealerHand.size());
    }

    @Test
    public void testDealerHand(){
        Game g = new Game();
        assertNotNull(g.dealer.DealerHand);
    }

    @Test
    public void testDealTwo(){
        Game g = new Game();
        assertEquals(7,g.dealer.DealerHand.size());
        assertEquals(8,g.dealer.DealerHand.size());
    }
}
