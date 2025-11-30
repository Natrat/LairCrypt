package game.Managers;

public class PlayerControls {

    public static boolean isUp(String input) {
        return "w".equalsIgnoreCase(input);
    }

    public static boolean isDown(String input) {
        return "s".equalsIgnoreCase(input);
    }

    public static boolean isLeft(String input) {
        return "a".equalsIgnoreCase(input);
    }

    public static boolean isRight(String input) {
        return "d".equalsIgnoreCase(input);
    }

    public static boolean isInventory(String input) {
        return "i".equalsIgnoreCase(input);
    }

    public static boolean isJournal(String input) {
        return "j".equalsIgnoreCase(input);
    }

    public static boolean isSelect(String input) {
        return "e".equalsIgnoreCase(input);
    }
}
