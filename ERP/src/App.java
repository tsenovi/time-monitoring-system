import authentication.AuthenticatorImpl;
import console.ConsoleManagerImpl;
import system.ProgramRunner;

public class App {

    public static void main(String[] args) {

        new ProgramRunner(
                new AuthenticatorImpl(),
                new ConsoleManagerImpl()
        ).start();
    }
}
