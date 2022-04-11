package client;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {

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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", projectName='" + projectName + '\'' +
                ", contractEndDate=" + contractEndDate +
                '}';
    }
}
