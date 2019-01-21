package jp.ac.uryukyu.ie.e185740;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {
    @Test
    void card_list_check() {
        int[]demo =new int[5];
        for (int loop=0;loop < 5 ; loop++)
        {
            demo[loop]=4;
        }
        Poker poker = new Poker();
        poker.card_list_check(demo);
    }
}