package protocol;

import parse.IOcontroller;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDatabaseImpl implements ProtocolDatabase {

    private static final String PROTOCOLS_FILE = "protocols.db";

    public ProtocolDatabaseImpl() {

    }

    @Override
    public List<Protocol> getProtocols() {
        return List.copyOf(IOcontroller.loadFile(PROTOCOLS_FILE));
    }

    @Override
    public void addProtocol(Protocol protocol) {
        List<Protocol> protocols = IOcontroller.loadFile(PROTOCOLS_FILE);
        if (protocols == null) protocols = new ArrayList<>();
        protocols.add(protocol);
        IOcontroller.overwriteFile(PROTOCOLS_FILE, protocols);
    }
}
