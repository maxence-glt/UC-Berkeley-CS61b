package Labs.Lab02.src.bomb;

import Labs.Lab02.src.common.IntList;

public class BombMain {
    public static void main(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }

        String password2 = "";

        for (int x = 0; x < 1337 ; x++)
            password2 += "a ";

        password2 += "-81201430";

        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            b.phase1(IntList.of(0, 9, 3, 0, 8)); // Figure this out too
        }

        if (phase >= 2) {
            b.phase2(password2);
        }
    }
}
