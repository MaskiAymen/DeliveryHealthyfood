package com.management.services;

import com.management.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommandeService {
    Commande saveCommande(Commande commande);
    Commande updateCommande(Commande commande);
    Commande getCommande(Long id);
    List<Commande> getAllCommandes();
    void deleteCommandeById(Long id);
    void deleteAllCommandes();
    Page<Commande> getAllCommandesByPage(int page, int size);
}
