package client;

import java.util.List;

public class ClientManagerImpl {

    private final ClientDatabase clientDatabase;

    public ClientManagerImpl() {
        this.clientDatabase = new ClientDatabase();
    }

    public List<Client> getClients() {
        return clientDatabase.getClients();
    }
}
