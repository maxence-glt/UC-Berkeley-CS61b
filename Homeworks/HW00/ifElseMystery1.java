package Homeworks.HW00;

public class ifElseMystery1 {
    public static void ifElseMystery1(int x, int y) {
        int z = 4;
        if (z <= x) {
            z = x + 1;
        } else {
            z = z + 9;
        }
        if (z <= y) {
            y++;
        }
        System.out.println (z + " " + y);
    }

    public static void main(String[] args) {
        ifElseMystery1(3, 20); // 4 21
        ifElseMystery1(4, 5); // 5 6
        ifElseMystery1(5, 5); // 6 5
        ifElseMystery1(6, 10); // 7 11
    }

}
