package com.chrysz.simple.sale.management.system.service.Impl;

import com.chrysz.simple.sale.management.system.model.Clients;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientsService {
    List<Clients> getAllClients();

    ResponseEntity<Clients> createClient(Clients clients);

    Clients updateClient(Long clientId, Clients clientDetails);

    void deleteClient(Long clientId);
}
