package commands;

import dataBase.DataBase;

import java.io.IOException;
import java.util.Scanner;

public class Exit extends BaseCommand {

    public void execute(DataBase obj) {
        System.out.println("Are you sure you want to end the program?");
        System.out.println("Enter [y/n]");
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (true) {
            try {
                System.out.print("$ ");
                str = scanner.next();
            } catch (Exception e) {
                System.out.println("Enter [y/n]");
            }
            if (str.equalsIgnoreCase("Y"))
                System.exit(0);
            if (str.equalsIgnoreCase("N"))
                return;
            System.out.println("Enter [y/n]");
        }
    }


    public void describe() {
        System.out.println("Closes the program without saving");
    }
}
