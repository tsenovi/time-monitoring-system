import authentication.AuthenticatorImpl;
import client.ClientManagerImpl;
import console.ConsoleManagerImpl;
import protocol.ProtocolManagerImpl;
import system.ProgramRunner;

public class App {

    public static void main(String[] args) {

        new ProgramRunner(
                new AuthenticatorImpl(),
                new ClientManagerImpl(),
                new ConsoleManagerImpl(),
                new ProtocolManagerImpl()
        ).start();
    }
}
