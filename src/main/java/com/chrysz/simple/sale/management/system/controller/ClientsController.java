package com.chrysz.simple.sale.management.system.controller;

import com.chrysz.simple.sale.management.system.model.Clients;
import com.chrysz.simple.sale.management.system.service.Impl.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {
        @Autowired
        private ClientsService clientsService;

        @GetMapping
        public ResponseEntity<List<Clients>> getAllClients() {
                List<Clients> clients  = clientsService.getAllClients();
                return ResponseEntity.ok(clients);

        }

        @PostMapping
        public ResponseEntity<Clients> createClient(@RequestBody Clients clients) {
                return clientsService.createClient(clients);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Clients> updateClient(@PathVariable(value = "id") Long clientId, @RequestBody Clients clientDetails) {
                Clients updatedClient = clientsService.updateClient(clientId, clientDetails);
                return ResponseEntity.ok(updatedClient);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long clientId) {
                clientsService.deleteClient(clientId);
                return ResponseEntity.ok().build();
        }
}
