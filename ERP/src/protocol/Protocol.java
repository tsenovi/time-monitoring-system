package protocol;

import Authentication.PublicAccount;
import client.Client;

import java.util.Date;
import java.util.HashMap;

public class Protocol {

    private final Date protocolDate;
    private final PublicAccount employee;
    private final HashMap<Client, Integer> workingTimesPerClient;

    public Protocol(PublicAccount employee) {
        this.protocolDate = new Date();
        this.employee = employee;
        this.workingTimesPerClient = new HashMap<>();
    }

    public Date getProtocolDate() {
        return protocolDate;
    }

    public PublicAccount getEmployee() {
        return employee;
    }

    public HashMap<Client, Integer> getWorkingTimesPerClient() {
        return workingTimesPerClient;
    }

    public void addWorkingTimeForClient(Client client, int workingTime){
        workingTimesPerClient.put(client, workingTime);
    }

    @Override
    public String toString() {
        return "Protocol{" +
               "protocolDate=" + protocolDate +
               ", employee=" + employee +
               ", workingTimesPerClient=" + workingTimesPerClient +
               '}';
    }
}
