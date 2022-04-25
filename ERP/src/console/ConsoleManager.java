package console;

import java.util.List;
import java.util.Map;

public interface ConsoleManager {
    String getTextInput();

    int getDecimalInput();

    <T> int getListIndexInput(List<T> list);

    <T> void printList(List<T> list);

    void show(String text);

    void showAdminOptions();

    void showEmployeeOptions();

    void showStatisticsOptions();

    <K, V> void printMap(Map<K, V> map);
}
