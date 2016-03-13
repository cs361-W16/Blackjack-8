package models;

import java.util.ArrayList;

/**
 *
 */
public class Player{
    public int pot;
    public int split;
    public int PlayerBet;
    public java.util.List<Cards> PlayerHand;
    public java.util.List<Cards> SplitHand = new ArrayList<>();
    boolean turnEnd;

    public Player(){
        super();
        pot = 100;
        PlayerBet = 2;
        PlayerHand = new ArrayList<>();
        turnEnd = false;
    }

    public void addHand(Cards card){
        PlayerHand.add(card);
    }

    //Four actions for player: hit, stand, double down, or spit
    public void hit(ArrayList<Cards> deck){
        addHand(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }

    public void stand(){
        turnEnd = true;
    }

    public boolean bet(){
        if(PlayerBet > pot){
            return false;
        }else{
            pot = pot - PlayerBet;
            return true;
        }
    }

    public boolean doubleDown(ArrayList<Cards> deck){
        if(!bet()){
            return false;
        }else{
            hit(deck);
            stand();
            return true;
        }
    }

    // split to temp hand, then move half of origninal hand to SplitHand
    public void split(){
        split = 1;
        Cards tmp;
        tmp = PlayerHand.get(PlayerHand.size()-1);
        SplitHand.add(tmp);
        PlayerHand.remove(PlayerHand.size()-1);
        bet();
    }

    public int getValueTotal(){
        int sum = 0;
        int suitValue;
        int aces = 0;
        for (int i = 0; i < PlayerHand.size(); i++) {
            suitValue = PlayerHand.get(i).getValue();
            if (suitValue > 9){
                suitValue = 10;
            }else if(suitValue == 1){
                aces++;
                suitValue = 11;
            }
            sum += suitValue;
        }

        if(sum > 21) {
            for (int i = 0; i < aces; i++) {
                sum -= 10;
                if (sum < 22)
                    break;
            }
        }
        return sum;
    }
}
