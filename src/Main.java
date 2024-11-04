import tokenizer.SimpleTokenizerImpl;
import uinterface.ConsoleInterface;

public class Main {
    public static void main(String[] args) {
        ConsoleInterface<String> consoleInterface = new ConsoleInterface<>(new SimpleTokenizerImpl());
        consoleInterface.processUserInput();
    }
}