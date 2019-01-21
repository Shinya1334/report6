package jp.ac.uryukyu.ie.e185740;
import static spark.Spark.*;
import java.util.Scanner;


import spark.Request;
import spark.Response;
import spark.Route;

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
                break;
            default:
                System.out.println("そのような値は用意していません。");
                break;
        }


    }
}