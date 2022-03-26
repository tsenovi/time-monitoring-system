package client;

import java.util.Date;

public class Client {
    private static int clientCount = 0;
    private final long clientId;
    private final String name;
    private final String projectName;
    private final Date contractEndDate;

    public Client(String name, String projectName, Date contractEndDate) {
        clientCount++;
        this.clientId = clientCount;
        this.name = name;
        this.projectName = projectName;
        this.contractEndDate = contractEndDate;
    }

    public long getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }
}
