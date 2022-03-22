package client;

import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {

    private final List<Client> clients;

    public ClientDatabase() {
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }

        return null;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
}
