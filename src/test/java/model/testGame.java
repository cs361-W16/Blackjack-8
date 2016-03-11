package model;

import models.Game;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Jason Ye on 3/10/2016.
 */
public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }
    @Test
    public void testGameInitialize(){
        Game g = new Game();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }
    @Test
    public void testBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(48,g.deck.size());
    }
    @Test
    public void testGameStart(){
        Game g = new Game();
        g.dealTwo();
        g.buildDeck();
        g.shuffle();
    }
    @Test
    public void testDealTwo(){
        Game g = new Game();
        assertEquals(2,g.dealer.DealerHand.size());
        assertEquals(2,g.player.PlayerHand.size());
    }
}
