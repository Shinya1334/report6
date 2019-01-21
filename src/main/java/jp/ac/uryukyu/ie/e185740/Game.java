package jp.ac.uryukyu.ie.e185740;
import java.util.HashMap;
public class Game {
    private int[][] playingcard;
    private double point;

    Game()
    {
        playingcard =  install_card();
        point = 0;
    }
    int[][] install_card ()
    {
        /**
         *
         * card[i] 0 = スペード、1 = クラブ、　2 = ダイヤ、　3 = ハート
         */
        int[][] card = new int[4][13];
        for (int i= 0;i < 4 ;i++)
        {
            for(int j = 0;j<13;j++)
            {
                int input = j +1;
                card[i][j] = input;
            }
        }
        return card;
    }
    public int[][] getPlayingcard() {
        return playingcard;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point += point;
    }
}
