package client;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) && projectName.equals(client.projectName) && contractEndDate.equals(client.contractEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectName, contractEndDate);
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
