package protocol;

import authentication.AuthenticatorImpl;
import parse.IOcontroller;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDatabaseImpl implements ProtocolDatabase {

    private static final String PROTOCOLS_FILE = "protocols.db";
    private static ProtocolDatabaseImpl instance;

    private ProtocolDatabaseImpl() {

    }

    public static ProtocolDatabaseImpl getInstance(){
        ProtocolDatabaseImpl result = instance;
        if (result == null){
            instance = result = new ProtocolDatabaseImpl();
        }
        return result;
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
