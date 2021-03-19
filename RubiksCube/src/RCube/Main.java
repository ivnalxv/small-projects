package RCube;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player p = new Player(args, true);
        p.play();

        /*
        System.out.println(p);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            if (s.equals("B")) {
                p.turn(Turn.B);
            } else if (s.equals("L")) {
                p.turn(Turn.L);
            } else if (s.equals("R")) {
                p.turn(Turn.R);
            } else if (s.equals("U")) {
                p.turn(Turn.U);
            } else if (s.equals("D")) {
                p.turn(Turn.D);
            } else if (s.equals("F")) {
                p.turn(Turn.F);
            } else {
                System.out.println("UNKNOWN TURN!!!");
            }
        }
         */
    }
}
