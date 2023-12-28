package Homeworks.HW00;

public class starTriangle {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i ++) {
            String out = "*";
            for (int k = 1; k < i; k ++) {
                out += "*";
            }
            System.out.println(out);
        }
    }
}
