import authentication.AuthenticatorImpl;
import client.ClientManagerImpl;
import console.ConsoleManagerImpl;
import system.ProgramRunner;

public class App {

    public static void main(String[] args) {

        new ProgramRunner(
                new AuthenticatorImpl(),
                new ClientManagerImpl(),
                new ConsoleManagerImpl()
        ).start();
    }
}
