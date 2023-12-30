package Homeworks.HW00;

public class printIndexed {
    /*
    * @param input input text
    *  */
    static void printIndexedMethod(String input) {
        int length = input.length() - 1;
        int iter = 0;
        String out = "";

        while (length > -1) {
            out = out + input.charAt(iter) + length;
            length -= 1;
            iter += 1;
        }

        System.out.println(out);
    }

    public static void main(String[] args) {
        printIndexedMethod("ZELDA");
    }
}
