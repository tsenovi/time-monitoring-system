package client;

import authentication.AuthenticatorImpl;
import parse.IOcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDatabaseImpl implements ClientDatabase {

    private static final String CLIENTS_FILE = "clients.db";
    private static ClientDatabaseImpl instance;

    private ClientDatabaseImpl() {
    }

    public static ClientDatabaseImpl getInstance(){
        ClientDatabaseImpl result = instance;
        if (result == null){
            instance = result = new ClientDatabaseImpl();
        }
        return result;
    }

    @Override
    public List<Client> getClients() {
        return List.copyOf(IOcontroller.loadFile(CLIENTS_FILE));
    }

    @Override
    public void addClient(Client client) {
        List<Client> clients = IOcontroller.loadFile(CLIENTS_FILE);
        if (clients == null) clients = new ArrayList<>();
        clients.add(client);
        IOcontroller.overwriteFile(CLIENTS_FILE, clients);
    }

    @Override
    public boolean clientExist(String clientName) {
        return getClient(clientName) != null;
    }

    private Client getClient(String name) {
        List<Client> clients = IOcontroller.loadFile(CLIENTS_FILE);
        Optional<Client> first = clients.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();

        return first.orElse(null);
    }
}
