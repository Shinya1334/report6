package jp.ac.uryukyu.ie.e185740;
import java.util.HashMap;
public class Game {
    String[][] playingcard;
    int point;

    Game()
    {
        playingcard =  install_card();
        point = 0;
    }
    String[][] install_card ()
    {
        /**
         *
         * card[i] 0 = スペード、1 = クラブ、　2 = ダイヤ、　3 = ハート
         */
        String[][] card = new String[4][13];
        for (int i= 0;i < 4 ;i++)
        {
            for(int j = 0;j<13;j++)
            {
                int input = j +1;
                card[i][j] = Integer.toString(input);
            }
        }
        return card;
    }
}
