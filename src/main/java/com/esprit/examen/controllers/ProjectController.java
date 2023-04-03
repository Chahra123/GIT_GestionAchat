package com.esprit.examen.controllers;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.services.ICategorieProduitService;
import com.esprit.examen.services.IFactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProjectController {
    private final IFactureService factureService;
    private final ICategorieProduitService categorieProduitService;

    @GetMapping
    public List<Facture> getFactures() {
        return factureService.retrieveAllFactures();
    }

    @GetMapping("/{facture-id}")

    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

    @GetMapping
    public List<CategorieProduit> getCategorieProduit() {
        List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
        return list;
    }

    @PostMapping
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit cp) {
        CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(cp);
        return categorieProduit;
    }

    @GetMapping("/{categorieProduit-id}")
    public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
    }

    @DeleteMapping("{categorieProduit-id}")
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }

    @PutMapping
    public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
        return categorieProduitService.updateCategorieProduit(categorieProduit);
    }
}
