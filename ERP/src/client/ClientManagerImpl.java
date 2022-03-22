package client;

public class ClientManagerImpl {

    private final ClientDatabase clientDatabase;

    public ClientManagerImpl() {
        this.clientDatabase = new ClientDatabase();
    }

    public ClientDatabase getClientDatabase() {
        return clientDatabase;
    }
}
