package models;

import javax.smartcardio.Card;
import java.util.ArrayList;

/**
 * Created by Jason Ye on 3/9/2016.
 */
public class Dealer{
    public java.util.List<Cards> DealerHand;
    boolean turnEnd;

    Dealer(){
        DealerHand = new ArrayList<>();
        turnEnd = false;
    }

    public void addhand(Cards card){
        DealerHand.add(card);
    }

    public void hit(ArrayList<Cards> deck){
        addhand(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }

    public void stand(){
        turnEnd = true;
    }

    public int getValueTotal(){
        int sum = 0;
        int suitValue;
        int aces = 0;
        for (int i = 0; i < DealerHand.size(); i++) {
            suitValue = DealerHand.get(i).getValue();
            if (suitValue > 9){
                suitValue = 10;
            }else if(suitValue == 1){
                aces++;
                suitValue = 11;
            }
            sum += suitValue;
        }

        if(sum > 21){
            for(int i = 0; i < aces; i++) {
                sum -= 10;
                if (sum < 22)
                    break;
            }
        }
        return sum;
    }

    public void less17(ArrayList<Cards> deck){
        while(getValueTotal() < 17){
            hit(deck);
        }
        stand();
    }
}
