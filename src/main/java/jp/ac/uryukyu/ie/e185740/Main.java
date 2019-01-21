package jp.ac.uryukyu.ie.e185740;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("遊びたいゲームの数字を入力してください選択してください。");
        System.out.println("1:ポーカー 2:ブラックジャック");
        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        switch (val)
        {
            case 1:
                Poker poker = new Poker();
                poker.start();
                break;
            case 2:
                System.out.println("ただいま準備中です");
                break;
            default:
                System.out.println("そのような値は用意していません。");
                break;
        }


    }
}