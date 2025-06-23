package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.exceptions.ClientNotFoundException;
import br.edu.ifpb.biblioteca.model.Client;
import br.edu.ifpb.biblioteca.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<Client> getAllClients(int page, int size) {
        return clientRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(String name, String phone, String email, String password, String address) {
        Client newClient = new Client();
        newClient.setName(name);
        newClient.setPhone(phone);
        newClient.setEmail(email);
        newClient.setPassword(password);
        newClient.setAddress(address);

        return clientRepository.save(newClient);
    }

    public Client updateClient(Long id, String name, String phone, String email, String password, String address) {
        Optional<Client> existingClient = getClientById(id);

        if(existingClient.isEmpty()) {
            throw new ClientNotFoundException();
        }

        Client updatedClient = existingClient.get();
        updatedClient.setName(name);
        updatedClient.setPhone(phone);
        updatedClient.setEmail(email);
        updatedClient.setPassword(password);
        updatedClient.setAddress(address);

        return clientRepository.save(updatedClient);
    }

    public void deleteClient(Long id) {
        Optional<Client> existingClient = getClientById(id);

        if(existingClient.isEmpty()) {
            throw new ClientNotFoundException();
        }

        clientRepository.deleteById(id);
    }

    public Page<Client> findClientByName(String name, int page, int size) {
        return clientRepository.findByName(name, PageRequest.of(page, size));
    }
}