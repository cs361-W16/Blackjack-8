package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Jason Ye on 3/9/2016.
 */
public class Game {
    public ArrayList<Cards> deck = new ArrayList<Cards>();;
    public Player player;
    public Dealer dealer;
    public int state, playerScore, dealerScore, playerScoreSplit;
    public boolean playerBust, dealerBust, playerBustSplit;
    public int win, winSplit;
    //win = 0 [tie] | 1 [player wins] | 2 [dealer wins] | 3 [player wins with blackjack]


    public Game(){
        state = 1;
        buildDeck();
        shuffle();
        player = new Player();
        dealer = new Dealer();
        //play
    }


    public void play()
    {
		win = -1; 
		winSplit = -1;
		if(player.turnEnd == true)
		{
			playerBust = player.getBust();
			playerScore = player.valueTotal();
			dealer.less17(deck);
			dealerBust = dealer.getBust();
			dealerScore = dealer.valueTotal();

			//Normal hand
			if((dealerBust == false) && (playerBust == false))
			{
				if((player.PlayerHand.size() == 2) && (playerScore == 21))
				{
					if((dealer.DealerHand.size() == 2) && (dealerScore == 21)){
						win = 0;
						player.winnings(win);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					} else {
						win = 3;
						player.winnings(win);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					}
				} else if (playerScore > dealerScore)
				{
					win = 1;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				} else if (dealerScore > playerScore)
				{
					win = 0;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				}
			} else if ((dealerBust == true) && (playerBust == false))
			{
				if((player.PlayerHand.size() == 2) && (playerScore == 21))
				{
					win = 3;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				} else
				{
					win = 1;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				}
			} else if ((playerBust == true) && (dealerBust == false))
			{
				win = 2;
				player.winnings(win);
				player.turnEnd = false;
				player.PlayerHand.clear();
				player.SplitHand.clear();
				dealer.DealerHand.clear();
				deck.clear();
				buildDeck();
				shuffle();
				return;
			} else
			{
				win = 0;
				player.winnings(win);
				player.turnEnd = false;
				player.PlayerHand.clear();
				player.SplitHand.clear();
				dealer.DealerHand.clear();
				deck.clear();
				buildDeck();
				shuffle();
				return;
			}

			//If player split
			if(player.split == 1)
			{
				playerBustSplit = player.getBustSplit();
				playerScoreSplit = player.valueTotalSplit();

				if((dealerBust == false) && (playerBustSplit == false))
				{
					if((player.SplitHand.size() == 2) && (playerScoreSplit == 21))
					{
						if((dealer.DealerHand.size() == 2) && (dealerScore == 21)){
							winSplit = 0;
							player.winnings(winSplit);
							player.turnEnd = false;
							player.PlayerHand.clear();
							player.SplitHand.clear();
							dealer.DealerHand.clear();
							deck.clear();
							buildDeck();
							shuffle();
							return;
						} else {
							winSplit = 3;
							player.winnings(winSplit);
							player.turnEnd = false;
							player.PlayerHand.clear();
							player.SplitHand.clear();
							dealer.DealerHand.clear();
							deck.clear();
							buildDeck();
							shuffle();
							return;
						}
					} else if (playerScoreSplit > dealerScore)
					{
						winSplit = 1;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					} else if (dealerScore > playerScoreSplit)
					{
						winSplit = 0;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					}
				} else if ((dealerBust == true) && (playerBustSplit == false))
				{
					if((player.SplitHand.size() == 2) && (playerScoreSplit == 21))
					{
						winSplit = 3;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					} else
					{
						winSplit = 1;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					}
				} else if ((playerBustSplit == true) && (dealerBust == false))
				{
					winSplit = 2;
					player.winnings(winSplit);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				} else
				{
					winSplit = 0;
					player.winnings(winSplit);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				}
			}
		}else if(player.turnEnd == false)
		{
			
			playerBust = player.getBust();
			playerScore = player.valueTotal();
			
			if(playerBust == true){
				
				dealer.less17(deck);
				dealerBust = dealer.getBust();
				dealerScore = dealer.valueTotal();
				
				if(dealerBust == true){
					
					win = 1;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
					
				}else{
					
					win = 0;
					player.winnings(win);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
					
				}
			}
			//If player split
			if(player.split == 1)
			{
				playerBustSplit = player.getBustSplit();
				playerScoreSplit = player.valueTotalSplit();

				if((dealerBust == false) && (playerBustSplit == false))
				{
					if((player.SplitHand.size() == 2) && (playerScoreSplit == 21))
					{
						if((dealer.DealerHand.size() == 2) && (dealerScore == 21)){
							winSplit = 0;
							player.winnings(winSplit);
							player.turnEnd = false;
							player.PlayerHand.clear();
							player.SplitHand.clear();
							dealer.DealerHand.clear();
							deck.clear();
							buildDeck();
							shuffle();
						return;
						} else {
							winSplit = 3;
							player.winnings(winSplit);
							player.turnEnd = false;
							player.PlayerHand.clear();
							player.SplitHand.clear();
							dealer.DealerHand.clear();
							deck.clear();
							buildDeck();
							shuffle();
							return;
						}
					} else if (playerScoreSplit > dealerScore)
					{
						winSplit = 1;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					} else if (dealerScore > playerScoreSplit)
					{
						winSplit = 0;
						player.winnings(winSplit);
						return;
					}
				} else if ((dealerBust == true) && (playerBustSplit == false))
				{
					if((player.SplitHand.size() == 2) && (playerScoreSplit == 21))
					{
						winSplit = 3;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					} else
					{
						winSplit = 1;
						player.winnings(winSplit);
						player.turnEnd = false;
						player.PlayerHand.clear();
						player.SplitHand.clear();
						dealer.DealerHand.clear();
						deck.clear();
						buildDeck();
						shuffle();
						return;
					}
				} else if ((playerBustSplit == true) && (dealerBust == false))
				{
					winSplit = 0;
					player.winnings(winSplit);
					player.turnEnd = false;
					player.PlayerHand.clear();
					player.SplitHand.clear();
					dealer.DealerHand.clear();
					deck.clear();
					buildDeck();
					shuffle();
					return;
				} else
				{
					winSplit = 0;
					player.winnings(winSplit);
					return;
				}
			}
			
		}
        //Whatever we want to happen after the game ends
    }

    public void buildDeck(){
        
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
