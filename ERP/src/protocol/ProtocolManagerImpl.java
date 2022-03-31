package protocol;

import authentication.PublicAccount;
import client.Client;

import java.util.HashMap;

public class ProtocolManagerImpl {

    private final ProtocolDatabase protocolDatabase;

    public ProtocolManagerImpl() {
        this.protocolDatabase = new ProtocolDatabase();
    }

    public void createProtocol(PublicAccount account, HashMap<Client, Integer> workingTimesPerClient) {
        Protocol currentProtocol = new Protocol(account, workingTimesPerClient);
        protocolDatabase.addProtocol(currentProtocol);
    }
}
