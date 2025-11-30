package game.UserInterface;

import java.util.Scanner;
import java.nio.file.Path;

public class Display {
    private static final int CURSOR_OFFSET = 2;
    private static final String CURSOR = "<---";

    public static void drawMainMenu(String selectableString) {
        // Takes in selectionTracker, gives it to printFromFile
        printFromFile("Assets/UI/mainmenu.txt", selectableString);
    }

    public static void drawMainMenuDeveloper(String selectableString){
        printFromFile("Assets/UI/developer.txt", selectableString);
    }

    public static void printFromFile(String path, String selectableString) {
        Path p = Path.of(path);
        try (Scanner scanner = new Scanner(p)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (selectableString != null)
                    if (line.contains(selectableString))
                        line = addCursorToLine(line, selectableString);
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printFromFile(String path) {
        Path p = Path.of(path);
        try (Scanner scanner = new Scanner(p)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String addCursorToLine(String line, String selectableString) {
        int marker = line.indexOf(selectableString) + selectableString.length() + CURSOR_OFFSET; // starting point of where we want to add the cursor
        String beforeString = line.substring(0, marker); // the line up until where we want to add cursor
        String afterString = line.substring(marker + CURSOR.length(), line.length()); // the line after the word we want to replace, starting from after where cursor is
        return beforeString + CURSOR + afterString;
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Fallback if something goes wrong
            System.out.print("\033[H\033[2J");
            // System.out.print("\\033[H");
            System.out.flush();
        }
    }
}
