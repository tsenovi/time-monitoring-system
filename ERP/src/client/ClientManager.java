package client;

import java.util.Date;
import java.util.List;

public interface ClientManager {
    List<Client> getClients();

    boolean registerClient(String clientName, String clientProject, Date contractEndDate);
}
