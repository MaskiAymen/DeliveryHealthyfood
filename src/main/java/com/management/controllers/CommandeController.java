package com.management.controllers;

import com.management.entities.Commande;
import com.management.services.CommandeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @RequestMapping("/createCommande")
    public String createCommande(){
        return "CreateCommande";
    }
    @RequestMapping("/saveCommande")
    public String saveCommande(@Valid Commande commande, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())    return "CreateCommande";
        commandeService.saveCommande(commande);
        return "CreateCommande";


    }

    @RequestMapping("/commandesList")
    public String commandesList(ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2")  int size,
                                Model model){
        Page<Commande> commandesController = commandeService.getAllCommandesByPage(page, size);
        modelMap.addAttribute("commandesJsp", commandesController);
        modelMap.addAttribute("pages", new int[commandesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CommandesList";
    }
    @RequestMapping("/deleteCommande")
    public String deleteCommande(@RequestParam("id") Long id,ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2")  int size){
        commandeService.deleteCommandeById(id);
        Page<Commande> commandesController = commandeService.getAllCommandesByPage(page, size);
        modelMap.addAttribute("commandesJsp", commandesController);
        modelMap.addAttribute("pages", new int[commandesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CommandesList";

    }
    @RequestMapping("/showCommande")
    public String showCommande(@RequestParam("id") Long id,ModelMap modelMap){
        Commande commandeController = commandeService.getCommande(id);
        modelMap.addAttribute("commandeJsp",commandeController);
        return "EditCommande";

    }
    @RequestMapping("/updateCommande")
    public String updateCommande(@ModelAttribute("commande") Commande commande)  {

        commandeService.saveCommande(commande);
        return "CreateCommande";


    }



}
