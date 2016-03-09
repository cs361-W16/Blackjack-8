package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Jason Ye on 3/8/2016.
 */
public class Cards implements Serializable {
    public final int value;
    public final Suit suit;

    @JsonCreator
    public Cards(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return this.value + this.suit.toString();
    }
}
