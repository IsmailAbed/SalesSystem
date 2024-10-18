package _quiz.quiz.services;

import _quiz.quiz.entity.ClientEntity;
import _quiz.quiz.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientEntity createClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    public ClientEntity updateClient(Long id, ClientEntity clientDetails) {
        ClientEntity client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setMobile(clientDetails.getMobile());
        return clientRepository.save(client);
    }
}