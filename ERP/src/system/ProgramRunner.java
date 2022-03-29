package system;

import Authentication.AuthenticatorImpl;
import client.ClientManagerImpl;
import console.ConsoleManagerImpl;
import protocol.ProtocolManagerImpl;

public class ProgramRunner {

    private AuthenticatorImpl authenticator;
    private ClientManagerImpl clientManager;
    private ConsoleManagerImpl consoleManager;
    private ProtocolManagerImpl protocolManager;

    public ProgramRunner() {
        this.authenticator = new AuthenticatorImpl();
        this.clientManager = new ClientManagerImpl();
        this.consoleManager = new ConsoleManagerImpl();
        this.protocolManager = new ProtocolManagerImpl();
    }

    public void start() {
        while (true) {
            consoleManager.show("\tEmployee Tracking System");
        }
    }
}
