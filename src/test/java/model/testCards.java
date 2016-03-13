package model;

import models.Cards;
import models.Suit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jason Ye on 3/12/2016.
 */
public class testCards {

    @Test
    public void testToString(){
        Cards c = new Cards(7, Suit.Diamonds);
        assertEquals("7Diamonds", c.toString());
    }
}
