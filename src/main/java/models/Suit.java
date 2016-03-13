package models;

import java.io.Serializable;
/**
 * Created by Jason Ye on 3/8/2016.
 */
public enum Suit implements Serializable {
    Hearts, Spades, Diamonds, Clubs, BadSuit
}

//Bad suit is used in testing for functions that return type Suit
