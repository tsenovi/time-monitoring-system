package protocol;

import Authentication.PublicAccount;
import Authentication.UserDatabase;
import client.Client;
import client.ClientDatabase;
import parse.DateParser;
import java.util.ArrayList;
import java.util.List;

public class ProtocolDatabase {

    private List<Protocol> protocols;
    private ClientDatabase clientsDb;
    private UserDatabase userDatabase;

    public ProtocolDatabase() {
        this.protocols = new ArrayList<>();
        this.clientsDb = new ClientDatabase();
        this.userDatabase = new UserDatabase();

    }

    private void initDefaultProtocol() {
        protocols.add(new Protocol(
                DateParser.parse("26/03/2022", "10:20"),
                userDatabase.getAccount("Ivan"),
                new ArrayList<clientTime<Client, Integer>>(new clientTime<>(clientsDb.getClientById(0), 120))
                ));

    }

    public void addProtocol(Protocol protocol){
        protocols.add(protocol);
    }


}
