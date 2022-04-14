package protocol;

import authentication.PublicAccount;
import client.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class ProtocolManagerImpl {

    private final ProtocolDatabase protocolDatabase;

    public ProtocolManagerImpl() {
        this.protocolDatabase = new ProtocolDatabase();
    }

    public Map<Client, Integer> getWorkingTimesPerClientByEmployeeName(String empName) {
        return protocolDatabase.getProtocols()
                .stream()
                .filter(protocol -> protocol.getEmployee().userName.equalsIgnoreCase(empName))
                .map(Protocol::getWorkingTimesPerClient)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
    }

    public void createProtocol(PublicAccount account, HashMap<Client, Integer> workingTimesPerClient) {
        Protocol currentProtocol = new Protocol(account, workingTimesPerClient);
        protocolDatabase.addProtocol(currentProtocol);
    }
}
