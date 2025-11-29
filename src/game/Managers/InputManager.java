package game.Managers;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);


    public String readLine(String prompt){
        System.out.print("\n" + prompt);
        String line = scanner.nextLine();
        return line.trim().toLowerCase();
    }
}