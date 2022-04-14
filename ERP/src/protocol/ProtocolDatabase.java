package protocol;

import parse.IOcontroller;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDatabase {

    private static final String PROTOCOLS_FILE = "protocols.db";

    public ProtocolDatabase() {

    }

    public List<Protocol> getProtocols() {
        return List.copyOf(IOcontroller.loadFile(PROTOCOLS_FILE));
    }

    public void addProtocol(Protocol protocol) {
//      List<Protocol> protocols = IOcontroller.loadFile(PROTOCOLS_FILE);
        List<Protocol> protocols = new ArrayList<>();
        protocols.add(protocol);
        IOcontroller.overwriteFile(PROTOCOLS_FILE, protocols);
    }
}
