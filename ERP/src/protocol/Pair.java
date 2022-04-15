package protocol;

import client.Client;

import java.io.Serializable;

public class Pair implements Serializable {

    private Client client;
    private int workingTime;

    public Pair(Client client, int workingTime) {
        this.client = client;
        this.workingTime = workingTime;
    }

    public Client getClient() {
        return client;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "client=" + client +
                ", workingTime=" + workingTime +
                '}';
    }
}
