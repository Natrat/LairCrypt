package game.Data;

import java.util.ArrayList;
import java.util.List;

public class MessageLog {
    private static List<String> messageLog = new ArrayList<>();

    public void displayMessages() {
        if (!messageLog.isEmpty())
            System.out.printf("%n" + messageLog + "%n%n");
    }

    public void addMessage(String text) {
        if (text == null || text.isEmpty())
            return;
        messageLog.add(text);
    }

    public void clearMessageLog() {
        messageLog.clear();
    }

    public List<String> drain() {
        List<String> copy = new ArrayList<>(messageLog);
        messageLog.clear();
        return copy;
    }
}
