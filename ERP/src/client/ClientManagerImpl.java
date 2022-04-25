package client;

import java.util.Date;
import java.util.List;

public class ClientManagerImpl implements ClientManager {

    private static ClientManagerImpl instance;
    private final ClientDatabase clientDatabase;

    private ClientManagerImpl() {
        this.clientDatabase = ClientDatabaseImpl.getInstance();
    }

    public static ClientManagerImpl getInstance() {
        ClientManagerImpl result = instance;
        if (result == null) {
            instance = result = new ClientManagerImpl();
        }
        return result;
    }

    @Override
    public List<Client> getClients() {
        return clientDatabase.getClients();
    }

    @Override
    public boolean registerClient(String clientName, String clientProject, Date contractEndDate) {
        if (clientDatabase.clientExist(clientName)) {
            return false;
        }

        Client client = new Client(clientName, clientProject, contractEndDate);
        clientDatabase.addClient(client);
        return true;
    }
}
