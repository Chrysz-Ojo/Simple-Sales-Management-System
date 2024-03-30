package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.exception.ResourceNotFoundException;
import com.chrysz.simple.sale.management.system.model.Clients;
import com.chrysz.simple.sale.management.system.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientsServiceImpl implements ClientsService{
    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();

    }

    @Override
    public ResponseEntity<Clients> createClient(Clients clients) {
        Clients createdClient = clientsRepository.save(clients);
        return ResponseEntity.ok(createdClient);
    }




    @Override
    public Clients updateClient(Long clientId, Clients clientDetails) {
        // Retrieve the existing client entity from the database
        Optional<Clients> optionalClient = clientsRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            // Client exists, update its details
            Clients existingClient = optionalClient.get();
            existingClient.setFirstName(clientDetails.getFirstName());
            existingClient.setLastName(clientDetails.getLastName());
            existingClient.setMobile(clientDetails.getMobile());
            existingClient.setEmail(clientDetails.getEmail());
            existingClient.setAddress(clientDetails.getAddress());

            // Save the updated client entity to the database
            return clientsRepository.save(existingClient);
        } else {
            // Client not found, throw ResourceNotFoundException
            throw new ResourceNotFoundException("Client not found with id: " + clientId);
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        clientsRepository.deleteById(clientId);
    }
}


