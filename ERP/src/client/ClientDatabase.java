package client;

import parse.DateParser;

import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {

    private final List<Client> clients;

    public ClientDatabase() {
        this.clients = new ArrayList<>();
        initDefaultClients();
    }

    private void initDefaultClients() {
        clients.add(new Client("Nestle Ltd.", "Recipes Management System", DateParser.parse("01/10/2022", "00:00")));
        clients.add(new Client("SpaceX Ltd.", "Trajectory Triangulation For SpaceShip Lending Objects", DateParser.parse("01/01/2024", "00:00")));
        clients.add(new Client("Payhawk Ltd.", "Self Accounting Issued Invoices Module", DateParser.parse("08/08/2023", "00:00")));
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClientById(long id) {
        for (Client client : clients) {
            if (client.getClientId() == id) {
                return client;
            }
        }

        return null;
    }

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }

        return null;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public boolean clientExist(String clientName){
        return getClient(clientName) !=  null;
    }
}
