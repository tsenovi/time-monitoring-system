package protocol;

import Authentication.PublicAccount;
import Authentication.AccountDatabase;
import client.Client;
import client.ClientDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProtocolDatabase {

    private final Set<Protocol> protocols;

    public ProtocolDatabase() {
        this.protocols = new HashSet<>();
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void addProtocol(Protocol protocol) {
        protocols.add(protocol);
    }
}
