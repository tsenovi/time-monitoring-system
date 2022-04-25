package protocol;

import parse.ControllerIO;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDatabaseImpl implements ProtocolDatabase {

    private static ProtocolDatabaseImpl instance;
    private static final String PROTOCOLS_FILE = "protocols.db";

    private ProtocolDatabaseImpl() {

    }

    public static ProtocolDatabaseImpl getInstance() {
        ProtocolDatabaseImpl result = instance;
        if (result == null) {
            instance = result = new ProtocolDatabaseImpl();
        }
        return result;
    }

    @Override
    public List<Protocol> getProtocols() {
        return List.copyOf(ControllerIO.loadFile(PROTOCOLS_FILE));
    }

    @Override
    public void addProtocol(Protocol protocol) {
        List<Protocol> protocols = ControllerIO.loadFile(PROTOCOLS_FILE);
        if (protocols == null) protocols = new ArrayList<>();
        protocols.add(protocol);
        ControllerIO.overwriteFile(PROTOCOLS_FILE, protocols);
    }
}
