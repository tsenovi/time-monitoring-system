package protocol;

import Authentication.PublicAccount;
import client.Client;

public class ProtocolManagerImpl {

    private final ProtocolDatabase protocolDatabase;

    public ProtocolManagerImpl() {
        this.protocolDatabase = new ProtocolDatabase();
    }

    public void createProtocol(PublicAccount account, Client client, int workingTime) {
        Protocol currentProtocol = new Protocol(account);
        currentProtocol.addWorkingTimeForClient(client, workingTime);
        protocolDatabase.addProtocol(currentProtocol);
    }
}
