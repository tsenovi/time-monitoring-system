package console;

import java.util.Scanner;

public class ConsoleManagerImpl implements ConsoleManager {
    private final Scanner sc;

    public ConsoleManagerImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public String getTextInput() {
        return sc.nextLine();
    }

    @Override
    public int getDecimalInput() {
        String numberInput;
        do {
            numberInput = getTextInput();
        } while (!numberInput.matches("[0-9]+"));
        return Integer.parseInt(numberInput);
    }
}
