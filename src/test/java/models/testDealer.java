package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Jason Ye on 3/12/2016.
 */
public class testDealer {

    @Test
    public void testStartHand(){
        Game g = new Game();
        assertEquals(7,g.dealer.DealerHand.size());
    }
}
