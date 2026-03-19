package repository;

import model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public Client save(Client client) {
        clients.add(client);
        return client;
    }

    public Optional<Client> findById(int id) {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst();
    }

    public Optional<Client> findByPhone(String phone) {
        return clients.stream()
                .filter(client -> client.getPhone().equals(phone))
                .findFirst();
    }

    public List<Client> findByName(String namePart) {
        return clients.stream()
                .filter(client -> client.getFullName().toLowerCase().contains(namePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    public boolean update(Client updatedClient) {
        Optional<Client> existingClient = findById(updatedClient.getId());
        if (existingClient.isPresent()) {
            Client client = existingClient.get();
            client.setFullName(updatedClient.getFullName());
            client.setPhone(updatedClient.getPhone());
            client.setPassport(updatedClient.getPassport());
            client.setEmail(updatedClient.getEmail());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return clients.removeIf(client -> client.getId() == id);
    }

    public void clear() {
        clients.clear();
    }
}