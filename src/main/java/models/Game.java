package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Jason Ye on 3/9/2016.
 */
public class Game {
    public ArrayList<Cards> deck;
    public Player player;
    public Dealer dealer;

    public Game(){
        buildDeck();
        shuffle();
        player = new Player();
        dealer = new Dealer();
        dealTwo();
        //should call a play function that loops until win status has happened
    }

    public void buildDeck(){
        deck = new ArrayList<Cards>();
        for(int i = 1; i < 14; i++) {
            deck.add(new Cards(i, Suit.Clubs));
            deck.add(new Cards(i, Suit.Diamonds));
            deck.add(new Cards(i, Suit.Hearts));
            deck.add(new Cards(i, Suit.Spades));
        }
    }

    public void shuffle(){
        long shuffling = System.nanoTime();
        Collections.shuffle(deck, new Random(shuffling));
    }

    public void dealTwo() {
        if(player.bet())
        {
            for (int i = 0; i < 2; i++) {
                dealer.hit(deck);
                player.hit(deck);
            }
        }else {
            //Error Message
        }
    }
}
