package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Created by Brandon on 3/9/2016.
 */
public class Card implements Serializable
{
    public final int value;
    public final Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit )
    {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() { return suit; }

    public int getValue() { return value; }

    public String toString() { return this.value + this.suit.toString(); }
}
