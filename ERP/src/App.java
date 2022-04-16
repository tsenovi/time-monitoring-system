import authentication.AuthenticatorImpl;
import client.ClientManagerImpl;
import console.ConsoleManagerImpl;
import protocol.ProtocolManagerImpl;
import system.ProgramRunner;

public class App {

    public static void main(String[] args) {

        new ProgramRunner(
                AuthenticatorImpl.getInstance(),
                ClientManagerImpl.getInstance(),
                ConsoleManagerImpl.getInstance(),
                ProtocolManagerImpl.getInstance()
        ).start();
    }
}
