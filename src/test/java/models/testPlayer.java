package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Brandon on 3/13/2016.
 */
public class testPlayer
{
    @Test
    public void testAddHand()
    {
        Player test = new Player();
        Cards c1 = new Cards(2, Suit.Diamonds);

        test.addHand(c1);
        assertEquals(2, test.getCardValue(0));
        assertEquals(Suit.Diamonds, test.getCardSuit(0));
    }

    @Test
    public void testGetCardValue()
    {
        Player test = new Player();
        Cards c1 = new Cards(2, Suit.Diamonds);

        test.addHand(c1);
        assertEquals(2, test.getCardValue(0));

        assertEquals(0, test.getCardValue(3));
    }

    @Test
    public void testGetCardSuit()
    {
        Player test = new Player();
        Cards c1 = new Cards(2, Suit.Diamonds);

        test.addHand(c1);
        assertEquals(Suit.Diamonds, test.getCardSuit(0));

        assertEquals(Suit.BadSuit, test.getCardSuit(3));
    }

    @Test
    public void testHit()
    {
        Game test = new Game();
        int handSize = test.player.PlayerHand.size();

        test.player.hit(test.deck);
        int handHitSize = test.player.PlayerHand.size();
        assertNotEquals(handSize, handHitSize);
    }

    @Test
    public void testStand()
    {
        Game test = new Game();

        assertEquals(false, test.player.turnEnd);
        test.player.stand();
        assertEquals(true, test.player.turnEnd);
    }

    @Test
    public void testBet()
    {
        Game test = new Game();
        int playerPot = test.player.pot;
        boolean pass;

        pass = test.player.bet();
        int playerBet = test.player.pot;
        assertEquals(pass, true);
        assertNotEquals(playerPot, playerBet);

        test.player.pot = 0;
        pass = test.player.bet();
        assertEquals(pass, false);
    }

    @Test
    public void testDoubleDown()
    {
        Game test = new Game();
        int playerPot = test.player.pot;
        int handSize = test.player.PlayerHand.size();
        boolean pass;

        assertEquals(test.player.turnEnd, false);

        pass = test.player.doubleDown(test.deck);
        int handHitSize = test.player.PlayerHand.size();
        assertNotEquals(handSize, handHitSize);
        assertEquals(test.player.turnEnd, true);
        assertEquals(pass, true);

        test.player.pot = 0;
        pass = test.player.doubleDown(test.deck);
        assertEquals(pass, false);
    }

    @Test
    public void testSplit()
    {
        Player test = new Player();
        Cards c1 = new Cards(5, Suit.Diamonds);
        Cards c2 = new Cards(5, Suit.Diamonds);

        test.addHand(c1);
        test.addHand(c2);
        assertEquals(test.split, 0);
        assertEquals(test.PlayerHand.size(), 2);
        assertEquals(test.SplitHand.size(), 0);

        test.split();
        assertEquals(test.split, 1);
        assertEquals(test.PlayerHand.size(), 1);
        assertEquals(test.SplitHand.size(), 1);
    }

    @Test
    public void testGetValueTotal()
    {
        Player test = new Player();
        Cards c1 = new Cards(5, Suit.Diamonds);
        Cards c2 = new Cards(5, Suit.Diamonds);
        Cards c3 = new Cards(10, Suit.Diamonds);
        Cards c4 = new Cards(1, Suit.Diamonds);

        assertEquals(test.getValueTotal(), 0);

        test.addHand(c1);
        test.addHand(c2);
        assertEquals(test.getValueTotal(), 10);

        test.addHand(c3);
        assertEquals(test.getValueTotal(), 20);

        test.addHand(c4);
        assertEquals(test.getValueTotal(), 21);
    }
}
