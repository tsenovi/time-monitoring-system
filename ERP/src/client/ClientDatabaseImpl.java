package client;

import parse.IOcontroller;

import java.util.List;
import java.util.Optional;

public class ClientDatabaseImpl implements ClientDatabase {

    private static final String CLIENTS_FILE = "clients.db";

    public ClientDatabaseImpl() {

    }

    @Override
    public List<Client> getClients() {
        return List.copyOf(IOcontroller.loadFile(CLIENTS_FILE));
    }

    @Override
    public void addClient(Client client) {
        List<Client> clients = IOcontroller.loadFile(CLIENTS_FILE);
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
