package console;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManagerImpl implements ConsoleManager {

    private static ConsoleManagerImpl instance;
    private final Scanner scanner;

    private ConsoleManagerImpl() {
        this.scanner = new Scanner(System.in);
    }

    public static ConsoleManagerImpl getInstance() {
        ConsoleManagerImpl result = instance;
        if (result == null) {
            instance = result = new ConsoleManagerImpl();
        }
        return result;
    }

    @Override
    public String getTextInput() {
        return scanner.nextLine();
    }

    @Override
    public int getDecimalInput() {
        String numberInput = getTextInput();
        while (!numberInput.matches("[0-9]+")) {
            show("Invalid input, try again: ");
            numberInput = getTextInput();
        }
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
            System.out.println(entry.getKey() + " : " + entry.getValue() + " minutes");
        }
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public void showAdminOptions() {
        show("""
                \tAdmin Options:
                1. Logout
                2. Create client
                3. Register employee
                4. Employee statistics""");
    }

    @Override
    public void showEmployeeOptions() {
        show("""
                \tEmployee Options:
                1. Logout
                2. Create protocol""");
    }

    @Override
    public void showStatisticsOptions() {
        show("""
                \tStatistics by:
                1. Employee name
                2. Week number""");
    }
}
