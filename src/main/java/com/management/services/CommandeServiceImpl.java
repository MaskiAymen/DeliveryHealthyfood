package com.management.services;

import com.management.entities.Commande;
import com.management.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    CommandeRepository commandeRepository;
    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande getCommande(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);

    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    @Override
    public Page<Commande> getAllCommandesByPage(int page, int size) {
        return commandeRepository.findAll(PageRequest.of(page, size));
    }
}
