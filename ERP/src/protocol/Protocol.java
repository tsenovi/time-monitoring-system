package protocol;

import Authentication.PublicAccount;
import client.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Protocol {

    private Date protocolDate;
    private PublicAccount employee;
    private List<clientTime<Client, Integer>> clients;

    public Protocol(Date protocolDate, PublicAccount employee) {
        this.protocolDate = protocolDate;
        this.employee = employee;
        this.clients = new ArrayList<>();
    }

    public Date getProtocolDate() {
        return protocolDate;
    }

    public PublicAccount getEmployee() {
        return employee;
    }

    public List<clientTime<Client, Integer>> getClientAndTime() {
        return clients;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "protocolDate=" + protocolDate +
                ", employee=" + employee +
                ", clients=" + clients +
                '}';
    }
}
