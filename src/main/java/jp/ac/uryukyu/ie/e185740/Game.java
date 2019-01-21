package jp.ac.uryukyu.ie.e185740;
/**
 * gameクラス。
 *  int[][] playingcard; //トランプの全カード情報
 *  double point; //ポーカーにおける役の順位を数値に置き換えた変数
 * Created by e185740 on 2018/1/21.
 */
public class Game {
    private int[][] playingcard;
    private double point;

    Game()
    {
        playingcard =  install_card();
        point = 0;
    }
    /**
     *トランプのカードを生成するメソッド
     * card[i] 0 = スペード、1 = クラブ、　2 = ダイヤ、　3 = ハート
     * @return トランプのジョーカーを抜いた情報を返す
     */
    int[][] install_card ()
    {

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
