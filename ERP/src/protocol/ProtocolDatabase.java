package protocol;

import java.util.HashSet;
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
