package client;

import parse.DateParser;

import java.util.Date;
import java.util.List;

public class ClientManagerImpl implements ClientManager {

    private final ClientDatabase clientDatabase;

    public ClientManagerImpl() {
        this.clientDatabase = new ClientDatabaseImpl();
    }

    @Override
    public List<Client> getClients() {
        return clientDatabase.getClients();
    }

    @Override
    public boolean registerClient(String clientName, String clientProject, String contractEndDate){
        if (clientDatabase.clientExist(clientName)){
            return false;
        }

        Date endDate = DateParser.parse(contractEndDate);
        Client client = new Client(clientName, clientProject, endDate);
        clientDatabase.addClient(client);
        return true;
    }
}
