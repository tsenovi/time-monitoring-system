package protocol;

import authentication.PublicAccount;
import client.Client;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ProtocolManagerImpl implements ProtocolManager {

    private final ProtocolDatabase protocolDatabase;

    public ProtocolManagerImpl() {
        this.protocolDatabase = new ProtocolDatabaseImpl();
    }

    @Override
    public Map<Client, Integer> getWorkingTimesPerClientByEmployeeName(String empName) {
        return protocolDatabase.getProtocols().stream()
                .filter(protocol -> protocol.getEmployee().userName.equalsIgnoreCase(empName))
                .map(Protocol::getWorkingTimesPerClient)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Pair::getClient))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                        .mapToInt(Pair::getWorkingTime)
                        .sum()));
    }

    @Override
    public void createProtocol(Date date, PublicAccount account, List<Pair> workingTimesPerClient) {
        Protocol currentProtocol = new Protocol(date, account, workingTimesPerClient);
        protocolDatabase.addProtocol(currentProtocol);
    }

    @Override
    public Map<PublicAccount, Integer> getWorkingTimePerEmployeePerWeek(int weekNum) {
     return protocolDatabase.getProtocols().stream()
                .filter(protocol -> protocol.getWeekNum() == weekNum)
                 .collect(Collectors.groupingBy(Protocol::getEmployee))
                 .entrySet().stream()
                 .collect(Collectors.toMap(Map.Entry::getKey,
                         entry -> entry.getValue().stream()
                                 .map(Protocol::getWorkingTimesPerClient)
                                 .flatMap(Collection::stream)
                                 .mapToInt(Pair::getWorkingTime)
                                 .sum()));
    }
}
