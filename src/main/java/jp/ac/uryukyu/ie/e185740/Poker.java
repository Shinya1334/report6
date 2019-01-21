package jp.ac.uryukyu.ie.e185740;
import java.util.Random;
import java.util.HashMap;
import java.util.*;

/**
 * ポーカークラス。
 *  HashMap<Integer, String> pattern; //トランプの絵柄の情報
 *  HashMap<Integer, String> role; //ポーカーにおける役の順位
 * Created by e185740 on 2018/1/21.
 */

public class Poker extends Game {
    private HashMap<Integer, String> pattern = new HashMap<>();//[1]
    private HashMap<Double, String> role = new HashMap<>();//[1]
    private int CARD_LENGHT=13;
    private int DESIGN_CARD_LENGHT=4;
    private int HAND =5;

    Poker() {
        super();
        this.role.put(0.0,"ノーペア");
        this.role.put(1.5,"ワンペア");
        this.role.put(3.0,"ツーペア");
        this.role.put(4.0,"スリーカード");
        this.role.put(5.5,"フラッシュ");
        this.role.put(6.0,"フルハウス");
        this.role.put(8.0,"フォーカード");

        this.pattern.put(0, "♤");//[2]
        this.pattern.put(1, "♧");//[3]
        this.pattern.put(2, "♢");
        this.pattern.put(3, "♡");
    }
    /**
     * pokerを開始する為のメソッド
     * 最初はramdom関数を利用してトランプの中からdisignとnumberをそれぞれ５つ抽出している。
     */
    void start() {
        String[] design_card = new String[HAND];
        int[] card_list = new int[HAND];
        Random random = new Random();
        for (int i = 0; i < HAND; i++) {

            int design = random.nextInt(3);
            int your_card_number = getPlayingcard()[design][random.nextInt(CARD_LENGHT)];
            if (check(design, your_card_number)) {
                i -= 1;
            } else {
                design_card[i] = pattern.get(design);
                card_list[i] = your_card_number;
                System.out.println(design_card[i]+card_list[i]);
            }
        }
        card_design_check(design_card);
        card_list_check(card_list);
        role_card(getPoint());
    }
    /**
     * カードが配られる際のすでに使用しているかどうかの判定
     * @param design 絵柄情報
     * @param card トランプの数字の情報
     * @return 使用されていた場合はfalseを返す
     */
    boolean check(int design, int card) {
        boolean used = true;
        for (int j = 0; j < CARD_LENGHT; j++) {
            if (getPlayingcard()[design][j] == card) {
                used = false;
                return used;
            }
        }
        return used;
    }
    /**
     * 絵柄が揃っているかどうかを判定する
     * @param card_design トランプの絵柄情報
     */

    void card_design_check(String[] card_design) {
        int count = 1;
        for (int i = 0; i < DESIGN_CARD_LENGHT; i++) {
            if (!card_design[0].equals(card_design[count])) {
                count += 1;
            }
        }
        if(count==1)
            setPoint(5.5);
    }
    /**
     * 数字が揃っていて役ができているかを判定する。
     * @param card_list トランプの数字の情報
     */


    void card_list_check(int[] card_list) {
        Map<Integer, Integer> m = new HashMap<>();

        int v;
        for (int s : card_list)
        {
            if (m.containsKey(s)) {
                // Mapに登録済み
                v = m.get(s) + 1;
            } else {
                // Mapに未登録
                v = 1;
            }
            m.put(s,v);
                if (v == 2) {
                    setPoint(1.5);
                } else if (v == 3) {
                    setPoint(4.0);
                } else if (v == 4) {
                    setPoint(8.0);
                }else if(v==5){
                    System.out.println("トランプに5枚目のカードはありません。");
                    break;
                }
        }
    }
    /**
     * 役が揃っているかどうかを出力するメソッド
     * @param strength 役の強さ
     */


    void role_card(double strength)
    {
        System.out.println("あなたの役は"+role.get(strength)+"です。");
    }
}
