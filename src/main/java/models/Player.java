package models;

import java.util.ArrayList;

/**
 * Reference: Group 11 by 2016.
 */
public class Player{
    public int pot;
    public int PlayerBet;
    public java.util.List<Cards> hand;
    boolean turnEnd;

    public Player(){
        super();
        pot = 100;
        PlayerBet = 0;
        hand = new ArrayList<>();
        turnEnd = false;
    }

    public void addHand(Cards card){
        hand.add(card);
    }

    //Four actions for player: hit, stand, double down, or spit
    public void hit(ArrayList<Cards> deck){
        addHand(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }

    public void stand(){
        turnEnd = true;
    }

    public boolean bet(int bet){
        if(bet > pot || bet < 0){
            return false;
        }else{
            PlayerBet = bet;
            return true;
        }
    }

    public boolean doubleDown(ArrayList<Cards> deck){
        if(bet(PlayerBet*2) == false){
            return false;
        }else{
            hit(deck);
            stand();
            return true;
        }
    }

    //split
    //public int split

    public int getValueTotal(){
        int sum = 0;
        int suitValue;
        int aces = 0;
        for (int i = 0; i < hand.size(); i++) {
            suitValue = hand.get(i).getValue();
            if (suitValue > 9){
                suitValue = 10;
            }else if(suitValue == 1){
                aces++;
                suitValue = 11;
            }
            sum += suitValue;
        }

        if(sum == 21) {
            System.out.printf("YOU WIN!");
        }else if(sum > 21) {
            for (int i = 0; i < aces; i++) {
                sum -= 10;
                if (sum < 22)
                    break;
            }
        }
        return sum;
    }
}
