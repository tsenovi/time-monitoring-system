package protocol;

import Authentication.PublicAccount;
import client.Client;

import java.util.Date;
import java.util.HashMap;

public class Protocol {

    private final Date protocolDate;
    private final PublicAccount employee;
    private final HashMap<Client, Integer> workingTimesPerClient;

    public Protocol(PublicAccount employee, HashMap<Client, Integer> workingTimesPerClient) {
        this.protocolDate = new Date();
        this.employee = employee;
        this.workingTimesPerClient = workingTimesPerClient;
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

    @Override
    public String toString() {
        return "Protocol{" +
               "protocolDate=" + protocolDate +
               ", employee=" + employee +
               ", workingTimesPerClient=" + workingTimesPerClient +
               '}';
    }
}
