package console;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManagerImpl implements ConsoleManager {
    private final Scanner sc;

    public ConsoleManagerImpl() {
        this.sc = new Scanner(System.in);
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

    @Override
    public <T> int getListIndexInput(List<T> list) {
        int indexInput = getDecimalInput();
        while (indexInput < 1 || indexInput > list.size()) {
            show("Invalid input, try again: ");
            indexInput = getDecimalInput();
        }

        return indexInput - 1;
    }

    @Override
    public <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).toString());
        }
    }

    @Override
    public <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public void showAdminOptions() {
        show("""
                1. Logout
                2. Create new client
                3. Register new employee
                4. Employee statistics""");
    }

    @Override
    public void showEmployeeOptions() {
        show("""
                1. Logout
                2. Create protocol for today""");
    }

    @Override
    public void showStatisticsOptions() {
        show("""
                \tSearch by:
                1. Employee name
                2. Week number""");
    }
}
