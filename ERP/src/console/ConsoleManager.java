package console;

import java.util.List;

public interface ConsoleManager {
    String getTextInput();

    int getDecimalInput();

    <T> int getListIndexInput(List<T> list);

    <T> void printList(List<T> list);

    void show(String text);
}
