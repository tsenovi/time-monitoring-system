package system;

import authentication.Authenticator;
import authentication.LoginStatus;
import authentication.PublicAccount;
import client.Client;
import client.ClientManager;
import console.ConsoleManager;
import parse.DateParser;
import protocol.ProtocolManagerImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramRunner {

    private final Authenticator authenticator;
    private final ClientManager clientManager;
    private final ConsoleManager consoleManager;
    private final ProtocolManagerImpl protocolManager;

    public ProgramRunner(Authenticator authenticator, ClientManager clientManager, ConsoleManager consoleManager) {
        this.authenticator = authenticator;
        this.clientManager = clientManager;
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
            case 2 -> createNewClient();
            case 3 -> createNewEmployee();
            case 4 -> viewStatisticsForEmployees();
            default -> consoleManager.show("No such option!");
        }
    }

    private void viewStatisticsForEmployees() {
        consoleManager.showStatisticsOptions();
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> runStatisticsByEmployeeName();
            case 2 -> runStatisticsByWeekNumber();
            default -> consoleManager.show("No such option!");
        }
    }

    //TODO
    private void runStatisticsByWeekNumber() {

    }
    //TODO
    private void runStatisticsByEmployeeName() {
        consoleManager.printList(authenticator.getEmployees());
        consoleManager.show("Choose employee number:");
        int accountChoice = consoleManager.getListIndexInput(authenticator.getEmployees());
        String empName = authenticator.getEmployees().get(accountChoice).userName;

        Map<Client, Integer> workingTimesPerClient = protocolManager.getWorkingTimesPerClientByEmployeeName(empName);
        consoleManager.printMap(workingTimesPerClient);
    }

    private void createNewEmployee() {
        consoleManager.show("Enter employee name: ");
        String empName = consoleManager.getTextInput();
        consoleManager.show("Enter employee password: ");
        String empPass = consoleManager.getTextInput();
        boolean isRegistered = authenticator.registerEmployee(empName, empPass);
        if (isRegistered){
            consoleManager.show("New employee was successfully registered!");
        } else {
            consoleManager.show("This employee already exists!");
        }
    }

    private void createNewClient() {
        consoleManager.show("Enter client name: ");
        String clientName = consoleManager.getTextInput();
        consoleManager.show("Enter client project name: ");
        String clientProject = consoleManager.getTextInput();
        consoleManager.show("Enter contract end date: " + DateParser.DATE_FORMAT);
        String contractEndDate = consoleManager.getTextInput();

        boolean isRegistered = clientManager.registerClient(clientName, clientProject, contractEndDate);
        if (isRegistered){
            consoleManager.show("New client was successfully registered!");
        } else {
            consoleManager.show("This client already exists! ");
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
