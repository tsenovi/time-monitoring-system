package system;

import authentication.Authenticator;
import authentication.AuthenticatorImpl;
import authentication.LoginStatus;
import authentication.PublicAccount;
import client.Client;
import client.ClientManagerImpl;
import console.ConsoleManager;
import console.ConsoleManagerImpl;
import protocol.ProtocolManagerImpl;

import java.util.HashMap;
import java.util.List;

public class ProgramRunner {

    private final Authenticator authenticator;
    private final ClientManagerImpl clientManager;
    private final ConsoleManager consoleManager;
    private final ProtocolManagerImpl protocolManager;

    public ProgramRunner(Authenticator authenticator, ConsoleManager consoleManager) {
        this.authenticator = authenticator;
        this.clientManager = new ClientManagerImpl();
        this.consoleManager = consoleManager;
        this.protocolManager = new ProtocolManagerImpl();
    }

    public void start() {
        while (true) {
            consoleManager.show("\tEmployee Tracking System");
            if (authenticator.hasLoggedAccount()) {
                processAccountOptions();
            } else {
                startLoginProcess();
            }
        }
    }

    private void startLoginProcess() {
        consoleManager.show("Please login to continue!");
        String username = getCredentials("Username: ");
        String password = getCredentials("Password: ");

        LoginStatus loginStatus = authenticator.login(username, password);
        if (loginStatus == LoginStatus.LOGIN_FAILED) {
            consoleManager.show("Login failed!");
        } else {
            consoleManager.show("Login successful!");
        }
    }

    private void processAccountOptions() {
        if (authenticator.hasLoggedAdmin()) {
            runAdminOptions();
        } else {
            runEmployeeOptions();
        }
    }

    private void runAdminOptions() {
        consoleManager.showAdminOptions();
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            default -> consoleManager.show("No such option!");
        }
    }

    private void runEmployeeOptions() {
        consoleManager.showEmployeeOptions();
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            case 2 -> createProtocolForTodayProcess();
            default -> consoleManager.show("No such option!");
        }
    }

    private String getCredentials(String text) {
        consoleManager.show(text);
        return consoleManager.getTextInput();
    }

    private void createProtocolForTodayProcess() {
        PublicAccount employee = authenticator.getLoggedAccount();
        List<Client> clients = clientManager.getClients();
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
