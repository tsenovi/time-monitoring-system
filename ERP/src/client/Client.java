package client;

import java.util.Date;

public class Client {

    private final String name;
    private final String projectName;
    private final Date contractEndDate;

    public Client(String name, String projectName, Date contractEndDate) {
        this.name = name;
        this.projectName = projectName;
        this.contractEndDate = contractEndDate;
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
