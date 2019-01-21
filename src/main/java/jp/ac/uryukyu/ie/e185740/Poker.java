package jp.ac.uryukyu.ie.e185740;
import java.util.Random;
import java.util.HashMap;
import java.util.*;



public class Poker extends Game {
    private HashMap<Integer, String> hashmap = new HashMap<>();//[1]
    private HashMap<Double, String> role = new HashMap<>();//[1]
    private int CARD_LENGHT=13;
    private int DESIGN_CARD_LENGHT=4;
    private int HAND =5;

    Poker() {
        super();
        role.put(0.0,"ノーペア");
        role.put(1.5,"ワンペア");
        role.put(3.0,"ツーペア");
        role.put(4.0,"スリーカード");
        role.put(5.5,"フラッシュ");
        role.put(6.0,"フルハウス");
        role.put(8.0,"フォーカード");
    }

    void start() {
        String[] design_card = new String[HAND];
        int[] card_list = new int[HAND];
        hashmap.put(0, "♤");//[2]
        hashmap.put(1, "♧");//[3]
        hashmap.put(2, "♢");
        hashmap.put(3, "♡");
        Random random = new Random();
        for (int i = 0; i < HAND; i++) {

            int design = random.nextInt(3);
            int your_card_number = getPlayingcard()[design][random.nextInt(CARD_LENGHT)];
            if (check(design, your_card_number)) {
                i -= 1;
            } else {
                design_card[i] = hashmap.get(design);
                card_list[i] = your_card_number;
                System.out.println(design_card[i]+card_list[i]);
            }
        }
        card_design_check(design_card);
        card_list_check(card_list);
        role_card(getPoint());
    }

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
    void role_card(double strength)
    {
        System.out.println("あなたの役は"+role.get(strength)+"です。");
    }
}
