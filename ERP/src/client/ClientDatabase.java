package client;

import java.util.List;

public interface ClientDatabase {
    List<Client> getClients();

    void addClient(Client client);

    boolean clientExist(String clientName);
}
