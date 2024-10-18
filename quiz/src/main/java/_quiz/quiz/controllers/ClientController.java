package _quiz.quiz.controllers;

import _quiz.quiz.entity.ClientEntity;
import _quiz.quiz.entity.ProductEntity;
import _quiz.quiz.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientEntity createProduct(@RequestBody ClientEntity client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientEntity> updateProduct(@PathVariable Long id, @RequestBody ClientEntity clientDetails) {
        ClientEntity updatedClient = clientService.updateClient(id, clientDetails);
        return ResponseEntity.ok(updatedClient);
    }
}
