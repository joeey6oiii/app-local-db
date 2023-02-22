package helpFun;

import java.util.Scanner;

public class Decision {
    private static final Scanner scanner = new Scanner(System.in);

    public static String decision(String par1, String par2) {
        String decision = "";
        while (!decision.equalsIgnoreCase(par1) && !decision.equalsIgnoreCase(par2)) {
            System.out.print("$ ");
            decision = scanner.nextLine();
        }
        return decision;
    }

    public static String decision(String par1, String par2, String par3) {
        String decision = "";
        while (!decision.equalsIgnoreCase(par1)
                && !decision.equalsIgnoreCase(par2)
                && !decision.equalsIgnoreCase(par3)) {
            System.out.print("$ ");
            decision = scanner.nextLine();
        }
        return decision;
    }
}
