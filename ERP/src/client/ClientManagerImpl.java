package client;

import parse.DateParser;

import java.util.Date;
import java.util.List;

public class ClientManagerImpl implements ClientManager {

    private final ClientDatabase clientDatabase;
    private static ClientManagerImpl instance;

    private ClientManagerImpl() {
        this.clientDatabase = ClientDatabaseImpl.getInstance();
    }

    public static ClientManagerImpl getInstance(){
        ClientManagerImpl result = instance;
        if (result == null){
            instance = result = new ClientManagerImpl();
        }
        return result;
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
