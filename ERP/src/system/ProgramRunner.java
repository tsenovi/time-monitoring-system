package system;

import Authentication.AuthenticatorImpl;
import Authentication.PublicAccount;
import client.Client;
import client.ClientManagerImpl;
import console.ConsoleManagerImpl;
import protocol.ProtocolManagerImpl;

import java.util.HashMap;
import java.util.List;

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
            createProtocolForTodayProcess();
        }
    }

    private void createProtocolForTodayProcess() {
        PublicAccount employee = authenticator.getLoggedAccount();
        List<Client> clients = clientManager.getClientDatabase().getClients();
        HashMap<Client, Integer> workingTimesPerClient = getClientIntegerHashMap(clients);

        protocolManager.createProtocol(employee, workingTimesPerClient);
    }

    private HashMap<Client, Integer> getClientIntegerHashMap(List<Client> clients) {
        HashMap<Client, Integer> workingTimesPerClient = new HashMap<>();

        while (true) {
            consoleManager.printList(clients);
            consoleManager.show("Select client: ");
            Client selectedClient = clients.get(consoleManager.getListIndexInput(clients));
            consoleManager.show("Select working time in minutes: ");
            int selectedWorkingTime = consoleManager.getDecimalInput();
            workingTimesPerClient.put(selectedClient, selectedWorkingTime);

            consoleManager.show("Continue Y/N?");
            String userChoice = consoleManager.getTextInput();
            if (userChoice.equalsIgnoreCase("n")) break;
        }
        return workingTimesPerClient;
    }
}
