package model;

import models.Cards;
import models.Suit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jason Ye on 3/10/2016.
 */
public class testCards {

    @Test
    public void testSuit(){
        Cards c = new Cards(7,Suit.Hearts);
        assertEquals(Suit.Hearts,c.getSuit());
    }
    @Test
    public void testString(){
        Cards c = new Cards(7, Suit.Hearts);
        assertEquals("7Hearts",c.toString());
    }
    @Test
    public void testValue(){
        Cards c = new Cards(7, Suit.Diamonds);
        assertEquals(7, c.getValue());
    }
    
}
