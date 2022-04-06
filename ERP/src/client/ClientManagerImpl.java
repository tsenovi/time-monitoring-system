package client;

import parse.DateParser;

import java.util.Date;
import java.util.List;

public class ClientManagerImpl {

    private final ClientDatabase clientDatabase;

    public ClientManagerImpl() {
        this.clientDatabase = new ClientDatabase();
    }

    public List<Client> getClients() {
        return clientDatabase.getClients();
    }

    public boolean registerClient(String clientName, String clientProject, String contractEndDate){
        Date endDate = DateParser.dateParse(contractEndDate);
        if (clientDatabase.clientExist(clientName)){
            return false;
        }
        Client client = new Client(clientName, clientProject, endDate);
        clientDatabase.addClient(client);
        return true;
    }
}
