package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Brandon on 3/9/2016.
 */
public class testCard
{
    @Test
    public void testCards()
    {
        Cards test = new Cards(2, Suit.Diamonds);
        assertEquals(Suit.Diamonds, test.suit);
        assertEquals(2, test.value);
    }

    @Test
    public void testGetSuit()
    {
        Cards test = new Cards(2, Suit.Diamonds);
        assertEquals(Suit.Diamonds, test.getSuit());
    }

    @Test
    public void testGetValue()
    {
        Cards test = new Cards(2, Suit.Diamonds);
        assertEquals(2, test.getValue());
    }

    @Test
    public void testToString()
    {
        Cards test = new Cards(2, Suit.Diamonds);
        assertEquals("2Diamonds", test.toString());
    }
}
